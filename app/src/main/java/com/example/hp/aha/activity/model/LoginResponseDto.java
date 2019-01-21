package com.example.hp.aha.activity.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by A0000350 on 5/24/2018.
 */

public class LoginResponseDto {
    @SerializedName("token")
    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
