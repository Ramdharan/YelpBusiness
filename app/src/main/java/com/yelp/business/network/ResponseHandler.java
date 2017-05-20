package com.yelp.business.network;

import com.yelp.clientlib.entities.Business;

import java.util.ArrayList;



public interface ResponseHandler {
    public void failure();
    public void success(ArrayList<Business> data);
}
