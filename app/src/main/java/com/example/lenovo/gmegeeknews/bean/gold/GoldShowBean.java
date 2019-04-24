package com.example.lenovo.gmegeeknews.bean.gold;

import java.io.Serializable;

public class GoldShowBean implements Serializable {
    private boolean isChecked;
    private String titles;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public GoldShowBean(boolean isChecked, String titles) {
        this.isChecked = isChecked;

        this.titles = titles;
    }

    @Override
    public String toString() {
        return "GoldShowBean{" +
                "isChecked=" + isChecked +
                ", titles='" + titles + '\'' +
                '}';
    }
}
