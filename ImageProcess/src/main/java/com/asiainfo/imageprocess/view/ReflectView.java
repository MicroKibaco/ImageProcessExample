package com.asiainfo.imageprocess.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.asiainfo.imageprocess.R;


/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月15日16点36分 描述:镜像效果
 */
public class ReflectView extends View {

    private Bitmap mSrcBitmap;
    private Bitmap mReflectBitmap;
    private Paint mPaint;

    public ReflectView(Context context) {
        super(context);
        initView();
    }


    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {

        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);//X轴对称
        mReflectBitmap = Bitmap.createBitmap(mSrcBitmap, 0, 0, mSrcBitmap.getWidth(),
                mSrcBitmap.getHeight(), matrix, true);
        mPaint = new Paint();
        mPaint.setShader(new LinearGradient(0, mSrcBitmap.getHeight(), 0, mSrcBitmap.getHeight() * 2,
                0xDD000000, 0x10000000, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(mSrcBitmap, 0, 0, null);
        canvas.drawBitmap(mReflectBitmap, 0, mSrcBitmap.getHeight(), null);
        canvas.drawRect(0, mReflectBitmap.getHeight(),
                mReflectBitmap.getWidth(), mReflectBitmap.getHeight() * 2, mPaint);
    }
}
