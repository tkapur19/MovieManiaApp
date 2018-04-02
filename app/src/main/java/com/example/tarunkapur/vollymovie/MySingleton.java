package com.example.tarunkapur.vollymovie;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by tarunkapur on 17/02/18.
 */

public class MySingleton {


    private static MySingleton mySingleton;
    private Context context;
    private RequestQueue requestQueue;

    private MySingleton(Context context) {

        this.context = context;
        this.requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mySingleton == null) {
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public RequestQueue getRequestQueue(){

        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;

    }
    public <T> void addToRequestQueue(Request<T> request) {
        requestQueue.add(request);

    }


}
