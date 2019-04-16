package com.deshmukh.swiggyassignment.presenters;

import android.util.Log;

import com.deshmukh.swiggyassignment.activities.AppView;
import com.deshmukh.swiggyassignment.listeners.ResponseListener;
import com.deshmukh.swiggyassignment.models.APiResponse;
import com.deshmukh.swiggyassignment.services.DataRepository;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class Presenter implements ResponseListener {
    AppView activity;
    public Presenter(AppView activity){
        this.activity=activity;
    }

    public void makeApiCall() {
        DataRepository.makeAPICall(this);

    }


    @Override
    public void onSuccess(APiResponse aPiResponse) {
        Log.e("@@@@",aPiResponse.toString());

        //CustomView customView= new CustomView(activity);
       // customView.init(aPiResponse);
        activity.displayData(aPiResponse);
    }

    @Override
    public void onFailures() {
        Log.e("@@@@","Error occured");

    }
}
