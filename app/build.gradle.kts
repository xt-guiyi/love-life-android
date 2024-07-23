plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.serialization)
}

android {
    namespace = "com.xtguiyi.loveLife"
    compileSdk = 34
    // https://developer.android.com/build/configure-app-module?hl=zh-cn#set-application-id
    defaultConfig {
        applicationId = "com.xtguiyi.loveLife"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = false
    }

    // https://developer.android.com/build/jdks?hl=zh-cn#source-compat
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.constraintlayout)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    implementation(libs.material)
    implementation(libs.datastore.preferences)
    implementation(libs.datastore.preferences.core)
    implementation(libs.jetbrains.kotlinx.serialization.json)
    implementation(libs.lifecycle.viewmodel.ktx)
    // retrofit网络请求框架
    implementation(libs.retrofit)
    implementation(libs.squareup.converter.gson)
    // 吐司框架：https://github.com/getActivity/Toaster
    implementation(libs.getactivity.toaster)
    // glide 图片加载 https://mvnrepository.com/artifact/com.github.bumptech.glide/glide
    implementation(libs.github.glide)
    // banner控件：https://github.com/youth5201314/banner
    implementation(libs.banner)
    implementation(libs.androidx.recyclerview)
    // 下拉刷新框架
    implementation(libs.refresh.layout.kernel) //核心必须依赖
    implementation(libs.refresh.header.material)    //谷歌刷新头
    implementation(libs.refresh.header.classics)  //经典刷新头
    implementation(libs.refresh.footer.classics) // 经典加载
    // Lottie动画：https://github.com/airbnb/lottie-android
    implementation(libs.lottie)
    // GSY播放器 https://github.com/CarGuo/GSYVideoPlayer
    implementation(libs.gsyvideoplayer)
    //是否需要AliPlayer模式
//    implementation(libs.gsyvideoplayer.aliplay)
}