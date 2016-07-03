package rnb.myemotionforme;

import org.json.JSONException;
import org.json.JSONObject;


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
            userInfo.setUserData(user_id, password, name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
