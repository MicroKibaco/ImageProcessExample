package com.asiainfo.imageprocess.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

    private static final int TOTAL_COUNT_EDITTEXT = 20;
    private ImageView mImgViewMatrix;
    private GridLayout mEtGroup;
    private Button mBtnChange;
    private Button mBtnReset;
    private Bitmap mBitmap;
    private int mEtWidth, mEtHeight;
    private EditText[] mEts = new EditText[20];
    private float[] mColorMatrix = new float[20]; //对应PPT的矩阵

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);

        initView();
        initListener();
        initEvent();
    }

    private void initEvent() {

        mEtGroup.post(new Runnable() {
            @Override
            public void run() {

                mEtWidth = mEtGroup.getWidth() / 5;
                mEtHeight = mEtGroup.getHeight() / 4;
                addEditTexts();
                initMatrix();//赋值

            }
        });

    }

    private void initListener() {

        mBtnChange.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);

    }

    private void initView() {

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test1);
        mImgViewMatrix = (ImageView) findViewById(R.id.matrix_img);
        mEtGroup = (GridLayout) findViewById(R.id.group_et);
        mBtnChange = (Button) findViewById(R.id.btn_change);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mImgViewMatrix.setImageBitmap(mBitmap);
    }

    /***
     * 将20个EditText添加到GridLayout里面
     */
    private void addEditTexts() {

        for (int i = 0; i < TOTAL_COUNT_EDITTEXT; i++) {

            EditText singleEditText = new EditText(this);
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


    @Override
    public void onClick(View v) {

    }
}
