package com.cookandroid.simplediary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Fifth5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);

        TextView name2 = (TextView) findViewById(R.id.name_2);
        TextView id2 = (TextView) findViewById(R.id.id_2);
        TextView age2 = (TextView) findViewById(R.id.age_2);

    }
}
