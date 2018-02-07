/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String[] countries = {
            "America",
            "Japan",
            "China",
            "Korea",
            "British",
            "German"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();//
//        ArrayList<String> reminderList = intent.getStringArrayListExtra("リマインダーリスト");//
        final List<String> reminderList = new ArrayList<String>(){
            {
                add("AA");
                add("BB");
                add("CC");
            }
        };

        ListView listView = (ListView) findViewById(R.id.listView);
        if(reminderList != null) {
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.row_item, reminderList);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (view.getId()) {
                        case R.id.edit:
                            Toast.makeText(MainActivity.this, reminderList.get(position) + "の編集ボタンが押されました", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, EditActivity.class);
                            //put
                            startActivity(intent);
                            break;
                        case R.id.delete:
                            Toast.makeText(MainActivity.this, reminderList.get(position) + "の削除ボタンが押されました", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
        }

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
//    @Override
//    public void onBackPressed() {
//    }
}

