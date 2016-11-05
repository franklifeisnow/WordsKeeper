package com.franklee.wordskeeper.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/4.
 */

public class FanyiInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException{
        Request request = chain.request();
        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("keyfrom", "wordskeeper")
                .addQueryParameter("key", "1012409051")
                .addQueryParameter("type", "data")
                .addQueryParameter("doctype", "json")
                .addQueryParameter("version", "1.1")
                .build();
        request = request.newBuilder().url(httpUrl).build();
        return  chain.proceed(request);
    }

}
