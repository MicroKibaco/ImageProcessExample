package com.asiainfo.imageprocess.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asiainfo.imageprocess.R;

public class ImageProcessActivity extends Activity implements View.OnClickListener {

    private Button mBtnPrimaryColor;
    private Button mBtnMatrixColor;
    private Button mBtnPixelsEffect;
    private Button mBtnMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_process);

        initView();
        initListener();

    }

    private void initListener() {

        mBtnPrimaryColor.setOnClickListener(this);
        mBtnMatrixColor.setOnClickListener(this);
        mBtnPixelsEffect.setOnClickListener(this);
        mBtnMatrix.setOnClickListener(this);

    }

    private void initView() {

        mBtnPrimaryColor = (Button) findViewById(R.id.btn_primary_color);
        mBtnMatrixColor = (Button) findViewById(R.id.btn_matrix_color);
        mBtnPixelsEffect = (Button) findViewById(R.id.btn_pixels_effect);
        mBtnMatrix = (Button) findViewById(R.id.btn_Matrix);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_primary_color:

                startActivity(new Intent(this, PrimaryColorActivity.class));

                break;

            case R.id.btn_matrix_color:

                startActivity(new Intent(this, ColorMatrixActivity.class));

                break;

            case R.id.btn_pixels_effect:

                startActivity(new Intent(this, PixelsActivity.class));

                break;

            case R.id.btn_Matrix:
                startActivity(new Intent(this, MatrixActivity.class));

                break;

        }

    }
}
