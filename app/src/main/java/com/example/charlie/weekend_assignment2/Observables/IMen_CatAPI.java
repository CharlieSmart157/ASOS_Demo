package com.example.charlie.weekend_assignment2.Observables;

import android.database.Observable;

import com.example.charlie.weekend_assignment2.Model.Category_ListModel;
import com.example.charlie.weekend_assignment2.Utility.Constants;

import retrofit.http.GET;

/**
 * Created by Charlie on 12/06/2016.
 */
public interface IMen_CatAPI {

@GET(Constants.MENSLIST_URL)
    Observable<Category_ListModel>getCategories();

}
