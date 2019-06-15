package com.cookandroid.diary_project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText idText_2, passwordText_2, id_dialog;
    Button loginButton2, findpw_dialog;
    TextView findpw_2, registerText_2, pw_dialog;
    View dialogView;
    SQLiteDatabase sqlDB;
    registerActivity.myDBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myHelper = new registerActivity.myDBHelper(this);
        dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
        idText_2 = (EditText) findViewById(R.id.idText_2);
        passwordText_2 = (EditText) findViewById(R.id.passwordText_2);
        loginButton2 = (Button) findViewById(R.id.loginButton_2);
        findpw_2 = (TextView) findViewById(R.id.findpw_2);
        registerText_2 = (TextView) findViewById(R.id.registerText_2);

        // dialog id
        id_dialog = (EditText) dialogView.findViewById(R.id.id_dialog);
        pw_dialog = (TextView) dialogView.findViewById(R.id.pw_dialog);
        findpw_dialog = (Button) dialogView.findViewById(R.id.findpw_dialog);
//        registerActivity.myDBHelper myhelper = new registerActivity.myDBHelper(this);


        // 비밀번호 찾기
        findpw_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("비밀번호 찾기");
                dlg.setIcon(R.drawable.ic_error_outline_black_24dp);
                dlg.setView(dialogView);
                // Cursor 통해 가져온 데이터를 받아오기
                Cursor cursor;
                sqlDB=myHelper.getReadableDatabase();
                cursor= sqlDB.rawQuery("select * from Userinfo;",null);
                while(cursor.moveToNext()){
                    // id가 일치하는 것의 비밀번호 불러오기
                    if(cursor.getString(0).equals(id_dialog.getText().toString())){
                        pw_dialog.setText(cursor.getString(1));
                    }
                }
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 확인버튼 누르면 아이디,비밀번호 로그인 폼에 자동으로 입력되게 설정
                        idText_2.setText(id_dialog.getText().toString());
                        passwordText_2.setText(pw_dialog.getText().toString());
                    }
                });

                dlg.show();
            }
        });

        // 회원가입 누르기
        registerText_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(MainActivity.this, registerActivity.class);
                startActivity(registerintent);
                finish();
            }
        });

        // 로그인
        loginButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cursor 통해 가져온 데이터를 받아오기
                Cursor cursor;
                sqlDB=myHelper.getReadableDatabase();
                cursor= sqlDB.rawQuery("select * from Userinfo where id='"+idText_2.getText().toString()+"';",null);
                // 아이디 비밀번호 일치하면
                while(cursor.moveToNext()){
                    if(cursor.getString(1).equals(passwordText_2.getText().toString())){
                        Intent mIntent = new Intent(getApplicationContext(),SecondActivity.class);
                        mIntent.putExtra("UserID", idText_2.getText().toString()); // id값과 함께 넘겨줌
                        startActivity(mIntent);
                    }else{
                        Toast.makeText(getApplicationContext(),"일치하지 않습니다.",Toast.LENGTH_SHORT);
                    }
                }
                cursor.close();
                sqlDB.close();
            }
        });
    }
}
