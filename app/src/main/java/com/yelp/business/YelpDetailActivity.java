package com.yelp.business;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yelp.clientlib.entities.Business;

/**
 * Created by ramdharandonda on 5/19/17.
 */

public class YelpDetailActivity extends AppCompatActivity{
    Business mBusiness;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState,@Nullable  PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.e("","ON CREATE>>>>");
        setContentView(R.layout.detail_screen);
        /*setContentView(R.layout.detail_screen);
        Log.e("","ON CREATE>>>>");
        mBusiness= (Business) getIntent().getSerializableExtra("business");
        Log.e("GOT BUSINESSS",mBusiness.toString());

        ImageView businessImg= (ImageView) findViewById(R.id.bussiness_img);
        TextView phone=(TextView)findViewById(R.id.business_phone);
        phone.setText(mBusiness.displayPhone());

        TextView rating=(TextView)findViewById(R.id.business_rating_detail);
        rating.setText(String.valueOf(mBusiness.rating()));

        TextView name=(TextView)findViewById(R.id.bussiness_name_detail);
        name.setText(mBusiness.name());
        TextView category=(TextView)findViewById(R.id.bussiness_category);
        category.setText(mBusiness.categories().toString());*/
        Log.e("DETAIL FRAG","DETAIL VIEW CREATED>>>>");

    }
}
