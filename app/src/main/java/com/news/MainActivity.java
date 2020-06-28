package com.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String API_KEY = "93da7c8e41324fbf8dd9eed633539c80";
    String API_URL = "https://newsapi.org/v2/top-headlines?country=in&apiKey=" + API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rc);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                handleResponse(response);

            }

            }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                Log.e("ERROR", error.toString());

            }

        });
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }
    private void handleResponse(JSONObject response){
        ArrayList<ModelNews> newArray = new ArrayList<>();
        try {
            JSONArray articleAr = response.getJSONArray("articles");
            for(int i=0;i<articleAr.length();i++)
            {
                JSONObject jsonObject = (JSONObject) articleAr.get(i);
                String newTitle = jsonObject.getString("title");
                String newDesc = jsonObject.getString("description");
                String newurl = jsonObject.getString("url");
                String newimg = jsonObject.getString("urlToImage");

                ModelNews modelNews = new ModelNews(newTitle,newDesc,newimg,newurl);
                newArray.add(modelNews);

            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
            recyclerView.setAdapter(new AdapterNews(getApplicationContext(),newArray));

        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Inside Exception block", Toast.LENGTH_SHORT).show();

        }
    }
}