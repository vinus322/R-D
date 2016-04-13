package org.ymdroid.rnb;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class Main extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, Splash.class));
    }

    public void LoginButtonClicked(View v) {
        Intent intent = new Intent(getApplicationContext(),content.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "로그인 성공",Toast.LENGTH_LONG).show();
        finish();
    }

    public void SignUpButtonClicked(View v){
        Intent intent = new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);

        Toast.makeText(getApplicationContext()," 회원 가입",Toast.LENGTH_LONG).show();

    }
}
