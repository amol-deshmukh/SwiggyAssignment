package com.deshmukh.swiggyassignment.network;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class RetrofitProvider {

    private static Retrofit retrofitInstance;


    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(NetworkUtils.getDomainName())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofitInstance;
    }

    private static OkHttpClient getOkHttpClient() {
        return getOkHttpClient(NetworkUtils.ASYNC_HTTP_TIMEOUT);
    }

    @NonNull
    private static OkHttpClient getOkHttpClient(int timeoutInMills) {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();


        okHttpBuilder
                .connectTimeout(timeoutInMills, TimeUnit.MILLISECONDS)
                .readTimeout(timeoutInMills, TimeUnit.MILLISECONDS)
                .writeTimeout(timeoutInMills, TimeUnit.MILLISECONDS);


        return okHttpBuilder.build();
    }
}

