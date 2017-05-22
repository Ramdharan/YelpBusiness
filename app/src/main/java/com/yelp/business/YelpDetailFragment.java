package com.yelp.business;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yelp.business.adapters.UserReviewAdapter;
import com.yelp.clientlib.entities.Business;

public class YelpDetailFragment extends DialogFragment {
    private View mView;
    private Business mBusiness;
    private RecyclerView mRecyclerView;
   

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBusiness= (Business) this.getArguments().getSerializable("business");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.detail_screen,null);
        ImageView businessImg= (ImageView) mView.findViewById(R.id.bussiness_img);
        Picasso.with(getContext()).load("http://i.imgur.com/DvpvklR.png").into(businessImg);
        TextView phone=(TextView)mView.findViewById(R.id.business_phone);
        phone.setText(mBusiness.displayPhone());

        TextView rating=(TextView)mView.findViewById(R.id.business_rating_detail);
        rating.setText(String.valueOf(mBusiness.rating()));
        TextView name=(TextView)mView.findViewById(R.id.bussiness_name_detail);
        name.setText(mBusiness.name());
        TextView category=(TextView)mView.findViewById(R.id.bussiness_category);
        StringBuffer buffer=new StringBuffer();
        int size=mBusiness.categories().size();
        for(int categoryData=0;categoryData<size;categoryData++){
            buffer.append(mBusiness.categories().get(categoryData).name());
            if(categoryData!=size-1){
                buffer.append(",");
            }
        }
        category.setText(buffer.toString());

        mRecyclerView = (RecyclerView)mView.findViewById(R.id.recyclerView_details_id);
        if(null != mBusiness.reviews() && mBusiness.reviews().size()!= 0){
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());//Loog.e("",mBusiness.reviews().c)
            mRecyclerView.setVisibility(View.VISIBLE);
            UserReviewAdapter userReviewAdapter = new UserReviewAdapter(getActivity(),mBusiness.reviews());
            mRecyclerView.setAdapter(userReviewAdapter);
        }else{
            mRecyclerView.setVisibility(View.GONE);
            //todo
        }
        return mView;
    }
}
