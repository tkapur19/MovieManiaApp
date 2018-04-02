package com.example.tarunkapur.vollymovie;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarunkapur on 18/02/18.
 */

public class BackgroundTask {

    Context context;
    List<ModalClass> movies2=new ArrayList<>();
    String serverUrl="https://api.themoviedb.org/3/movie/popular?api_key=f2b816a788fef6c350c88c7b40c7f08d&language=en-US&page=2";
    public BackgroundTask(Context context){

        this.context=context;

    }

    public ArrayList<ModalClass> getList(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, serverUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Log.i("myMessage", "onResponse: yes");
                    JSONArray jsonArray=response.getJSONArray("results");
                    Log.i("myMessage", "onResponse: yes2");
                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        Log.i("myMessage", "onResponse: yes3");
                        ModalClass object=new ModalClass(jsonObject.getString("title"),jsonObject.getString( "release_date"),jsonObject.getString("poster_path"), jsonObject.getString("overview"), jsonObject.getInt("vote_average"));
                        movies2.add(object);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
        return (ArrayList<ModalClass>) movies2;

    }
}
