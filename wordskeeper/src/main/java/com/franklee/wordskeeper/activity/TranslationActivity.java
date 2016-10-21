package com.franklee.wordskeeper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.franklee.wordskeeper.R;
import com.franklee.wordskeeper.bean.FanyiJsonBean;
import com.google.gson.Gson;


public class TranslationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private static final String TAG = "TranslationActivity";

    private RequestQueue mRequestQueue;

    SearchView searchView;

    TextView textView2, textView3, textView4;

    FanyiJsonBean fanyiBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        mRequestQueue = Volley.newRequestQueue(this);

        searchView = (SearchView) findViewById(R.id.search_edit_word);

        searchView.setSubmitButtonEnabled(true);

        searchView.setQueryHint("输入");

        searchView.setOnQueryTextListener(this);

        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        getSearchWord(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // TODO Auto-generated method stub
        return false;
    }

    private void getSearchWord(String word){
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=wordskeeper&key=1012409051&type=data&doctype=json&version=1.1&q="+word;
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
        textView2.setText(fanyiBean.getTranslation().get(0));
        textView3.setText("["+fanyiBean.getBasic().getUk_phonetic()+"]");
        textView4.setText("["+fanyiBean.getBasic().getUs_phonetic()+"]");
    }


}
