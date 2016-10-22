package com.franklee.wordskeeper.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lijinpeng on 2016/10/19.
 */

public class WebBean implements Serializable {
    private String key;
    private ArrayList<String> value;

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
