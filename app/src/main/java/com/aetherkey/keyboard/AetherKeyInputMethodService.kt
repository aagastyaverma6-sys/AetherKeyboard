package com.aetherkey.keyboard

import android.annotation.SuppressLint
import android.inputmethodservice.InputMethodService
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.KeyEvent
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout

/**
 * AetherKey System InputMethodService
 * This service is registered with Android OS as a default on-screen keyboard.
 * When any text field in WhatsApp, Telegram, Chrome, Notes, etc. is focused,
 * Android launches this view to type real characters directly into the app!
 */
class AetherKeyInputMethodService : InputMethodService() {

    private var keyboardWebView: WebView? = null
    private var vibrator: Vibrator? = null

    override fun onCreate() {
        super.onCreate()
        vibrator = getSystemService(VIBRATOR_SERVICE) as? Vibrator
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateInputView(): View {
        val rootLayout = FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                resources.displayMetrics.heightPixels / 2 // Covers 50% bottom height like Gboard
            )
        }

        keyboardWebView = WebView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )

            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                cacheMode = WebSettings.LOAD_DEFAULT
                loadWithOverviewMode = true
                useWideViewPort = true
                displayZoomControls = false
            }

            // JavaScript Interface: communicates directly with currentInputConnection!
            addJavascriptInterface(KeyboardBridge(), "AndroidIME")

            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()

            // Load AetherKey local asset or URL
            loadUrl("file:///android_asset/www/index.html")
        }

        rootLayout.addView(keyboardWebView)
        return rootLayout
    }

    override fun onStartInputView(info: android.view.inputmethod.EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
        // Refresh connection
    }

    /**
     * Bridge exposed to JavaScript.
     * When any button in AetherKey is tapped, this commits text directly into WhatsApp!
     */
    inner class KeyboardBridge {

        @JavascriptInterface
        fun commitText(text: String) {
            triggerHaptic(12)
            currentInputConnection?.commitText(text, 1)
        }

        @JavascriptInterface
        fun sendBackspace() {
            triggerHaptic(18)
            currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
            currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL))
        }

        @JavascriptInterface
        fun sendEnter() {
            triggerHaptic(20)
            currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
            currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER))
        }

        @JavascriptInterface
        fun sendSpace() {
            triggerHaptic(12)
            currentInputConnection?.commitText(" ", 1)
        }

        @JavascriptInterface
        fun triggerHaptic(durationMs: Long) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator?.vibrate(VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator?.vibrate(durationMs)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        keyboardWebView?.destroy()
    }
}
