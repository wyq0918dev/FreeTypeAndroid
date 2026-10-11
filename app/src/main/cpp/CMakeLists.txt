cmake_minimum_required(VERSION 3.22.1)
project("freetypeandroid")
add_library(
        ${CMAKE_PROJECT_NAME} SHARED
        native-lib.cpp
)
find_package(freetype REQUIRED CONFIG)
target_link_libraries(
        ${CMAKE_PROJECT_NAME}
        android
        log
        freetype::freetype
)