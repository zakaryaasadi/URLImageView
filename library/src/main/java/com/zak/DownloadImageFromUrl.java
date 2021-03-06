package com.zak;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DownloadImageFromUrl {

    private final int layout_width, layout_height;
    private Context mContext;
    private String mUrl;
    private ImageView mTarget;
    private ProgressBar mProgressbar;
    private ImageView mRefresh;
    private Drawable mPlaceholder;
    private URLImageView.Callback mCallback;
    private Bitmap mBitmap;


    private void init(Context context, String url, ImageView target, SpinKitView progressBar, ImageView refresh, Drawable placeholder, URLImageView.Callback callback){
        mUrl = url;
        mTarget = target;
        mProgressbar = progressBar;
        mRefresh = refresh;
        mContext = context;
        mPlaceholder = placeholder;
        mCallback = callback;

        if(mPlaceholder == null)
            mPlaceholder = context.getResources().getDrawable(com.zak.R.drawable.gray_rect);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
    }



    public DownloadImageFromUrl(Context context, String url, ImageView target, SpinKitView progressBar, ImageView refresh, Drawable placeholder, URLImageView.Callback callback, int layout_width, int layout_height) {
        init(context, url, target, progressBar, refresh,placeholder, callback);
        this.layout_width = layout_width;
        this.layout_height = layout_height;
    }


    public void load(){

        mRefresh.setVisibility(View.GONE);
        mProgressbar.setVisibility(View.VISIBLE);

        if(mCallback != null){
            mCallback.onStartLoad();
        }

        Picasso.get().load(mUrl).placeholder(mPlaceholder)
                .into(mTarget, new Callback() {
                    @Override
                    public void onSuccess() {
                        mProgressbar.setVisibility(View.GONE);
                        mBitmap = ((BitmapDrawable) mTarget.getDrawable()).getBitmap();
                        changeResolution(mBitmap.getWidth(), mBitmap.getHeight());
                        if(mCallback != null){
                            mCallback.onSuccess(mBitmap);
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        mTarget.setImageDrawable(mContext.getResources().getDrawable(com.zak.R.drawable.white_rect));
                        mProgressbar.setVisibility(View.GONE);
                        mRefresh.setVisibility(View.VISIBLE);

                        if(mCallback != null){
                            mCallback.onError(e);
                        }
                    }
                });
    }



    private void changeResolution(int width, int height){

        RelativeLayout relativeLayoutParent =
                ((RelativeLayout)mTarget.getParent());

        int imageViewWeight = mTarget.getMeasuredWidth();

        float newImageViewHeight = imageViewWeight * height / (float) width;

        int newHeight = Math.round(newImageViewHeight);


        ViewGroup.LayoutParams params = relativeLayoutParent.getLayoutParams();
        params.height = newHeight;
        params.width = imageViewWeight;
        relativeLayoutParent.setLayoutParams(params);
    }


}
