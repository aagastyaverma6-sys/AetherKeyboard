# AetherKey Android IME (Native System Keyboard)

This is the complete, official Android Studio project for **AetherKey Keyboard**.
When installed on Android, it registers as a real system InputMethodService (`android.view.InputMethod`), allowing you to type Greek, calculus, physics formulas, diacritics, and AI-powered text directly into **WhatsApp, Instagram, Chrome, SMS, or ANY application** without copy-pasting!

---

## ⚡ Option A: Build APK in 2 Minutes on GitHub (Zero Tools Needed)
1. Push or extract this folder to a new **GitHub repository** (Public or Private).
2. Go to the **Actions** tab on your GitHub repository.
3. The workflow in `.github/workflows/build-apk.yml` will automatically run.
4. Download the compiled `app-debug.apk` from the workflow run artifacts and install it on your Android phone!

---

## 💻 Option B: Build with Android Studio
1. Open **Android Studio**.
2. Select **Open** and choose this root folder.
3. Click **Build > Build Bundle(s) / APK(s) > Build APK(s)**.
4. Once built, copy `app/build/outputs/apk/debug/app-debug.apk` to your phone and install!

---

## 📱 How to Activate as Default Keyboard on Android:
1. Open the **AetherKey** app on your phone.
2. Tap **Step 1: Enable AetherKey in Settings** and toggle the switch on.
3. Tap **Step 2: Switch Default Keyboard** and select **AetherKey**.
4. Open WhatsApp, tap any chat message bar, and start typing!
