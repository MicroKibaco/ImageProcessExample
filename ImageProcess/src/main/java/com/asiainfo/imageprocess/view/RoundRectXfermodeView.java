package com.asiainfo.imageprocess.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.asiainfo.imageprocess.R;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月15日15点29分 描述:
 */
public class RoundRectXfermodeView extends View {

    private Bitmap mInBitmap;
    private Bitmap mOutBitmap;
    private Paint mPaint;

    public RoundRectXfermodeView(Context context) {
        super(context);
        initView();
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public RoundRectXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initView() {

        setLayerType(LAYER_TYPE_SOFTWARE, null);//禁止硬件加速
        mInBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test2);

        mOutBitmap = Bitmap.createBitmap(mInBitmap.getWidth(),
                mInBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mOutBitmap);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //DST
        canvas.drawRoundRect(0, 0, mInBitmap.getWidth(), mInBitmap.getHeight(), 50, 50, mPaint);
        //SRC
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mInBitmap, 0, 0, mPaint);
        mPaint.setXfermode(null);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(mOutBitmap, 0, 0, null);
    }
}
