package com.deshmukh.swiggyassignment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.deshmukh.swiggyassignment.models.APiResponse;
import com.deshmukh.swiggyassignment.models.ExcludeList;
import com.deshmukh.swiggyassignment.presenters.CustomView;
import com.deshmukh.swiggyassignment.presenters.Presenter;
import com.deshmukh.swiggyassignment.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AppView {
    Presenter presenter;

   CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView=findViewById(R.id.customView);
        presenter= new Presenter(this);
        presenter.makeApiCall();
    }

    @Override
    public void displayData(APiResponse aPiResponse) {
      //Extra test case
       /* ExcludeList excludeList1= new ExcludeList();
        excludeList1.setGroupId(2+"");
        excludeList1.setVariationId(11+"");
        ExcludeList excludeList2= new ExcludeList();
        excludeList2.setGroupId(3+"");
        excludeList2.setVariationId(20+"");
        List<ExcludeList> lists= new ArrayList<>();
        lists.add(excludeList1);
        lists.add(excludeList2);
        aPiResponse.getVariants().getExcludeList().add(lists);*/
        customView.init(aPiResponse);

    }


}
