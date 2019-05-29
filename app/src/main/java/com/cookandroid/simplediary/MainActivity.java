package com.cookandroid.simplediary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id 연결
        EditText idText_2 = (EditText) findViewById(R.id.idText_2);
        EditText passwordText_2 = (EditText) findViewById(R.id.passwordText_2);
        Button loginButon2 = (Button) findViewById(R.id.loginButton_2);
        TextView findpw_2 = (TextView) findViewById(R.id.findpw_2);
        TextView registerButton_2=(TextView) findViewById(R.id.registerButton_2);

        // 회원가입 누르기
        registerButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(MainActivity.this, registerActivity.class);
                startActivity(registerintent);
                finish();
            }
        });

        // 로그인
        
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
        Intent menuIntent1 = new Intent(MainActivity.this, Fifth5Activity.class);
        startActivity(menuIntent1);
        finish();

        return true;
    }
}
