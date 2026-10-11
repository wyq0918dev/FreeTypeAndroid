# FreeTypeAndroid

适用于 Android 的 [FreeType](https://github.com/freetype/freetype) 静态 Prefab 库.

此仓库基于官方 [FreeType](https://github.com/freetype/freetype) 仓库

## 如何使用

settings.gradle.kts

```kotlin
dependencyResolutionManagement {
    repositories {
        maven(url = "https://jitpack.io") // 此仓库使用Jitpack发布
    }
}
```

libs.versions.toml

```toml
[versions]
freetype = "这里写最新版本"

[libraries]
freetype-android = { group = "com.github.wyq0918dev", name = "FreeTypeAndroid", version.ref = "freetype" }
```

build.gradle.kts

```kotlin
android {
    buildFeatures {
        prefab = true // 需要启用Prefab
    }
}

dependencies {
    implementation(libs.freetype.android) // 依赖LVGL Prefab库
}
```

CMakeLists.txt

```cmake
find_package(freetype REQUIRED CONFIG)

target_link_libraries(
        ${CMAKE_PROJECT_NAME}
        freetype::freetype
)
```

main.cpp

```objectivec
#include <freetype/freetype.h>
```