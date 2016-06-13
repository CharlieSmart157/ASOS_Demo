package com.example.charlie.weekend_assignment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.weekend_assignment2.Model.Listing;
import com.example.charlie.weekend_assignment2.Model.Products_Adapter;
import com.example.charlie.weekend_assignment2.Model.Products_Model;
import com.example.charlie.weekend_assignment2.Observables.IAny_CatApi;
import com.example.charlie.weekend_assignment2.Utility.Constants;

import java.util.ArrayList;

import retrofit.RestAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Charlie on 13/06/2016.
 */
public class Products_Fragment extends Fragment{

    View view;
    private RecyclerView lvProducts;
    IAny_CatApi iAny_catApi;
    private CompositeSubscription _subscriptions = new CompositeSubscription();
    ArrayList<Listing> products = new ArrayList<Listing>();
    Products_Adapter productAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.product_list_layout,container,false);
        initializeRecyclerView(view);

        RestAdapter restapi = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        iAny_catApi = restapi.create(IAny_CatApi.class);

        _subscriptions.add(
                iAny_catApi.getCategories(getArguments().getString("Cat_ID"))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new rx.Observer<Products_Model>(){


                            @Override
                            public void onCompleted() {
                                productAdapter = new Products_Adapter(getActivity().getApplicationContext(),products ,R.layout.card_row);
                                lvProducts.setAdapter(productAdapter);
                                productAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Products_Model products_model) {
                                products.addAll(products_model.getListings());
                            }
                        })



        );

        return view;
    }

    public void initializeRecyclerView(View v){
        lvProducts = (RecyclerView)v.findViewById(R.id.recyclerView);
        lvProducts.setLayoutManager(new GridLayoutManager(getActivity(),2));
        lvProducts.setItemAnimator(new DefaultItemAnimator());



    }
}
