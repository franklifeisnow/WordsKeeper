package com.franklee.wordskeeper.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;


import com.franklee.wordskeeper.R;
import com.franklee.wordskeeper.adapter.TransWebAdapter;
import com.franklee.wordskeeper.api.ApiService;
import com.franklee.wordskeeper.api.FanyiInterceptor;
import com.franklee.wordskeeper.bean.FanyiJsonBean;
import com.franklee.wordskeeper.databinding.ActivityTranslationBinding;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TranslationActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "TranslationActivity";

    private FanyiJsonBean fanyiBean;

    private TransWebAdapter adapter;

    private ActivityTranslationBinding binding;

    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_translation);
//        setContentView(R.layout.activity_translation);

        binding.searchEditWord.setSubmitButtonEnabled(true);
        binding.searchEditWord.setOnQueryTextListener(this);

//        binding.setClick(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
//        getSearchWordByxUtils(query);

        this.query = query;
        getSearchWordByRetrofit(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    /*
        net by xUtils
     */
    private void getSearchWordByxUtils(String word) {
        RequestParams params = new RequestParams("http://fanyi.youdao.com/openapi.do?keyfrom=wordskeeper&key=1012409051&type=data&doctype=json&version=1.1&q=" + word);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                parseJSON(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    /*
        net by Retrofit
     */
    private void getSearchWordByRetrofit(String word){


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new FanyiInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
//                .client(new OkHttpClient().newBuilder().addInterceptor(new FanyiInterceptor()));
                .callFactory(okHttpClient)
                .build();


        ApiService mApiService = retrofit.create(ApiService.class);

//        Call<FanyiJsonBean> call = mApiService.getFanyiByAll("wordskeeper", 1012409051, "data", "json", "1.1", word);
        Call<FanyiJsonBean> call = mApiService.getFanyiByone(word);

        call.enqueue(new retrofit2.Callback<FanyiJsonBean>() {
            @Override
            public void onResponse(Call<FanyiJsonBean> call, Response<FanyiJsonBean> response) {
                if (response.body() instanceof FanyiJsonBean) {
                    fanyiBean = response.body();
                    showView();
                }
            }

            @Override
            public void onFailure(Call<FanyiJsonBean> call, Throwable t) {

            }
        });
    }
    /*
        net by Retrofit
     */
    private void getReadWordByRetrofit(String word){


//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new FanyiInterceptor())
//                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dict.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
//                .callFactory(okHttpClient)
                .build();


        ApiService mApiService = retrofit.create(ApiService.class);

        Call<InputStream> call = mApiService.getFanyiRead(word);

        call.enqueue(new retrofit2.Callback<InputStream>() {
            @Override
            public void onResponse(Call<InputStream> call, Response<InputStream> response) {
                if (response != null) {

                }
            }

            @Override
            public void onFailure(Call<InputStream> call, Throwable t) {
                Log.e("DEBUG",""+t.toString());
            }
        });
    }

    private void parseJSON(String response) {

        fanyiBean = new FanyiJsonBean();
        Gson gson = new Gson();
        fanyiBean = gson.fromJson(response, FanyiJsonBean.class);

        showView();

    }

    private void showView() {
        binding.setFanyibean(fanyiBean);

        if (fanyiBean.getWeb() != null && fanyiBean.getWeb().size() > 0) {
            binding.textView7.setVisibility(View.VISIBLE);
        } else {
            binding.textView7.setVisibility(View.INVISIBLE);
        }
        adapter = new TransWebAdapter(this, fanyiBean.getWeb());
        binding.webListView.setAdapter(adapter);

        View.OnClickListener itemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), v.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
            }
        };
        adapter.setOnclickListener(itemClickListener);

    }


    @Override
    protected void onResume() {

        super.onResume();
    }


    public void click(View view) {
        getReadWordByRetrofit(query);

    }


}
