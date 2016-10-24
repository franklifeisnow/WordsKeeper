package com.franklee.wordskeeper.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.franklee.wordskeeper.R;
import com.franklee.wordskeeper.bean.FanyiJsonBean;
import com.franklee.wordskeeper.databinding.ActivityTranslationBinding;
import com.google.gson.Gson;


public class TranslationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "TranslationActivity";

    private RequestQueue mRequestQueue;

    private FanyiJsonBean fanyiBean;

    private ActivityTranslationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_translation);
//        setContentView(R.layout.activity_translation);

        mRequestQueue = Volley.newRequestQueue(this);

        binding.searchEditWord.setSubmitButtonEnabled(true);
        binding.searchEditWord.setOnQueryTextListener(this);


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        getSearchWord(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    private void getSearchWord(String word) {
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=wordskeeper&key=1012409051&type=data&doctype=json&version=1.1&q=" + word;
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", response);
                        parseJSON(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mRequestQueue.add(stringRequest);
    }

    private void parseJSON(String response) {

        fanyiBean = new FanyiJsonBean();
        Gson gson = new Gson();
        fanyiBean = gson.fromJson(response, FanyiJsonBean.class);

        showView();

    }

    private void showView() {
        binding.setFanyibean(fanyiBean);
//        binding.webListView.setAdapter();
    }


    @Override
    protected void onResume() {

        super.onResume();
    }
}
