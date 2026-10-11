#include <jni.h>
#include <string>
#include <freetype/freetype.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_wyq0918dev_freetypeandroid_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    FT_Int major = 0, minor = 0, patch = 0;
    FT_Library library = nullptr;
    if (FT_Init_FreeType(&library) == FT_Err_Ok) {
        FT_Library_Version(library, &major, &minor, &patch);
        FT_Done_FreeType(library);
    }

    std::string freetype_version =
            std::to_string(major) + "." +
                    std::to_string(minor) + "." +
                    std::to_string(patch);


//    std::string hello = "Hello from C++";
    return env->NewStringUTF(freetype_version.c_str());
}