package com.example.tarunkapur.vollymovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<ModalClass> movies=new ArrayList<>();
    private String server_url="https://api.themoviedb.org/3/movie/popular?api_key=f2b816a788fef6c350c88c7b40c7f08d&language=en-US&page=1";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final TextView textView =(TextView) findViewById(R.id.text) ;
        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));



                BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
                movies=backgroundTask.getList();


    /*    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, server_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Log.i("myMessage", "onResponse: yes");
                    JSONArray jsonArray=response.getJSONArray("results");
                    Log.i("myMessage", "onResponse: yes2");
                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        Log.i("myMessage", "onResponse: yes3");
                        ModalClass object=new ModalClass(jsonObject.getString("title"),jsonObject.getString("original_language"),jsonObject.getString("poster_path"), jsonObject.getString("overview"));
                        movies.add(object);

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
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
*/
                myAdapter=new MyAdapter(movies,getBaseContext());
                recyclerView.setAdapter(myAdapter);












    }
}
