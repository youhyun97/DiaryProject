package com.cookandroid.diary_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu); // 메뉴 xml파일 등록
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent menuIntent1 = new Intent(SecondActivity.this, Fifth5Activity.class);
        startActivity(menuIntent1);
        finish();

        return true;
    }
}
