package com.franklee.wordskeeper.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Lijinpeng on 2016/10/19.
 */

public class BasicBean implements Serializable {

    private String phonetic;
    @SerializedName("uk-phonetic")
    private String uk_phonetic;//英式发音
    @SerializedName("us-phonetic")
    private String us_phonetic;//美式发音
    private ArrayList<String> explains;

    /*use for data binding*/
    private String str_phonetic;
    public String getStr_phonetic() {
        return "英["+uk_phonetic+"] "+ "美["+us_phonetic+"] ";
    }
    private String str_explains;
    public String getStr_explains() {
        StringBuffer stringBuffer = new StringBuffer();
        if (explains != null && explains.size() > 0){

            for (String str : explains) {
                stringBuffer.append(str + ",");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        }
        return stringBuffer.toString();
    }


    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getUk_phonetic() {
        return uk_phonetic;
    }

    public void setUk_phonetic(String uk_phonetic) {
        this.uk_phonetic = uk_phonetic;
    }

    public String getUs_phonetic() {
        return us_phonetic;
    }

    public void setUs_phonetic(String us_phonetic) {
        this.us_phonetic = us_phonetic;
    }

    public ArrayList<String> getExplains() {
        return explains;
    }

    public void setExplains(ArrayList<String> explains) {
        this.explains = explains;
    }
}
