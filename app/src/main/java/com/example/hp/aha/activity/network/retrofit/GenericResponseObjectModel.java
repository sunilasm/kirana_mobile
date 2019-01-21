package com.example.hp.aha.activity.network.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GenericResponseObjectModel<T> {


    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msz;
    @SerializedName("data")
    @Expose
    private T data;

    public String getMsz() {
        return msz;
    }

    public void setMsz(String msz) {
        this.msz = msz;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
