package org.ymdroid.rnb;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;


/**
 * Created by kimminyoung on 2016-05-13.
 */
public class HTTPUtil extends Thread {
    private static final String TAG = "HTTPUtil";
    OkHttpClient client = new OkHttpClient();
    Request request;
    Response response;

    final String base_url = "http://210.118.64.129:27017";
    public HTTPUtil() {
    }

    public String connection(String url, String jsonString) throws IOException, NetworkErrorException, Exception {
        RequestBody query = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonString);
        Log.e(TAG, "url : "+base_url+url);
        request = new Request.Builder()
                .url(base_url + url)
                .post(query)
                .build();
        response = client.newCall(request).execute();
        return response.body().string();
    }


}
