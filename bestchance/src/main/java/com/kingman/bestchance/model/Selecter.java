package com.kingman.bestchance.model;

/**
 * Created by wb-lijinwei.a on 2016/5/12.
 */
public class Selecter {
    int resDrawable;
    String title;

    public Selecter(int res, String title) {
        this.resDrawable = res;
        this.title = title;
    }

    public int getResDrawable() {
        return resDrawable;
    }

    public void setResDrawable(int resDrawable) {
        this.resDrawable = resDrawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
