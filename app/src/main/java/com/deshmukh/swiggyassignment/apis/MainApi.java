package com.deshmukh.swiggyassignment.apis;

import com.deshmukh.swiggyassignment.models.APiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public interface MainApi {
    @GET("./bins/3b0u2/")
    Call<APiResponse> getApiResponse();

}
