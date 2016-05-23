package org.ymdroid.rnb;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.ymdroid.rnb.page.menu;

public class SignUp extends FragmentActivity {
    static String TAG = "SignUp";
    HTTPUtil http = new HTTPUtil();
    JsonParse Json = new JsonParse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sign_up);
    }


    public void btSignUpOKClicked(View v) throws Exception {

        EditText user_email = (EditText) findViewById(R.id.user_Email);
        EditText password = (EditText) findViewById(R.id.password);


        //객체 변수명 DB명 과 맞춰주33333
        JSONObject obj = new JSONObject();
        obj.put("uemail", user_email.getText().toString());
        obj.put("upasswd", password.getText().toString());
        Log.e(TAG, "json : " + obj.toString());//json 객체 확인

        //서버로 보냄 파라미터 : "url"동적으로 변화되는 경로, "jsonObject"서버로 보내질 객체
        HttpTask task = new HttpTask("/login.php", obj.toString());
        String res = task.execute().get(); //결과값을 받음
        Log.e(TAG, "result : " + res);//결과 객체 확인

        //Json 결과 파서
        if (Json.StatusJsonParse(res)) {
            // Json.getUserInfo(res);
            Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_LONG).show();
            //spinner.setVisibility(View.GONE);
            Intent i = new Intent(SignUp.this, menu.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "회원가입 실패", Toast.LENGTH_LONG).show();
            //spinner.setVisibility(View.GONE);
        }
    }

    public void CancelButtonClicked(View v){
        finish();
    }
}
