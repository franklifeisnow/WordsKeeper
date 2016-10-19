package com.franklee.wordskeeper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lijinpeng on 2016/10/19.
 */

public class FanyiJsonBean implements Serializable {
    private int errorCode;
    private String query;
    private String translation;
    private BasicBean basic;
    private List<WebBean> web;

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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }
}
