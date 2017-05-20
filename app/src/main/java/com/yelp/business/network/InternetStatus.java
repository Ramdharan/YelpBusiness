package com.yelp.business.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetStatus {

    private static InternetStatus mInternetStatus;

    private InternetStatus() {
    }

    public static InternetStatus getInstance(){
        if(null == mInternetStatus){
            mInternetStatus =new InternetStatus();
        }
        return mInternetStatus;
    }


    //to check whether networks avialable or not
    public static Boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }


    // to check whether active internet connection
    public static Boolean isOnline(Context context) {
        boolean reachable = false;
        try {
            Process p1 = Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            reachable = (returnVal == 0);
            return reachable;
        } catch (Exception e) {
        }
        return reachable;
    }
}
