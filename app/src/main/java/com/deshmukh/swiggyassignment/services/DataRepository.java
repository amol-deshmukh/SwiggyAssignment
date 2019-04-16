package com.deshmukh.swiggyassignment.services;

import android.util.Log;

import com.deshmukh.swiggyassignment.apis.MainApi;
import com.deshmukh.swiggyassignment.listeners.ResponseListener;
import com.deshmukh.swiggyassignment.models.APiResponse;
import com.deshmukh.swiggyassignment.network.RetrofitProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class DataRepository {
    public static void makeAPICall(final ResponseListener responseListener) {
        MainApi service = RetrofitProvider.getRetrofitInstance().create(MainApi.class);
        Call<APiResponse> call = service.getApiResponse();
        call.enqueue(new Callback<APiResponse>() {
            @Override
            public void onResponse(Call<APiResponse> call, Response<APiResponse> response) {
                responseListener.onSuccess(response.body());
                Log.e("@@@@","API recieved");

            }

            @Override
            public void onFailure(Call<APiResponse> call, Throwable t) {
                responseListener.onFailures();

            }
        });
    }
}
