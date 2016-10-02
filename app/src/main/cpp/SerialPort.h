#include <jni.h>

#ifndef _Included_com_steelsty_myapplication_SerialPort
#define _Included_com_steelsty_myapplication_SerialPort
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     android_serialport_api_SerialPort
 * Method:    open
 * Signature: (Ljava/lang/String;II)Ljava/io/FileDescriptor;
 */
JNIEXPORT jobject JNICALL Java_com_steelsty_myapplication_SerialPort_open
        (JNIEnv *, jclass, jstring, jint, jint);

/*
 * Class:     android_serialport_api_SerialPort
 * Method:    close
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_steelsty_myapplication_SerialPort_close
        (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif



#endif //MYAPPLICATION_SERIALPORT_H
