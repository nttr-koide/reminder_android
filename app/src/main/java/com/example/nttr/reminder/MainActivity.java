/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
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

import com.example.nttr.reminder.entity.ReminderListItem;
import com.example.nttr.reminder.entity.ReminderObject;
import com.example.nttr.reminder.model.ReminderObjectDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //テストコード start
        //データ登録
//        ReminderObject dataObj = new ReminderObject();
//        dataObj.setTitleName("111");
//        ReminderObjectDao.add(dataObj);
        //テストコード end

        final List<ReminderListItem> reminderList = new ArrayList<>();
        List<ReminderObject> records = ReminderObjectDao.getRecords();

        for (ReminderObject obj : records) {
            if(obj.getTitleName().equals("")) {
                ReminderObjectDao.remove(obj.getReminderId());
//                ReminderObjectDao.getRecord(obj.getReminderId());
            }
            else{
                reminderList.add(new ReminderListItem(obj));
            }

        }

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.row_item, reminderList);
        ListView listView = (ListView) findViewById(R.id.listView);
        if(reminderList != null) {
//            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.row_item, reminderList);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (view.getId()) {
                        case R.id.edit:
//                            Toast.makeText(MainActivity.this, reminderList.get(position) + "の編集ボタンが押されました", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, EditActivity.class);
                            //put
                            intent.putExtra("REMINDERID", reminderList.get(position).getObject().getReminderId());
//                            intent.putExtra("REMINDERID", reminderList.get(position).getObject());
                            startActivity(intent);
                            break;
                        case R.id.delete:
//                            Toast.makeText(MainActivity.this, reminderList.get(position) + "の削除ボタンが押されました", Toast.LENGTH_SHORT).show();
                            ReminderObjectDao.remove(reminderList.get(position).getObject().getReminderId());

                            //
//                            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//                            intent = new Intent(getApplicationContext(), AlarmReceiver.class);
//                            intent.setType(String.valueOf(reminderList.get(position).getObject().getReminderId()));    // このsetTypeが重要
//
//                            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, ReminderObjectDao.getRecord(reminderList.get(position).getObject().getReminderId()).getReminderId(), intent, PendingIntent.FLAG_ONE_SHOT);
//
//                            pendingIntent.cancel();
//                            alarmManager.cancel(pendingIntent);
                            //

                            startActivity(new Intent(MainActivity.this, MainActivity.class));
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


//    新しいリマインダーリストとを追加しようと編集画面へ遷移
//    追加しない可能性もあるからadd(obj)はしない getNextId()でIdを仮で用意するだけ
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // ボタンをタップした際の処理を記述
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                ReminderObject dataObj = new ReminderObject();
                //レコード追加
                ReminderObjectDao.update(dataObj);
//                ReminderObjectDao.add(dataObj);
                intent.putExtra("REMINDERID", dataObj.getReminderId());//dataObjのReminderId初期値0を送る
//                intent.putExtra("REMINDERID", ReminderObjectDao.getNextId());
                startActivity(intent);
                break;
        }
        return true;
    }
}

