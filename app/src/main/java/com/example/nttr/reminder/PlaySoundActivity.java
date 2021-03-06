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
import android.view.WindowManager;
import android.widget.Button;

import com.example.nttr.reminder.model.ReminderObjectDao;
import com.example.nttr.reminder.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaySoundActivity extends AppCompatActivity {

    @BindView(R.id.stop)
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_play_sound);
        ButterKnife.bind(this);

        startService(new Intent(this, PlaySoundService.class));

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(PlaySoundActivity.this, PlaySoundService.class));
//                PreferenceUtil pref = new PreferenceUtil(PlaySoundActivity.this);
//                pref.delete(EditActivity.ALARM_TIME);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(PlaySoundActivity.this, PlaySoundService.class));
//        PreferenceUtil pref = new PreferenceUtil(PlaySoundActivity.this);
//        pref.delete(EditActivity.ALARM_TIME);
        finish();
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        ReminderObjectDao.remove(reminderList.get(position).getObject().getReminderId());
//    }
}
