# SerialPortPrint
Printing on android using RS232. Native development in Android Studio

This project is to use Serial Port such as /dev/ttyS1 for printing using RS232. A lot of eclipse projects exist to do the same but this is concentrated on Android Studio. This project helps add native code for printing to your new project. Please follow the steps to do the same. 
Requirements: Printer connected throught RS232 interface. Android should be rooted so that access to the serial port through Linux tty is possible. Even in cases where the device is not rooted but the port is enabled, it should work.

Steps:

1. Download the project and keep it saved somewhere.

2. Create a new Android Studio Project and include C/C++ support. Continue until you reach a page in which you decide between ToolChain and C++11. Choose ToolChain which is the default. Finish making the project.

3. Now you will have a cpp folder along with the src/main/java folder. Copy src/main/cpp/SerialPort.c and src/main/cpp/SerialPort.h from this project to your project. Also copy src/main/java/SerialPort.java to your src/main/java folder.

4. Open the project in Project View from the left hand side and go to your app module. Find the file CMakeLists.txt. Open the file and change the add-library tag to the following:

  add_library( 
             # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
             src/main/cpp/native-lib.cpp
             src/main/cpp/SerialPort.c
             src/main/cpp/SerialPort.h)
            
5. Copy paste the contents of src/main/java/MainActivity.java from this project to your project. You can change this as you like. The serialPrint() function is used to print the content.

6. Last portion is changing the values of SerialPort.h and SerialPort.c
   Open SerialPort.h and SerialPort.c. In both, find the lines Java_com_steelsty_myapplication_SerialPort and change the com_steelsty_myapplication part to your package name seperated by '_' instead of '.'. Save both files and run.
   By default, when the app opens, if you have set the correct port and baudrate in serialPrint(), the printer will print the content passed to serialPrint().
   
