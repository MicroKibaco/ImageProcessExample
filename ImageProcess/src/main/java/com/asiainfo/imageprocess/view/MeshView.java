package com.asiainfo.imageprocess.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.asiainfo.imageprocess.R;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月15日17点07分 描述:
 */
public class MeshView extends View {

    private static final int HEIGHT = 200;
    private static final int WIDTH = 200;
    private static final int COUNT = (WIDTH + 1) * (HEIGHT + 1);
    private float[] verts = new float[COUNT * 2];
    private float[] orig = new float[COUNT * 2];

    private Bitmap mBitmap;
    private float K = 1;


    public MeshView(Context context) {
        super(context);
        initView();
    }


    public MeshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MeshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test4);


        float bmWidth = mBitmap.getWidth();
        float mHeight = mBitmap.getHeight();

        int index = 0;
        for (int i = 0; i <= HEIGHT; i++) {

            float fy = mHeight * i / HEIGHT;

            for (int j = 0; j <= WIDTH; j++) {

                float fx = bmWidth * j / WIDTH;

                orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy;

                index += 1;

            }

        }


    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < HEIGHT + 1; i++) {

            for (int j = 0; j < WIDTH + 1; j++) {

                verts[(i * (WIDTH + 1) + j) * 2 + 0] += 0;

                float offsetY = (float) Math.sin((float) j / WIDTH * 2 * Math.PI + K * 2 * Math.PI);

                verts[(i * (WIDTH + 1) + j) * 2 + 1] = orig[(i * (WIDTH + 1) + j) * 2 + 1] + offsetY * 50;

            }

        }

        K += 0.1F;
        canvas.drawBitmapMesh(mBitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
        invalidate();

    }
}
