package com.asiainfo.imageprocess.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.asiainfo.imageprocess.R;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月15日16点06分 描述:着色器,渲染器
 */
public class BitmapShaderView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private BitmapShader mBitmapShader;

    public BitmapShaderView(Context context) {
        super(context);
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test4);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(mBitmapShader);
        canvas.drawCircle(300, 200, 270, mPaint);


    }
}
