package com.cookandroid.simplediary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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
        final String[] listName1={"todo","diary","dietdiary"};
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

//        todo1 = (TextView)findViewById(R.id.textView1_1);
//        diary1 = (TextView)findViewById(R.id.textView1_2);
//        meal1 = (TextView)findViewById(R.id.textView1_3);
//
        calendar1 = (CalendarView)findViewById(R.id.calendarView1);
        calendar1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView1, int year, int month, int dayOfMonth) {
                date1 = year+"/"+(month+1)+"/"+dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: mmddyy:"+date1);
            }
        });

        ListView list1 = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listName1);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listName1[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
