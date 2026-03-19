#include <jni.h>
#include "PrimeChecker.h"

JNIEXPORT jboolean JNICALL Java_PrimeChecker_isPrime(JNIEnv *env, jobject obj, jint n) {
    if (n <= 1) return JNI_FALSE;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return JNI_FALSE;
    }
    return JNI_TRUE;
}