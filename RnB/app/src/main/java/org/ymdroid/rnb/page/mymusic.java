package org.ymdroid.rnb.page;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ymdroid.rnb.R;

import org.ymdroid.rnb.SocketUtil;

public class mymusic extends FragmentActivity {
    TextView tv_musicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mymusic);
        tv_musicName = (TextView) findViewById(R.id.tv_musicName);
    }

    void openSocket(String msg){
        SocketUtil mysocket = new SocketUtil("210.118.64.129", 5100);
        mysocket.setmessage(msg);
        mysocket.run();
    }
    public void musicPlayClick(View v){
        Toast.makeText(getApplicationContext(), "play", Toast.LENGTH_SHORT).show();
        openSocket("music=play");
    }
    public void musicStopClick(View v) {
        Toast.makeText(getApplicationContext(), "stop", Toast.LENGTH_SHORT).show();
        openSocket("music=stop");
    }
     public void test1Music(View v){
         Toast.makeText(getApplicationContext(), "test1", Toast.LENGTH_SHORT).show();
         tv_musicName.setText("Summer_Nights");
         openSocket("music=Summer_Nights");
     }
    public void test2Music(View v){
        Toast.makeText(getApplicationContext(), "test2", Toast.LENGTH_SHORT).show();
        tv_musicName.setText("phone");
        openSocket("music=phone");
    }
}
