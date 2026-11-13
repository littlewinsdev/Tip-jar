# Tip Jar — Google Play release preparation

App ID: `com.littlewinsdev.tipjar`
Web app: https://littlewinsdev.github.io/Tip-jar/
Privacy policy (web beta): https://littlewinsdev.github.io/Tip-jar/privacy.html

## Current status
- Web/PWA: available on GitHub Pages.
- Google Play Console entry: user reports created.
- Android App Bundle (.aab): **not yet built**.
- Google Play Billing: **not yet implemented or tested**.
- Pro entitlement and purchase restore: **not yet implemented**.
- Google Play release: **not submitted**.

## Proposed product
One-time, non-consumable in-app product ID: `tip_jar_pro`.
Pro price target: USD 2.99 (configure in Play Console; local prices and taxes may differ).

Do not offer or advertise a working Pro purchase until Play Billing purchase flow, backend or trusted entitlement validation, purchase acknowledgement, restore, and feature gating are implemented and tested.

## Android package build
- Use Android Studio / an appropriate Trusted Web Activity build workflow with application ID `com.littlewinsdev.tipjar`.
- TWA origin: `https://littlewinsdev.github.io`.
- TWA start URL: `https://littlewinsdev.github.io/Tip-jar/`.
- Add `/.well-known/assetlinks.json` on the **origin host** with the final Play App Signing certificate fingerprint; GitHub Pages for a project repository does not automatically grant control of the origin-wide `/.well-known` path. Without verified Digital Asset Links, a TWA may show browser chrome. Consider a dedicated custom domain under your control if required.
- Use Google Play App Signing and retain the upload signing key securely.
- Create and upload a signed AAB, then test on an internal testing track.

## Billing implementation checklist
1. Create the one-time product in Play Console with ID `tip_jar_pro`, price USD 2.99.
2. Implement Play Billing in the Android application. A static website alone cannot directly call the native Google Play Billing Library.
3. Connect purchase entitlements to the web UI using a trusted bridge and validate purchases securely; do not trust a localStorage `pro=true` flag.
4. Acknowledge purchases and restore previously owned non-consumable purchases.
5. Test purchase, cancel, refund/revoke, offline and restore scenarios using license testers.
6. Keep free features functional when billing is unavailable.

## Store and policy checklist
- Confirm developer contact email and support channel.
- Finalize store title, descriptions, screenshots, feature graphic and 512x512 icon.
- Complete Data Safety and privacy disclosures **based on the actual final Android implementation**.
- Update privacy policy to disclose billing, purchase verification, analytics or any other integrations actually used.
- Complete content rating, target audience, ads declaration, app access, and other Console declarations.
- Follow testing requirements shown in this specific Play Console account.
- Release only after AAB installation, purchase verification and app review succeed.

## Existing files
- `index.html`: Tip Jar PWA UI and local shift data
- `manifest.webmanifest`, `sw.js`, `icon.svg`: installable web app
- `privacy.html`: web beta privacy policy, needs review for final Play build
- `PLAY_STORE_DRAFT.md`: listing draft

No payment credentials, API secrets, signing keys or Play Console passwords should be committed to this repository.
