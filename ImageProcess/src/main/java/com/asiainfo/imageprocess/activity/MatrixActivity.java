package com.asiainfo.imageprocess.activity;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.asiainfo.imageprocess.R;
import com.asiainfo.imageprocess.view.ImageMatrixView;

/**
 * 作者:小木箱 邮箱:yangzy3@asiainfo.com 创建时间:2017年02月15日14点14分 描述:
 */
public class MatrixActivity extends Activity implements View.OnClickListener {

    private static final int SUDOKU_COUNTS = 9;//九宫格
    private static final int LINE = 3;//行
    private static final int ROW = 3;//列

    private GridLayout mEtGroup;
    private ImageMatrixView mImageViewMatrix;
    private Button mBtnChange;
    private Button mBtnReset;
    private int mEdHeight, mEdWidth;
    private float[] mImageMatrix = new float[SUDOKU_COUNTS];
    private EditText[] mEts = new EditText[SUDOKU_COUNTS];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        initView();
        initListener();
        initEvent();
    }


    private void initView() {

        mBtnChange = (Button) findViewById(R.id.btn_change);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mImageViewMatrix = (ImageMatrixView) findViewById(R.id.matrix_img);
        mEtGroup = (GridLayout) findViewById(R.id.group_et);

    }

    private void initListener() {

        mBtnChange.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);

    }

    private void initEvent() {

        mEtGroup.post(new Runnable() {
            @Override
            public void run() {

                mEdWidth = mEtGroup.getWidth() / LINE;
                mEdHeight = mEtGroup.getWidth() / ROW;
                addEts();
                initImageMatrix();//初始化矩阵
            }
        });

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_change:

                getImageMatrix();
                setImageMatrix();

                break;

            case R.id.btn_reset:

                initImageMatrix();
                getImageMatrix();
                setImageMatrix();

                break;

            default:
                break;

        }
    }


    /***
     * 添加EditText
     */

    private void addEts() {

        for (int i = 0; i < SUDOKU_COUNTS; i++) {

            EditText et = new EditText(this);
            et.setGravity(Gravity.CENTER);
            mEts[i] = et;
            mEtGroup.addView(et, mEdWidth, mEdHeight);

        }

    }

    private void initImageMatrix() {

        for (int i = 0; i < SUDOKU_COUNTS; i++) {

            if (i % 4 == 0) {

                mEts[i].setText(String.valueOf(1));

            } else {

                mEts[i].setText(String.valueOf(0));

            }

        }

    }

    private void getImageMatrix() {

        for (int i = 0; i < SUDOKU_COUNTS; i++) {
            EditText et = mEts[i];
            mImageMatrix[i] = Float.parseFloat(et.getText().toString());

        }

    }


    private void setImageMatrix() {

        Matrix matrix = new Matrix();
        matrix.setValues(mImageMatrix);
        mImageViewMatrix.setImageMatrix(matrix);
        mImageViewMatrix.invalidate();

    }
}
