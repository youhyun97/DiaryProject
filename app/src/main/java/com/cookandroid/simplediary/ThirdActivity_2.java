package com.cookandroid.simplediary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity_2 extends AppCompatActivity {
    Button btnSave1;
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
    }
}
