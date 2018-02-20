/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.nttr.reminder.entity.ReminderListItem;
import com.example.nttr.reminder.entity.ReminderObject;
import com.example.nttr.reminder.model.ReminderObjectDao;
import com.example.nttr.reminder.util.PreferenceUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditActivity extends AppCompatActivity {

    @BindView(R.id.title_label)
    TextView titleLabel;
    @BindView(R.id.title_text)
    EditText titleText;
    @BindView(R.id.notification_switch)
    Switch notificationSwitch;
    @BindView(R.id.notification_linearlayout)
    LinearLayout notificationLinearlayout;
    @BindView(R.id.date_time_label)
    TextView dateTimeLabel;
    @BindView(R.id.date_time_button)
    Button dateTimeButton;
    @BindView(R.id.date_time_linearlayout)
    LinearLayout dateTimeLinearlayout;
    @BindView(R.id.notification_sound_label)
    TextView notificationSoundLabel;
    @BindView(R.id.notification_sound_button)
    Button notificationSoundButton;
    @BindView(R.id.notification_sound_linearlayout)
    LinearLayout notificationSoundLinearlayout;
    @BindView(R.id.vibration_label)
    TextView vibrationLabel;
    @BindView(R.id.vibration_button)
    Button vibrationButton;
    @BindView(R.id.vibration_linearlayout)
    LinearLayout vibrationLinearlayout;
    @BindView(R.id.repetition_label)
    TextView repetitionLabel;
    @BindView(R.id.repetition_button)
    Button repetitionButton;
    @BindView(R.id.repetition_linearlayout)
    LinearLayout repetitionLinearlayout;
    @BindView(R.id.content_label)
    TextView contentLabel;
    @BindView(R.id.content_text)
    EditText contentText;
    @BindView(R.id.content_linearlayout)
    LinearLayout contentLinearlayout;


    PreferenceUtil pref;

    Calendar alarmCalendar;

    int reminderId;

    public static final String ALARM_TIME = "alarm_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

//        pref = new PreferenceUtil(this);

        Intent intent = getIntent();
        reminderId = intent.getIntExtra("REMINDERID", 0);

        setupViews();
        setListeners();

//        contentLinearlayout.setVisibility(View.GONE);

        notificationLinearlayout.setVisibility(View.GONE);

//        dateTimeLinearlayout.setVisibility(View.GONE);

        notificationSoundLinearlayout.setVisibility(View.GONE);

        vibrationLinearlayout.setVisibility(View.GONE);

        repetitionLinearlayout.setVisibility(View.GONE);

//        if(!notificationSwitch.isChecked()) {
//            dateTimeLabel.setVisibility(View.GONE);
//            dateTimeButton.setVisibility(View.GONE);
//            dateTimeLinearlayout.setVisibility(View.GONE);
//
//            notificationSoundLabel.setVisibility(View.GONE);
//            notificationSoundButton.setVisibility(View.GONE);
//            notificationSoundLinearlayout.setVisibility(View.GONE);
//
//            vibrationLabel.setVisibility(View.GONE);
//            vibrationButton.setVisibility(View.GONE);
//            vibrationLinearlayout.setVisibility(View.GONE);
//
//            repetitionLabel.setVisibility(View.GONE);
//            repetitionButton.setVisibility(View.GONE);
//            repetitionLinearlayout.setVisibility(View.GONE);
//        }


//        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked) {
//                    dateTimeLabel.setVisibility(View.VISIBLE);
//                    dateTimeButton.setVisibility(View.VISIBLE);
//                    dateTimeLinearlayout.setVisibility(View.VISIBLE);
//
//                    notificationSoundLabel.setVisibility(View.VISIBLE);
//                    notificationSoundButton.setVisibility(View.VISIBLE);
//                    notificationSoundLinearlayout.setVisibility(View.VISIBLE);
//
//                    vibrationLabel.setVisibility(View.VISIBLE);
//                    vibrationButton.setVisibility(View.VISIBLE);
//                    vibrationLinearlayout.setVisibility(View.VISIBLE);
//
//                    repetitionLabel.setVisibility(View.VISIBLE);
//                    repetitionButton.setVisibility(View.VISIBLE);
//                    repetitionLinearlayout.setVisibility(View.VISIBLE);
//                }
//                else{
//                    dateTimeLabel.setVisibility(View.GONE);
//                    dateTimeButton.setVisibility(View.GONE);
//                    dateTimeLinearlayout.setVisibility(View.GONE);
//
//                    notificationSoundLabel.setVisibility(View.GONE);
//                    notificationSoundButton.setVisibility(View.GONE);
//                    notificationSoundLinearlayout.setVisibility(View.GONE);
//
//                    vibrationLabel.setVisibility(View.GONE);
//                    vibrationButton.setVisibility(View.GONE);
//                    vibrationLinearlayout.setVisibility(View.GONE);
//
//                    repetitionLabel.setVisibility(View.GONE);
//                    repetitionButton.setVisibility(View.GONE);
//                    repetitionLinearlayout.setVisibility(View.GONE);
//                }
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                //タイトルは入力必須
                if(String.valueOf(titleText.getText()).equals("")){
                    Toast.makeText(EditActivity.this, "タイトルを入力してください", Toast.LENGTH_SHORT).show();
                    break;
                }

//                if(String.valueOf(contentText.getText()).equals("")){
//                    Toast.makeText(EditActivity.this, "メモを入力してください", Toast.LENGTH_SHORT).show();
//                    break;
//                }

                if(alarmCalendar == null) {
                    Toast.makeText(EditActivity.this, "日付を指定してください", Toast.LENGTH_SHORT).show();
                    break;
                }

//                if(!ReminderObjectDao.getRecord(reminderId).getTitleName().equals("")){
//
//                }

                if(!ReminderObjectDao.getRecord(reminderId).getDateAndTime().equals("")){
//                    if(alarmCalendar == null){
//                        //セットされている時刻を再度セット
////                        register(Long.parseLong(ReminderObjectDao.getRecord(reminderId).getDateAndTime()));
////                        Toast.makeText(EditActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
                        register(alarmCalendar.getTimeInMillis());//alarmCalendar.getTimeInMillis()は、alarmCalendarにセットした時刻を取得
//                    }


//                    if(alarmCalendar != null){
//                        register(alarmCalendar.getTimeInMillis());
//                    }
//                    else{
//                        saveReminderData(reminderId);
//                    }
                }
                else{
                    if(reminderId == 0 && alarmCalendar != null){ //Id=0に対応するオブジェクトはないため上のifを抜けてしまう（MainActivityではupDateのみ行い、一時的にId0を送っているため）
                        register(alarmCalendar.getTimeInMillis());//時刻は入力されていないと
                    }
                    else{
                        saveReminderData(reminderId);
                    }
                }
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    private void setupViews() {
//        long alarmTime = pref.getLong(ALARM_TIME);
//        long alarmTime = intent.get.getLong(ALARM_TIME);
//        if (alarmTime != 0) {
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date(alarmTime);

        if(!ReminderObjectDao.getRecord(reminderId).getTitleName().equals("")) {
            titleText.setText(ReminderObjectDao.getRecord(reminderId).getTitleName());
        }
        if(!ReminderObjectDao.getRecord(reminderId).getContent().equals("")) {
            contentText.setText(ReminderObjectDao.getRecord(reminderId).getContent());
        }
        if(!ReminderObjectDao.getRecord(reminderId).getDateAndTime().equals("")) {
            dateTimeButton.setText(ReminderObjectDao.getRecord(reminderId).getDateAndTime());
            notificationSwitch.setChecked(true);
        }
//        }
    }

    private void setListeners() {
        dateTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int monthOfYear = calendar.get(Calendar.MONTH);
                final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                final int hour = calendar.get(Calendar.HOUR_OF_DAY);
                final int minute = calendar.get(Calendar.MINUTE);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, final int y, final int m, final int d) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(EditActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                alarmCalendar = Calendar.getInstance();
                                alarmCalendar.set(Calendar.YEAR, y);
                                alarmCalendar.set(Calendar.MONTH, m);
                                alarmCalendar.set(Calendar.DAY_OF_MONTH, d);
                                alarmCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                alarmCalendar.set(Calendar.MINUTE, minute);
                                alarmCalendar.set(Calendar.SECOND, 0);
                                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                dateTimeButton.setText(df.format(alarmCalendar.getTime()));
                                //Realmにdf.format(alarmCalendar.getTime()を保存
                                ReminderObjectDao.getRecord(reminderId).setDateAndTime(String.valueOf(dateTimeButton.getText()));
                            }
                        }, hour, minute, true);
                        timePickerDialog.show();
                    }
                }, year, monthOfYear, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }

    // 登録
    private void register(long alarmTimeMillis) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent = getPendingIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(alarmTimeMillis, null), pendingIntent);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
        }
        // DBに保存
            saveReminderData(reminderId);
    }

//    // 解除
//    private void unregister() {
//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        alarmManager.cancel(getPendingIntent());
//        pref.delete(ALARM_TIME);
//    }

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent(this, AlarmReceiver.class);
//        intent.setClass(this, AlarmReceiver.class);
        intent.setType(String.valueOf(ReminderObjectDao.getRecord(reminderId).getReminderId()));
        // 複数のアラームを登録する場合はPendingIntent.getBroadcastの第二引数を変更する
        // 第二引数が同じで第四引数にFLAG_CANCEL_CURRENTがセットされている場合、2回以上呼び出されたときは
        // あとからのものが上書きされる
        return PendingIntent.getBroadcast(this, ReminderObjectDao.getRecord(reminderId).getReminderId(), intent, PendingIntent.FLAG_ONE_SHOT);
    }

    private void saveReminderData(int reminderId) {
        //データ登録
        SpannableStringBuilder sb = (SpannableStringBuilder)titleText.getText();
        String strTitleText = sb.toString();

        SpannableStringBuilder sb1 = (SpannableStringBuilder)contentText.getText();
        String strContentText = sb1.toString();

        String strDateTimeButtonText;

        if(!dateTimeButton.getText().equals("なし >")){
            strDateTimeButtonText = String.valueOf(dateTimeButton.getText());
        }
        else{
            strDateTimeButtonText = "";
        }

        if(reminderId == 0){
            ReminderObject dataObj = new ReminderObject();
            dataObj.setTitleName(strTitleText);
            dataObj.setContent(strContentText);
            dataObj.setDateAndTime(strDateTimeButtonText);
            dataObj.setReminderId(reminderId);///??
            ReminderObjectDao.add(dataObj);
        }
        else{
            ReminderObject dataObj = new ReminderObject();
            dataObj.setTitleName(strTitleText);
            dataObj.setContent(strContentText);
            dataObj.setDateAndTime(strDateTimeButtonText);
            dataObj.setReminderId(reminderId);///??
            ReminderObjectDao.update(dataObj);
//            ReminderObjectDao.getRecord(reminderId).setTitleName(strTitleText);
//            ReminderObjectDao.getRecord(reminderId).setDateAndTime(strDateTimeButtonText);
        }
//        dataObj.setNotification("");
//        dataObj.setNotificationSound("");
//        dataObj.setRepeatInterval("");
//        dataObj.setVibration("");

    }

//    @Override
//    public void onBackPressed() {
////        finish();
//    }

}
