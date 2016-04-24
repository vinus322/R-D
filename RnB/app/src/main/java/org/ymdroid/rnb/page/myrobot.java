package org.ymdroid.rnb.page;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ymdroid.rnb.R;
import org.ymdroid.rnb.SocketUtil;

import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;


public class myrobot extends FragmentActivity {

    PrintWriter out;
    EditText et_ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        if(Build.VERSION.SDK_INT>9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_myrobot);

        et_ip = (EditText) findViewById(R.id.et_ip);
        et_ip.setText("210.118.64.129");

    }

    void openSocket(String msg){
        SocketUtil mysocket = new SocketUtil(et_ip.getText().toString(), 5100);
        mysocket.setmessage(msg);
        mysocket.run();
    }
    public void LedbuttonClick(View v) {
        Button bt_led = (Button) findViewById(R.id.bt_led);
        String led_state = bt_led.getText().toString();

        if(led_state=="LedOn"){
            Toast.makeText(getApplicationContext(), "LedOn", Toast.LENGTH_SHORT).show();
            openSocket("led=On");
            bt_led.setText("LedOff");
        }else{
            Toast.makeText(getApplicationContext(), "LedOff", Toast.LENGTH_SHORT).show();
            openSocket("led=Off");
            bt_led.setText("LedOn");
        }
    }

    public void Upbutton(View v) {
        Toast.makeText(getApplicationContext(), "위", Toast.LENGTH_SHORT).show();
        openSocket("motor=1");
    }
    public void Downbutton(View v) {
        Toast.makeText(getApplicationContext(), "아래", Toast.LENGTH_SHORT).show();
        openSocket("motor=2");
    }
    public void Leftbutton(View v) {
        Toast.makeText(getApplicationContext(), "왼쪽", Toast.LENGTH_SHORT).show();
        openSocket("motor=3");
    }
    public void Rightbutton(View v) {
        Toast.makeText(getApplicationContext(), "오른쪽", Toast.LENGTH_SHORT).show();
        openSocket("motor=4");
    }
    public void Stopbutton(View v) {
        Toast.makeText(getApplicationContext(), "오른쪽", Toast.LENGTH_SHORT).show();
        openSocket("motor=5");
    }



}
