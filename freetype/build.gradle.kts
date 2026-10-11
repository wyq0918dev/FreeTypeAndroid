plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "org.freetype.android"
    compileSdk {
        version = release(37)
    }
    defaultConfig {
        minSdk = 26
    }
    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
        }
    }
    buildFeatures {
        prefabPublishing = true
    }
    prefab {
        create("freetype") {
            headers = "src/main/cpp/freetype/include"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.wyq0918dev"
            artifactId = "FreeTypeAndroid"
            version = "9.5.0"
            afterEvaluate {
                from(components["release"])
            }
            pom {
                name = "FreeType"
                description = "FreeType Prefab library for Android"
                url = "https://github.com/wyq0918dev/FreeTypeAndroid"
                licenses {
                    license {
                        name = "MIT"
                        url = "https://github.com/wyq0918dev/FreeTypeAndroid/blob/master/LICENSE"
                    }
                }
                developers {
                    developer {
                        name = "wyq0918dev"
                        url = "https://github.com/wyq0918dev"
                    }
                }
                scm {
                    connection = "scm:git:https://github.com/wyq0918dev/FreeTypeAndroid.git"
                    url = "https://github.com/wyq0918dev/FreeTypeAndroid"
                }
            }
        }
    }
}