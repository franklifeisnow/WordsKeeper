package com.franklee.wordskeeper.bean;

import java.io.Serializable;

/**
 * Created by Lijinpeng on 2016/10/19.
 */

public class BasicBean implements Serializable {

    private String phonetic;
    private String uk_phonetic;//英式发音
    private String us_phonetic;//美式发音
    private String[] explains;

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

    public String[] getExplains() {
        return explains;
    }

    public void setExplains(String[] explains) {
        this.explains = explains;
    }
}
