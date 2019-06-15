package com.cookandroid.diary_project1;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity {
    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    String tag = "SQLite";

    EditText ridText2, rpwText2, rageText2, rnameText2;
    TextView ridcheck2;
    Button ridcheckbtn2, registerButton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        myHelper = new myDBHelper(this); // 객체 생성
        ridText2 = (EditText) findViewById(R.id.ridText_2);
        rpwText2 = (EditText) findViewById(R.id.rpwText_2);
        rageText2 = (EditText) findViewById(R.id.rageText2);
        rnameText2 = (EditText) findViewById(R.id.rnameText_2);
        ridcheck2 = (TextView) findViewById(R.id.ridcheck_2);
        ridcheckbtn2 = (Button) findViewById(R.id.ridcheckbtn_2);
        registerButton_2 = (Button) findViewById(R.id.registerButton_2);



        sqlDB = myHelper.getWritableDatabase();
        myHelper.onUpgrade(sqlDB,1,2); // 가져온 db를 내꺼에 맞게 upgrade
        sqlDB.close(); // sql 명령이 끝나면 항상 close
        Log.d(tag,"초기화 완료");
        Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT);

        // 입력 버튼 리스너
        registerButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getWritableDatabase();
                try {
                    sqlDB.execSQL("insert into Userinfo(id,pw,name,age) values ('"
                            + ridText2.getText().toString() + "','"
                            + rpwText2.getText().toString() + "','"
                            + rnameText2.getText().toString()+ "','"
                            + rageText2.getText().toString()+ "');");
                    Toast.makeText(getApplicationContext(),"회원가입 완료",Toast.LENGTH_SHORT).show();
                    Log.d(tag,"입력 완료");
                }catch (Exception e){
                    Log.d(tag,"데이터 추가할 때 예외: "+e.getMessage()+"\n");
                    e.printStackTrace();
                }finally {
                    sqlDB.close();
                }
                Intent registerintent = new Intent(registerActivity.this, MainActivity.class);
                startActivity(registerintent);
                finish();
            }
        });

        // 아이디 중복체크
        ridcheckbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cursor 통해 가져온 데이터를 받아오기
                Cursor cursor;
                String check="id 사용 가능합니다.";
                sqlDB=myHelper.getReadableDatabase();
                cursor= sqlDB.rawQuery("select * from Userinfo;",null);
                // 다음 데이터가 있을 때까지 반복
                while(cursor.moveToNext()){
                    if(ridText2.getText().toString().equals(cursor.getString(0))){
                        check="아이디 사용 불가입니다.";
                    }
                }
                ridcheck2.setText(check);
                cursor.close();
                sqlDB.close();
            }
        });

    }
    // openHelper를 상속받는 myDBHelper 클래스 작성
    public static class myDBHelper extends SQLiteOpenHelper {
        // 생성자
        // 실행하면 "diaryDB"를 생성
        public myDBHelper(Context context) {
            super(context, "diaryDB", null, 1);
        }

        // 매개변수를 db로 받음으로써 테이블 생성하기
        // groupTBL은 테이블이름, groupDB는 데이터베이스 이름
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE  Userinfo ( id CHAR(30) PRIMARY KEY, pw char(30), name char(30), " +
                    "age integer, year INTEGER, month INTEGER, dayOfMonth INTEGER, todo1 char(50), todo2 char(50),todo3 char(50), todo4 char(50), todo5 char(50)," +
                    "diary text, img1 blob, img2 blob, img3 blob);");
        }

        // 앱을 실행할 때마다 기존에 있던 groupTBL을 삭제 후
        // 테이블 생성(onCreate)
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Userinfo");
            onCreate(db);
        }
    }
}
