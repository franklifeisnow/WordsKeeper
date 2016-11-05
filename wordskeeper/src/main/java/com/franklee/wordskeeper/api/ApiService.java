package com.franklee.wordskeeper.api;

import com.franklee.wordskeeper.bean.FanyiJsonBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/11/4.
 */

public interface ApiService {

    @GET("openapi.do")
    Call<FanyiJsonBean> getFanyiByAll(@Query("keyfrom") String keyfrom,
                                 @Query("key") int key,
                                 @Query("type") String type,
                                 @Query("doctype") String doctype,
                                 @Query("version") String ver,
                                 @Query("q") String work);
    @GET("openapi.do")
    Call<FanyiJsonBean> getFanyiByone( @Query("q") String work);
}
