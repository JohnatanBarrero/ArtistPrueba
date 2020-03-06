package com.example.artistworld.data.remote;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException{
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();
        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("country","spain")
                .addQueryParameter("api_key",ApiConstans.API_KEY)
                .addQueryParameter("format","json")
                .build();
        Request request = originalRequest.newBuilder()
                .url(url)
                .build();

        return chain.proceed(request);
    }
}
