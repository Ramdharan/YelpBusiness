package com.yelp.business.adapters;

/**
 * Created by ramdharandonda on 5/19/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yelp.business.R;
import com.yelp.clientlib.entities.Review;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
public class UserReviewAdapter extends RecyclerView.Adapter<UserReviewAdapter.MyViewHolder>{

    private Context mContext;
private ArrayList<Review> mReviewsList;
    public UserReviewAdapter(Context context, ArrayList<Review> reviewsList){
        mContext = context;
        this.mReviewsList=reviewsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_review_list,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Review review=mReviewsList.get(position);
        Picasso.with(mContext).load(review.user().imageUrl()).placeholder(R.drawable.common_google_signin_btn_icon_dark_focused).fit().into(holder.mCircleImageViewUser);
        holder.mTextViewUserName.setText(review.user().name());
        holder.mTextViewUserComments.setText(review.excerpt());
        holder.mRatingBarUserRatting.setRating(Float.valueOf(String.valueOf(review.rating())));
    }

    @Override
    public int getItemCount() {
        return mReviewsList.size();//size
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mCircleImageViewUser;
        private TextView mTextViewUserName;
        private TextView mTextViewUserComments;
        private RatingBar mRatingBarUserRatting;
        public MyViewHolder(View view) {
            super(view);

            mCircleImageViewUser = (CircleImageView)view.findViewById(R.id.user_image);
            mTextViewUserName=(TextView) view.findViewById(R.id.username_detail);
            mTextViewUserComments=(TextView) view.findViewById(R.id.user_comments);
            mRatingBarUserRatting=(RatingBar) view.findViewById(R.id.rating_bar_detail);


        }
    }
}