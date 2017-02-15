package com.asiainfo.imageprocess.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.asiainfo.imageprocess.R;
import com.asiainfo.imageprocess.utils.ImageHelper;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月15日09点29分 描述:
 */
public class PixelsActivity extends Activity {

    private ImageView mFirstImageView, mSecondImageView, mThereImageView, mFourImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixels);

        initView();
        initListener();

    }

    private void initListener() {


    }

    private void initView() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
        mFirstImageView = (ImageView) findViewById(R.id.first_Imagview);
        mSecondImageView = (ImageView) findViewById(R.id.second_Imagview);
        mThereImageView = (ImageView) findViewById(R.id.three_Imagview);
        mFourImageView = (ImageView) findViewById(R.id.four_Imagview);

        mFirstImageView.setImageBitmap(bitmap);
        mSecondImageView.setImageBitmap(ImageHelper.handlerImageNegative(bitmap));

    }
}
