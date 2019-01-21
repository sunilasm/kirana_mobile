package com.example.hp.aha.activity.network.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GenericResponseModel<T> {


    @SerializedName("success")
    private boolean mSuccess;

    @SerializedName("msg")
    private String mMessage;

    //TODO For dummy data, need to remove
    @SerializedName("IsSuccess")
    private boolean isSuccess = true;

    @SerializedName("Message")
    private String message;

    @SerializedName("is_partial")
    private boolean is_partial;

    @SerializedName("SingleResult")
    private List<T> singleResult;

    public boolean ismSuccess() {
        return mSuccess;
    }

    public void setmSuccess(boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public List<T> getSingleResult() {
        return singleResult;
    }

    public void setSingleResult(List<T> singleResult) {
        this.singleResult = singleResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIs_partial() {
        return is_partial;
    }

    public void setIs_partial(boolean is_partial) {
        this.is_partial = is_partial;
    }
}
