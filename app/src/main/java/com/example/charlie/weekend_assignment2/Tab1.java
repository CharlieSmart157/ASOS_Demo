package com.example.charlie.weekend_assignment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.weekend_assignment2.Model.Category_ListModel;
import com.example.charlie.weekend_assignment2.Model.Gender_Cat_Adapter;
import com.example.charlie.weekend_assignment2.Model.Listing;
import com.example.charlie.weekend_assignment2.Observables.IWomen_CatAPI;
import com.example.charlie.weekend_assignment2.Utility.Constants;
import com.example.charlie.weekend_assignment2.Utility.RxUtils;

import java.util.ArrayList;

import retrofit.RestAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment {
    ArrayList<Listing> categories = new ArrayList<Listing>();
    Gender_Cat_Adapter categoryAdapter;
    private CompositeSubscription _subscriptions = new CompositeSubscription();
    IWomen_CatAPI iWomen_catAPI;
    private RecyclerView lvCategories;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.tab_1,container,false);
        initializeRecyclerView(view);
        RestAdapter restapi = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        iWomen_catAPI = restapi.create(IWomen_CatAPI.class);
        _subscriptions.add(
                iWomen_catAPI.getCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new rx.Observer<Category_ListModel>(){


                    @Override
                    public void onCompleted() {
                        Log.i("Categories:",""+categories.size());
                        categoryAdapter = new Gender_Cat_Adapter(getContext(),categories ,R.layout.card_row);

                        lvCategories.setAdapter(categoryAdapter);
                        categoryAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Err0r", ""+e);
                    }

                    @Override
                    public void onNext(Category_ListModel category_listModels) {
                        categories.addAll(category_listModels.getListing());
                    }
                })
        );


        return view;
    }

    public void initializeRecyclerView(View v){
        lvCategories = (RecyclerView)v.findViewById(R.id.recyclerView);
        lvCategories.setLayoutManager(new LinearLayoutManager(getActivity()));
        lvCategories.setItemAnimator(new DefaultItemAnimator());

        Set_refreshed_data();

    }

    private void Set_refreshed_data(){
       // categories.clear();

    }

    @Override
    public void onPause(){
        super.onPause();
        RxUtils.unsubscribeIfNotNull(_subscriptions);
    }

}
