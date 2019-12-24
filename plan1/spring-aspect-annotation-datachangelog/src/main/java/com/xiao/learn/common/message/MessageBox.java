package com.xiao.learn.common.message;

/**
 * @author xzy
 * @date 2019-12-24 15:21
 * 说明：
 */
public class MessageBox<T> extends Message {
    private T data;

    public MessageBox() {
    }

    public MessageBox(T data) {
        this.data = data;
    }

    public MessageBox(int status, String message, T data) {
        super(status, message);
        this.data = data;
    }

    public boolean hasData() {
        return this.data != null;
    }

    public T getData() {
        return data;
    }

    public MessageBox setData(T data) {
        this.data = data;
        return this;
    }

}
