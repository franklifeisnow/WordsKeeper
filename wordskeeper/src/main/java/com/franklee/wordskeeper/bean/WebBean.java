package com.franklee.wordskeeper.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lijinpeng on 2016/10/19.
 */

public class WebBean extends BaseObservable {
    private String key;
    private ArrayList<String> value;


    private String str_value;
    public String getStr_value() {
        StringBuffer stringBuffer = new StringBuffer();
        if (value != null && value.size() > 0){

            for (String str : value) {
                stringBuffer.append(str + ",");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        }
        return stringBuffer.toString();
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public void setValue(ArrayList<String> value) {
        this.value = value;
    }
}
