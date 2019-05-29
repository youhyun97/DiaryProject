package com.cookandroid.simplediary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText idText2 = (EditText) findViewById(R.id.idText_2);
        EditText pwText2 = (EditText) findViewById(R.id.pwText_2);
        EditText ageText2 = (EditText) findViewById(R.id.ageText2);
        EditText nameText2 = (EditText) findViewById(R.id.nameText_2);
        TextView idcheck2 = (TextView) findViewById(R.id.idcheck_2);
        Button idchecckbtn2 = (Button) findViewById(R.id.idcheckbtn_2);
        Button registerBtn2 = (Button) findViewById(R.id.registerButton_2);

    }
}
