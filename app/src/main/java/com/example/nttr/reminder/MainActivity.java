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
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RealmのDBにリストデータがあれば表示
        //DBにはタイトル、メモ、アラーム指定時刻などの情報がある
        final List<String> reminderList = new ArrayList<String>(){
            {
                add("タイトル");
                add("ああああああああああああああああああ");
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    //新しいリマインダーリストとその情報を編集画面で作成
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // ボタンをタップした際の処理を記述
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

