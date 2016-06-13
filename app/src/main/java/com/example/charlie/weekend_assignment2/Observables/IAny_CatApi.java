package com.example.charlie.weekend_assignment2.Observables;



import com.example.charlie.weekend_assignment2.Model.Products_Model;
import com.example.charlie.weekend_assignment2.Utility.Constants;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Charlie on 12/06/2016.
 */
public interface IAny_CatApi {


@GET (Constants.ANYCAT_PRODUCTS_URL)
    Observable<Products_Model>getCategories(@Query("catid")String cat_ID );

}
