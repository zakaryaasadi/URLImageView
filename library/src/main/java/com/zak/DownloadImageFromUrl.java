package com.zak;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DownloadImageFromUrl {

    private Context mContext;
    private String mUrl;
    private ImageView mTarget;
    private ProgressBar mProgressbar;
    private ImageView mRefresh;
    private Drawable mPlaceholder;


    public DownloadImageFromUrl(Context context, String url, ImageView target, ProgressBar progressBar, ImageView refresh) {

    }

    public DownloadImageFromUrl(Context context, String url, ImageView target, ProgressBar progressBar, ImageView refresh, Drawable placeholder) {
        mUrl = url;
        mTarget = target;
        mProgressbar = progressBar;
        mRefresh = refresh;
        mContext = context;
        mPlaceholder = placeholder;
        if(mPlaceholder == null)
            mPlaceholder = context.getResources().getDrawable(com.zak.R.drawable.gray_rect);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
    }


    public void load(){
        mRefresh.setVisibility(View.GONE);
        mProgressbar.setVisibility(View.VISIBLE);

        Picasso.get().load(mUrl).placeholder(mPlaceholder)
                .into(mTarget, new Callback() {
                    @Override
                    public void onSuccess() {
                        mProgressbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        mTarget.setImageDrawable(mContext.getResources().getDrawable(com.zak.R.drawable.white_rect));
                        mProgressbar.setVisibility(View.GONE);
                        mRefresh.setVisibility(View.VISIBLE);
                    }
                });
    }



}
