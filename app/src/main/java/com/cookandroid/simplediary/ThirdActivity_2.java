package com.cookandroid.simplediary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity_2 extends AppCompatActivity {
    Button btnSave1, btnCam1_1,btnCam1_2,btnCam1_3;
    TextView title1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_2);
        btnSave1 = (Button)findViewById(R.id.btnSave1);
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoBack = new Intent(ThirdActivity_2.this,ThirdActivity.class);
                startActivity(intentGoBack);
                finish();
            }
        });

        Intent inComingIntent1 =getIntent();
        String date1 = inComingIntent1.getStringExtra("date");
        title1 = (TextView)findViewById(R.id.titleText1);
        title1.setText(date1);

        // 버튼이 눌리면, 갤러리에서 사진 받아오거나 카메라 촬영
        btnCam1_1 = (Button)findViewById(R.id.btnCam1_1);
        btnCam1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnCam1_2 = (Button)findViewById(R.id.btnCam1_2);
        btnCam1_3 = (Button)findViewById(R.id.btnCam1_3);
    }
}
