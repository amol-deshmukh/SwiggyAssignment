package com.deshmukh.swiggyassignment.listeners;

import com.deshmukh.swiggyassignment.models.APiResponse;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public interface ResponseListener {

    void onSuccess(APiResponse aPiResponse);
    void onFailures();
}
