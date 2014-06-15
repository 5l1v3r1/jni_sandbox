#include <jni.h>
#include <stdio.h>

JNIEXPORT void JNICALL Java_TestJNI_simpleCall
    (JNIEnv *p_env, jobject p_object, jint p_int)
{
    printf("Received p_int = %d\n", p_int);
}

JNIEXPORT void JNICALL Java_TestJNI_primitiveArrayCall
    (JNIEnv *p_env, jobject p_object, jintArray p_intArray)
{
    jint *c_array = (*p_env)->GetIntArrayElements(p_env, p_intArray, NULL);
    if(c_array == NULL)
    {
        return;
    }

    jsize length = (*p_env)->GetArrayLength(p_env, p_intArray);

    printf("Received array with length %d\n", length);
    for(int i = 0; i < length; i++)
    {
        printf("Element %d = %d\n", i, c_array[i]);
        c_array[i] = i;
    }

    (*p_env)->ReleaseIntArrayElements(p_env, p_intArray, c_array, 0);
}
