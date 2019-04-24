package com.example.lenovo.gmegeeknews.bean.v2ex;

public class V2exTabBean {
    private String line;
    private String tab;

    @Override
    public String toString() {
        return "V2exTabBean{" +
                "line='" + line + '\'' +
                ", tab='" + tab + '\'' +
                '}';
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public V2exTabBean(String line, String tab) {

        this.line = line;
        this.tab = tab;
    }
}
