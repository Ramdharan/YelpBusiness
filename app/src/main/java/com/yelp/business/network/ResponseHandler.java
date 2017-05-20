package com.yelp.business.network;

import com.yelp.clientlib.entities.Business;

import java.util.ArrayList;

/**
 * Created by ramdharandonda on 5/18/17.
 */

public interface ResponseHandler {
    public void failure();
    public void success(ArrayList<Business> data);
}
