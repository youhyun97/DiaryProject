package com.cookandroid.simplediary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {
    ImageButton btn1_1, btn1_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        btn1_1 = (ImageButton)findViewById(R.id.btn1_1);
        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1_1 = new Intent(SecondActivity.this, FourthActivity.class);
                startActivity(intent1_1);
                finish();
            }
        });
        btn1_2 = (ImageButton)findViewById(R.id.btn1_2);
        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1_2 = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent1_2);
                finish();
            }
        });
    }
}
