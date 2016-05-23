package org.ymdroid.rnb;

import org.json.JSONException;
import org.json.JSONObject;
import org.ymdroid.rnb.page.UserInfo;


public class JsonParse {

    public JsonParse(){}

    public boolean StatusJsonParse(String data){
        boolean status = false;
        if(data==null)
            return false;
        try {
            JSONObject  jsonRootObject = new JSONObject(data);
            status =jsonRootObject.optBoolean("UserCheck");
            return status;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void getUserInfo(String res){
        try {
            JSONObject  jsonRootObject = new JSONObject(res);
            JSONObject data =jsonRootObject.optJSONObject("data");
            UserInfo userInfo = UserInfo.getInstance();
            String user_id= data.optString("user_id");
            String password= data.optString("password");
            String name= data.optString("name");
            String birth= data.optString("birth");
            userInfo.setUserData(user_id, password,name,birth);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
