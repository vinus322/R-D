package org.ymdroid.rnb;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    String serverIP ="210.118.64.129" ;
    EditText et_ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_myrobot);

        et_ip = (EditText) findViewById(R.id.et_ip);
        et_ip.setText(serverIP);

    }

    public void OkButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), "클릭", Toast.LENGTH_SHORT).show();

        try{
            serverIP =et_ip.getText().toString();
            Toast.makeText(getApplicationContext(), serverIP , Toast.LENGTH_SHORT).show();

            InetAddress serverAddr = InetAddress.getByName(serverIP);
            Socket socket = new Socket(serverAddr, 5100);
            String message = "motor=1";

            try {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);
                out.flush();
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "ERROR1 : "+e.getMessage(), Toast.LENGTH_LONG).show();
            } finally {
                socket.close();
            }

        }catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(getApplicationContext(),  "ERROR2 : "+ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }



}
