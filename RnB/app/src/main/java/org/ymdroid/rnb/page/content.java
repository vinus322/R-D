package org.ymdroid.rnb.page;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import org.ymdroid.rnb.R;

public class content extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content);
    }
    // 나의 페이지
    public void MyPageButtonClicked(View v) {
        Intent intent = new Intent(getApplicationContext(),mypage.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "MyPage", Toast.LENGTH_LONG).show();
    }
    // 나의 이야기
    public void MyStoryButtonClicked(View v){
        Intent intent = new Intent(getApplicationContext(),mystory.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "MyStory", Toast.LENGTH_LONG).show();
    }

    //나의 로봇
    public void MyRobotButtonClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), myrobot.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "MyRobot", Toast.LENGTH_LONG).show();
    }
    //나의 음악
    public void MyMusicButtonClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), mymusic.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "MyMusic", Toast.LENGTH_LONG).show();
    }

    //나의 감정
    public void MyEmotionButtonClicked(View v) {
        Intent intent = new Intent(getApplicationContext(), myemotion.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "MyEmotion", Toast.LENGTH_LONG).show();
    }
}
