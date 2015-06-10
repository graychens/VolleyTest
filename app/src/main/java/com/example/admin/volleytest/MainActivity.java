package com.example.admin.volleytest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {
    private  String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJSONVolley();
    }

    //
    public void getJSONVolley() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String JSONDateUrl = "http://www.baidu.com";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, JSONDateUrl, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d(TAG,"onResponse:"+response);
                        System.out.println("response=" + response);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(
                    com.android.volley.VolleyError arg0) {
                Log.d(TAG,"onErrorResponse");
                System.out.println("对不起 有问题");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}
