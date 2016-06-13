package com.example.charlie.weekend_assignment2.Observables;

import com.example.charlie.weekend_assignment2.Model.Category_ListModel;
import com.example.charlie.weekend_assignment2.Utility.Constants;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Charlie on 12/06/2016.
 */
public interface IWomen_CatAPI {

@GET(Constants.WOMENSLIST_URL)
    Observable<Category_ListModel>getCategories();

}
