package com.example.nttr.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ArrayList<String> reminderList = intent.getStringArrayListExtra("リマインダーリスト");

        ListView listView = (ListView) findViewById(R.id.listView);

        //データの追加
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.my_list_item);

        for (String str : reminderList) {
            adapter.add(str);
        }
        listView.setAdapter(adapter);

        Button editButton = (Button) findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                //put
                startActivity(intent);
            }
        });
    }
}