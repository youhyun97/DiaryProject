package com.cookandroid.simplediary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button btnChange;
    TextView todo1,diary1, meal1;
    private CalendarView calendar1;
    private static final String TAG = "ThirdActiviy";
    String date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.third);
        btnChange = (Button)findViewById(R.id.btnChange1);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDate = new Intent(ThirdActivity.this, ThirdActivity_2.class);
                intentDate.putExtra("date",date1);
                startActivity(intentDate);
                finish();
            }
        });

        todo1 = (TextView)findViewById(R.id.textView1_1);
        diary1 = (TextView)findViewById(R.id.textView1_2);
        meal1 = (TextView)findViewById(R.id.textView1_3);

        calendar1 = (CalendarView)findViewById(R.id.calendarView1);
        calendar1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView1, int year, int month, int dayOfMonth) {
                date1 = year+"/"+(month+1)+"/"+dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: mmddyy:"+date1);

                todo1.setText(date1);
                diary1.setText(date1);
                meal1.setText(date1);

            }
        });
    }
}
