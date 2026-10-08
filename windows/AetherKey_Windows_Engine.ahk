; ==============================================================================
; AetherKey Windows System-Wide Typing Engine (.ahk)
; Types every math symbol, greek letter, and unicode font in ANY Windows app!
; Works in WhatsApp Desktop, Word, Notepad, Chrome, Discord, VS Code, Teams, etc.
; ==============================================================================
#NoEnv
#SingleInstance Force
SendMode Input
SetWorkingDir %A_ScriptDir%

; --- CALCULUS & DERIVATIVES ---
::\int::∫
::\iint::∬
::\iiint::∭
::\oint::∮
::\sum::∑
::\prod::∏
::\coprod::∐
::\partial::∂
::\nabla::∇
::\lim::lim
::\inf::∞
::\sqrt::√
::\pm::±
::\mp::∓
::\times::×
::\div::÷
::\approx::≈
::\neq::≠
::\leq::≤
::\geq::≥
::\equiv::≡

; --- SET THEORY & FORMAL LOGIC ---
::\in::∈
::\notin::∉
::\subset::⊂
::\supset::⊃
::\subseteq::⊆
::\supseteq::⊇
::\cup::∪
::\cap::∩
::\forall::∀
::\exists::∃
::\empty::∅
::\implies::⇒
::\iff::⇔
::\qed::∎

; --- GREEK ALPHABET ---
::\alpha::α
::\beta::β
::\gamma::γ
::\delta::δ
::\epsilon::ε
::\zeta::ζ
::\eta::η
::\theta::θ
::\iota::ι
::\kappa::κ
::\lambda::λ
::\mu::μ
::\nu::ν
::\xi::ξ
::\pi::π
::\rho::ρ
::\sigma::σ
::\tau::τ
::\upsilon::υ
::\phi::φ
::\chi::χ
::\psi::ψ
::\omega::ω

; --- GREEK UPPERCASE ---
::\Alpha::Α
::\Beta::Β
::\Gamma::Γ
::\Delta::Δ
::\Theta::Θ
::\Lambda::Λ
::\Pi::Π
::\Sigma::Σ
::\Phi::Φ
::\Psi::Ψ
::\Omega::Ω

; --- PHYSICS & CONSTANTS ---
::\hbar::ħ
::\angstrom::Å
::\ohm::Ω
::\deg::°

; --- FUN / SNIPPETS ---
::/shrug::¯\_(ツ)_/¯
::/tableflip::(╯°□°)╯︵ ┻━┻
::/dis::ಠ_ಠ
::/lenny::( ͡° ͜ʖ ͡°)

; Hotkey: Win + K opens AetherKey Web Suite in browser!
#k::
Run, https://ais-dev-iiw7li3pd5yj3gychpuus7-742362268437.asia-southeast1.run.app
return
