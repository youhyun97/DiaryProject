package com.cookandroid.simplediary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id 연결
        final EditText idText_2 = (EditText) findViewById(R.id.idText_2);
        final EditText passwordText_2 = (EditText) findViewById(R.id.passwordText_2);
        Button loginButon2 = (Button) findViewById(R.id.loginButton_2);
        final TextView findpw_2 = (TextView) findViewById(R.id.findpw_2);
        TextView registerButton_2=(TextView) findViewById(R.id.registerButton_2);

        dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
        final EditText id_dialog = (EditText) dialogView.findViewById(R.id.id_dialog);
        final TextView pw_dialog = (TextView) dialogView.findViewById(R.id.pw_dialog);
        Button findpw_dialog = (Button) dialogView.findViewById(R.id.findpw_dialog);

        // 비밀번호 찾기
        findpw_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("비밀번호 찾기");
                dlg.setIcon(R.drawable.ic_error_outline_black_24dp);
                dlg.setView(dialogView);
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
        registerButton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(MainActivity.this, registerActivity.class);
                startActivity(registerintent);
                finish();
            }
        });

        // 로그인
        loginButon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondintent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondintent);
                finish();
            }
        });
    }

}
