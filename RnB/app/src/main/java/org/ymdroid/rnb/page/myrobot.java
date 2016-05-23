package org.ymdroid.rnb.page;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

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
import java.net.URI;
import java.net.URL;
import java.util.Objects;


public class myrobot extends FragmentActivity {

    PrintWriter out;
    EditText et_ip;

    private VideoView videoView;
    private int position = 0;
    private ProgressDialog progressDialog;
    private android.widget.MediaController mediaControls;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        if(Build.VERSION.SDK_INT>9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_myrobot);

        et_ip = (EditText) findViewById(R.id.et_ip);
        et_ip.setText("210.118.64.129");
        videoPlayer();

    }

    void videoPlayer(){
        videoView = (VideoView)findViewById(R.id.videoView);


        if (mediaControls == null) {
            mediaControls = new android.widget.MediaController(myrobot.this);
        }

       // progressDialog = new ProgressDialog(myrobot.this);
       // progressDialog.setTitle("Android Video");
       // progressDialog.setMessage("Loading...");
       // progressDialog.setCancelable(false);
       // progressDialog.show();

        try {
            Uri video = Uri.parse("rtsp://210.118.64.129:8554/test");
            videoView.setVideoURI(video);
            videoView.setMediaController(mediaControls);
        }catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        videoView.requestFocus();


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer){
              //  progressDialog.dismiss();
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }else{
                    videoView.pause();
                }
            }
        });


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
