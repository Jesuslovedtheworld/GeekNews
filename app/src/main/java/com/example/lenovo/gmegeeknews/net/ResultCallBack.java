package com.example.lenovo.gmegeeknews.net;

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFile(String s);
}
