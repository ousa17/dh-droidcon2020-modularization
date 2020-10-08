plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    val targetSdkVersion: Int by rootProject.extra
    val minSdkVersion: Int by rootProject.extra
    setCompileSdkVersion(targetSdkVersion)
    defaultConfig {
        applicationId = "com.deliveryhero.workshop.dc2020"
        setMinSdkVersion(minSdkVersion)
        setTargetSdkVersion(targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    android {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":localization"))
    implementation(project(":mvvm-common"))
    implementation(project(":configs"))
    implementation(project(":restaurant-provider"))
    implementation(project(":rlp"))
    implementation(project(":rdp"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    val coreVersion: String by rootProject.extra
    implementation("androidx.core:core-ktx:$coreVersion")
    val appCompatVersion: String by rootProject.extra
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    val mdcVersion: String by rootProject.extra
    implementation("com.google.android.material:material:$mdcVersion")
    val constraintLayoutVersion: String by rootProject.extra
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    val coroutinesVersion: String by rootProject.extra
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    val lifecycleVersion: String by rootProject.extra
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    val retrofitVersion: String by rootProject.extra
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    val daggerVersion: String by rootProject.extra
    implementation("com.google.dagger:dagger:$daggerVersion")
    implementation("com.google.dagger:dagger-android-support:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
    val glideVersion: String by rootProject.extra
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    val fragmentxVersion = "1.3.0-beta01"
    implementation("androidx.fragment:fragment-ktx:$fragmentxVersion")

    testImplementation(project(":test-common"))

    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
