package com.yelp.business;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yelp.clientlib.entities.Business;

/**
 * Created by ramdharandonda on 5/18/17.
 */

public class YelpBottomSheetDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener{
    private  View mCurrentView;
    private Bundle mArguments;
    private Business mCurrentBusiness;
    private Button mMoreBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     mArguments=this.getArguments();
        mCurrentBusiness= (Business) mArguments.getSerializable("business");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
mCurrentView=inflater.inflate(R.layout.bottom_sheet_content,null);
        TextView name= (TextView) mCurrentView.findViewById(R.id.bussiness_name);
        name.setText(mCurrentBusiness.name());

        RatingBar rating=(RatingBar)mCurrentView.findViewById(R.id.business_rating);
       // rating.setText(String.valueOf(mCurrentBusiness.rating()));
rating.setRating(Float.valueOf(String.valueOf(mCurrentBusiness.rating())));
        TextView address= (TextView) mCurrentView.findViewById(R.id.address_details);
        address.setText(mCurrentBusiness.location().displayAddress().toString());
          mMoreBtn=(Button)mCurrentView.findViewById(R.id.btn_more);
        mMoreBtn.setOnClickListener(this);
        return mCurrentView;
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_more){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Bundle args=new Bundle();
            args.putSerializable("business",mCurrentBusiness);
            YelpDetailFragment llf = new YelpDetailFragment();
            llf.setArguments(args);
            ft.add(llf,"detail");
            ft.addToBackStack(null);
            ft.commit();
            /*Intent detail=new Intent();
detail.setClass(getActivity().getApplicationContext(),YelpDetailActivity.class);
           // detail.putExtra("business",mCurrentBusiness);
            detail.putExtras(args);
            getActivity().startActivity(detail);*/
            dismiss();
        }
    }
}
