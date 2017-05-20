package com.yelp.business.network;

import android.util.Log;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;
import com.yelp.clientlib.entities.options.CoordinateOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class YelpRequest implements Callback<SearchResponse> {

    private final String CONSUMER_KEY = "HggTeqGsXjogMpzwou9xqw";
    private final String CONSUMER_SECRET = "ZImU_0DqhljjaRGQPq4X86QWBwQ";
    private final String TOKEN = "mNnZVysoRR8qaIAha0zylXMf83dFDI5_";
    private final String TOKEN_SECRET = "QwEulDPechkK384EVhW6ut6B0Jg";
    public ArrayList<Business> businessesList;
    private ResponseHandler responseHandler;
    public  YelpRequest(ResponseHandler handler){
        this.responseHandler=handler;
    }
    public void getData(Double lat,Double lon) {

        try {
            YelpAPIFactory apiFactory = new YelpAPIFactory(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
            YelpAPI yelpAPI = apiFactory.createAPI();
            Map<String, String> params = new HashMap<>();
            params.put("term", "restaurants");
            params.put("radius_filter","1609.34");
            // params.put("latitude", "40.581140");
            //params.put("longitude", "-111.914184");
            CoordinateOptions coordinate = CoordinateOptions.builder()
                    .latitude(lat)
                    .longitude(lon).build();

            Call<SearchResponse> call = yelpAPI.search(coordinate, params);
            call.enqueue(YelpRequest.this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
        Log.e("","SUCCESS>....");
      //  businessesList = response.body().businesses();
        responseHandler.success(response.body().businesses());
    }

    @Override
    public void onFailure(Call<SearchResponse> call, Throwable t) {
            responseHandler.failure();
    }
}
