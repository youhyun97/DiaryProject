package com.cookandroid.diary_project1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class FourthActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        TabHost tabHost = getTabHost();

        TabSpec tabSpecToDo = tabHost.newTabSpec("ToDo").setIndicator("ToDo");
        tabSpecToDo.setContent(R.id.ToDo);
        tabHost.addTab(tabSpecToDo);

        TabSpec tabSpecDiary = tabHost.newTabSpec("Diary").setIndicator("Diary");
        tabSpecDiary.setContent(R.id.Diary);
        tabHost.addTab(tabSpecDiary);

        TabSpec tabSpecfood = tabHost.newTabSpec("food").setIndicator("food");
        tabSpecfood.setContent(R.id.food);
        tabHost.addTab(tabSpecfood);

        tabHost.setCurrentTab(0);

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
        Intent menuIntent1 = new Intent(FourthActivity.this, Fifth5Activity.class);
        startActivity(menuIntent1);
        finish();

        return true;
    }
}