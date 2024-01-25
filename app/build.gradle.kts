import java.io.FileInputStream
import java.util.Properties


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")


}

android {
    namespace = "com.example.gcashtestjweatherapp"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.gcashtestjweatherapp"
        minSdk = 33
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
    sourceSets {
        getByName("test").java.srcDir("src/sharedTest/java")
        getByName("androidTest").java.srcDir("src/sharedTest/java")
    }
}

dependencies {

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    //Room
    val room_version = "2.6.1"
    val work_version = "2.9.0"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("com.google.android.gms:play-services-location:21.1.0")
    implementation ("com.jakewharton.timber:timber:4.7.1")
    implementation ("com.github.pwittchen:weathericonview:1.1.0")
    implementation ("androidx.preference:preference-ktx:1.2.1")
    implementation ("com.github.shrikanth7698:Collapsible-Calendar-View-Android:v1.0.3")
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    implementation ("com.github.bumptech.glide:compiler:4.13.0")
    implementation ("com.github.skydoves:elasticviews:2.0.7")


    //Views
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation ("androidx.recyclerview:recyclerview:1.4.0-alpha01")




    //Room
    implementation ("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    //workmanager
    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation("com.google.code.gson:gson:2.8.6")



    // Coroutines
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Coroutine Lifecycle Scopes
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation( "androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.arch.core:core-testing:2.1.0")

    //dagger-hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:4.0.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    testImplementation("org.robolectric:robolectric:4.6")
    testImplementation("androidx.room:room-testing:2.6.1")
    testImplementation ("org.hamcrest:hamcrest:2.2")






    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //unit test

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}