package com.steelsty.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity
{
    OutputStream mOutputStream = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        serailPrint("HELLO PRINTER","/dev/ttyUSB0",38400);
    }
    public void serailPrint(String content, String path, int baudRate)
    {
        SerialPort serialPort = null;
        String strPrint;
        byte[] buffer = new byte[1024];
        try
        {
//            /dev/ttyUSB0:38400
            serialPort = new SerialPort(new File(path), baudRate, 0);
            mOutputStream = serialPort.getOutputStream();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        strPrint = "  \n\n";
        strPrint += content;
        strPrint += "  \n\n\n\n\n\n\n";
        try
        {
            buffer = strPrint.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }


        if (serialPort != null)
        {
            try
            {
                if (mOutputStream != null)
                {
                    mOutputStream.write(buffer);
                }
                else
                {
                    return;
                }
            } catch (IOException e)
            {
                e.printStackTrace();
                return;
            }
        }
        buffer = new byte[10];
        buffer[0] = 0x1B;
        buffer[1] = 0x6D;

        if (serialPort != null)
        {
            try
            {
                if (mOutputStream != null)
                {
                    mOutputStream.write(buffer);
                }
                else
                {
                    return;
                }
            } catch (IOException e)
            {
                e.printStackTrace();
                return;
            }
        }
        try
        {
            mOutputStream.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
