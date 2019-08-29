package com.zak;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.Style;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.*;
import com.zak.R;


public class URLImageView extends RelativeLayout {
    private Style mStyle;
    private int mColor;
    private Drawable mPlaceholder;
    private ImageView.ScaleType mScaleType;

    private ImageView mTargetImage, mRefresh;
    private com.github.ybq.android.spinkit.SpinKitView mProgressbar;

    public URLImageView(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    public URLImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, com.zak.R.styleable.URLImage);

        mStyle = Style.values()[a.getInt(com.zak.R.styleable.URLImage_Spinner_Style, 9)];
        mColor = a.getColor(com.zak.R.styleable.URLImage_Spinner_Color, R.color.colorAccent);
        mPlaceholder = a.getDrawable(com.zak.R.styleable.URLImage_Placeholder);
        mScaleType = ImageView.ScaleType.values()[a.getInt(com.zak.R.styleable.URLImage_scaleType, 0)];

        createTargetImage();
        createProgressbar();
        createRefreshButton();

        a.recycle();
        init();
    }

    private void createTargetImage() {
        mTargetImage = new ImageView(getContext());

        LayoutParams params = new LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT);
        mTargetImage.setLayoutParams(params);
        mTargetImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mTargetImage.setScaleType(mScaleType);

        addView(mTargetImage);

    }


    private void createRefreshButton() {

        mRefresh = new ImageView(getContext());
        mRefresh.setImageDrawable(getResources().getDrawable(com.zak.R.drawable.ic_refresh));
        LayoutParams params = new LayoutParams(dip2px(40f), dip2px(40f));
        mRefresh.setLayoutParams(params);
        LayoutParams layoutParams = (LayoutParams) mRefresh.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        mRefresh.setLayoutParams(layoutParams);

        addView(mRefresh);
    }

    private void createProgressbar() {
        mProgressbar = new SpinKitView(getContext());

        LayoutParams params = new LayoutParams(dip2px(50f), dip2px(50f));
        mProgressbar.setLayoutParams(params);
        LayoutParams layoutParams = (LayoutParams) mProgressbar.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        mProgressbar.setLayoutParams(layoutParams);

        addView(mProgressbar);
    }


    private int dip2px(float dip) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );
        return (int) px;
    }

    private void init() {

        mProgressbar.setColor(mColor);
        Sprite style = new Circle();
        switch (mStyle) {
            case WAVE:
                style = new Wave();
                break;
            case PULSE:
                style = new Pulse();
                break;
            case CHASING_DOTS:
                style = new ChasingDots();
                break;
            case CIRCLE:
                style = new Circle();
                break;
            case CUBE_GRID:
                style = new CubeGrid();
                break;
            case DOUBLE_BOUNCE:
                style = new DoubleBounce();
                break;
            case FADING_CIRCLE:
                style = new FadingCircle();
                break;
            case FOLDING_CUBE:
                style = new FoldingCube();
                break;
            case MULTIPLE_PULSE:
                style = new MultiplePulse();
                break;
            case MULTIPLE_PULSE_RING:
                style = new MultiplePulseRing();
                break;
            case PULSE_RING:
                style = new PulseRing();
                break;
            case ROTATING_CIRCLE:
                style = new RotatingCircle();
                break;
            case ROTATING_PLANE:
                style = new RotatingPlane();
                break;
            case THREE_BOUNCE:
                style = new ThreeBounce();
                break;
            case WANDERING_CUBES:
                style = new WanderingCubes();
                break;
        }
        mProgressbar.setIndeterminateDrawable(style);
    }


    public void load(String url) {
        DownloadImageFromUrl imageUrl = new DownloadImageFromUrl(getContext(), url, mTargetImage, mProgressbar, mRefresh, mPlaceholder);
        imageUrl.load();
    }

}