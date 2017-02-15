package com.asiainfo.imageprocess.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.asiainfo.imageprocess.R;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月14日21点35分 描述:
 */
public class ColorMatrixActivity extends Activity implements View.OnClickListener {

    private static final int TOTAL_COUNT_EDITTEXT = 20;//EditText个数
    private static final int LINE = 5;//行
    private static final int ROW = 4;//列
    private EditText[] mEts = new EditText[TOTAL_COUNT_EDITTEXT];
    private float[] mColorMatrix = new float[TOTAL_COUNT_EDITTEXT]; //对应PPT的矩阵

    private ImageView mImgViewMatrix;
    private GridLayout mEtGroup;
    private Button mBtnChange;
    private Button mBtnReset;
    private Bitmap mBitmap;
    private int mEtWidth, mEtHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);

        initView();
        initListener();
        initEvent();
    }


    private void initView() {

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
        mImgViewMatrix = (ImageView) findViewById(R.id.matrix_img);
        mEtGroup = (GridLayout) findViewById(R.id.group_et);
        mBtnChange = (Button) findViewById(R.id.btn_change);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mImgViewMatrix.setImageBitmap(mBitmap);
    }

    private void initListener() {

        mBtnChange.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);

    }

    private void initEvent() {

        mEtGroup.post(new Runnable() {
            @Override
            public void run() {

                mEtWidth = mEtGroup.getWidth() / LINE;
                mEtHeight = mEtGroup.getHeight() / ROW;
                addEditTexts();//显示20个EditText
                initMatrix();//赋值

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_change:

                getMatrix();
                setImageMatrix();

                break;

            case R.id.btn_reset:

                initMatrix();
                getMatrix();
                setImageMatrix();

                break;

        }

    }

    /***
     * 将20个EditText添加到GridLayout里面
     */
    private void addEditTexts() {

        for (int i = 0; i < TOTAL_COUNT_EDITTEXT; i++) {

            EditText singleEditText = new EditText(this);
            singleEditText.setGravity(Gravity.CENTER);
            mEts[i] = singleEditText;
            mEtGroup.addView(singleEditText, mEtWidth, mEtHeight);

        }

    }

    /***
     * 初始化矩阵
     */
    private void initMatrix() {

        for (int i = 0; i < TOTAL_COUNT_EDITTEXT; i++) {

            if (i % 6 == 0) {

                mEts[i].setText(String.valueOf(1));

            } else {

                mEts[i].setText(String.valueOf(0));
            }

        }

    }

    /***
     * 获取当前所有EditText的所有值
     */
    private void getMatrix() {

        for (int i = 0; i < TOTAL_COUNT_EDITTEXT; i++) {

            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());

        }

    }


    /***
     * 将颜色矩阵应用的我们的EditText
     */
    private void setImageMatrix() {

        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colormatrix = new ColorMatrix();
        colormatrix.set(mColorMatrix);

        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(colormatrix));
        canvas.drawBitmap(mBitmap, 0, 0, paint);
        mImgViewMatrix.setImageBitmap(bmp);

    }

}
