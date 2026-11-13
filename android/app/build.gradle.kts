plugins { id("com.android.application") }

android {
    namespace = "com.littlewinsdev.tipjar"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.littlewinsdev.tipjar"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.6.0"
    }
    buildTypes {
        release { isMinifyEnabled = false }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
