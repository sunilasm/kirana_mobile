package com.example.hp.aha.activity.network.retrofit;

import android.content.Context;
import android.text.TextUtils;

import com.example.hp.aha.activity.prefrence.AppPrefs;
import com.example.hp.aha.activity.utils.AppUrls;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class HeaderInterceptor implements Interceptor {

    private Context context;
    public HeaderInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //Use Realm data base to store the session or token
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder()
                .addHeader("Content-Type", "application/json");

        // Adding Authorization token (API Key)
        // Requests will be denied without API key
        String API_KEY = AppPrefs.getInstance(context).getAccessToken(context);

        if (!TextUtils.isEmpty(API_KEY)) {
           // requestBuilder.addHeader("Authorization", API_KEY);
            requestBuilder.addHeader("Authorization","Bearer "+ API_KEY);
        }
        //Authorization: Bearer <authentication token>
        Request requestHeader = requestBuilder.build();
        return chain.proceed(requestHeader);
    }
}
