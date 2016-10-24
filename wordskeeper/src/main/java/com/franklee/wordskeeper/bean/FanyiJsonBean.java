package com.franklee.wordskeeper.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lijinpeng on 2016/10/19.
 */

public class FanyiJsonBean implements Serializable {
    private int errorCode;
    private String query;
    private ArrayList<String> translation;
    private BasicBean basic;
    private ArrayList<WebBean> web;


    /*use for data binding*/
    private String str_translation;
    public String getStr_translation() {
        StringBuffer stringBuffer = new StringBuffer();
        if (translation != null && translation.size() > 0){

            for (String str : translation) {
                stringBuffer.append(str + ",");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        }
        return stringBuffer.toString();

    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<String> getTranslation() {
        return translation;
    }

    public void setTranslation(ArrayList<String> translation) {
        this.translation = translation;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public ArrayList<WebBean> getWeb() {
        return web;
    }

    public void setWeb(ArrayList<WebBean> web) {
        this.web = web;
    }
}
