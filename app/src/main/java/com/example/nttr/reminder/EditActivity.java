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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

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
//    @BindView(R.id.notification_switch)
//    Switch notificationSwitch;
//    @BindView(R.id.notification_linearlayout)
//    LinearLayout notificationLinearlayout;
    @BindView(R.id.date_time_label)
    TextView dateTimeLabel;
    @BindView(R.id.date_time_button)
    Button dateTimeButton;
    @BindView(R.id.date_time_linearlayout)
    LinearLayout dateTimeLinearlayout;
    @BindView(R.id.notification_sound_label)
    TextView notificationSoundLabel;
    @BindView(R.id.notification_sound_text)
    TextView notificationSoundText;
    @BindView(R.id.notification_sound_button)
    Button notificationSoundButton;
    @BindView(R.id.notification_sound_linearlayout)
    LinearLayout notificationSoundLinearlayout;
    @BindView(R.id.vibration_label)
    TextView vibrationLabel;
    @BindView(R.id.vibration_text)
    TextView vibrationText;
    @BindView(R.id.vibration_button)
    Button vibrationButton;
    @BindView(R.id.vibration_linearlayout)
    LinearLayout vibrationLinearlayout;
    @BindView(R.id.repetition_label)
    TextView repetitionLabel;
    @BindView(R.id.repetition_text)
    TextView repetitionText;
    @BindView(R.id.repetition_button)
    Button repetitionButton;
    @BindView(R.id.repetition_linearlayout)
    LinearLayout repetitionLinearlayout;
    @BindView(R.id.content_label)
    TextView contentLabel;
    @BindView(R.id.content_text)
    EditText contentText;

    PreferenceUtil pref;

    Calendar alarmCalendar = Calendar.getInstance();

    public static final String ALARM_TIME = "alarm_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);

        pref = new PreferenceUtil(this);
        setupViews();
        setListeners();

//        if(!notificationSwitch.isChecked()) {
//            dateTimeLabel.setVisibility(View.GONE);
//            dateTimeButton.setVisibility(View.GONE);
//            dateTimeLinearlayout.setVisibility(View.GONE);
//
//            notificationSoundLabel.setVisibility(View.GONE);
//            notificationSoundText.setVisibility(View.GONE);
//            notificationSoundButton.setVisibility(View.GONE);
//            notificationSoundLinearlayout.setVisibility(View.GONE);
//
//            vibrationLabel.setVisibility(View.GONE);
//            vibrationText.setVisibility(View.GONE);
//            vibrationButton.setVisibility(View.GONE);
//            vibrationLinearlayout.setVisibility(View.GONE);
//
//            repetitionLabel.setVisibility(View.GONE);
//            repetitionText.setVisibility(View.GONE);
//            repetitionButton.setVisibility(View.GONE);
//            repetitionLinearlayout.setVisibility(View.GONE);
//        }
//
//
//        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked) {
//                    dateTimeLabel.setVisibility(View.VISIBLE);
//                    dateTimeButton.setVisibility(View.VISIBLE);
//                    dateTimeLinearlayout.setVisibility(View.VISIBLE);
//
//                    notificationSoundLabel.setVisibility(View.VISIBLE);
//                    notificationSoundText.setVisibility(View.VISIBLE);
//                    notificationSoundButton.setVisibility(View.VISIBLE);
//                    notificationSoundLinearlayout.setVisibility(View.VISIBLE);
//
//                    vibrationLabel.setVisibility(View.VISIBLE);
//                    vibrationText.setVisibility(View.VISIBLE);
//                    vibrationButton.setVisibility(View.VISIBLE);
//                    vibrationLinearlayout.setVisibility(View.VISIBLE);
//
//                    repetitionLabel.setVisibility(View.VISIBLE);
//                    repetitionText.setVisibility(View.VISIBLE);
//                    repetitionButton.setVisibility(View.VISIBLE);
//                    repetitionLinearlayout.setVisibility(View.VISIBLE);
//                }
//                else{
//                    dateTimeLabel.setVisibility(View.GONE);
//                    dateTimeButton.setVisibility(View.GONE);
//                    dateTimeLinearlayout.setVisibility(View.GONE);
//
//                    notificationSoundLabel.setVisibility(View.GONE);
//                    notificationSoundText.setVisibility(View.GONE);
//                    notificationSoundButton.setVisibility(View.GONE);
//                    notificationSoundLinearlayout.setVisibility(View.GONE);
//
//                    vibrationLabel.setVisibility(View.GONE);
//                    vibrationText.setVisibility(View.GONE);
//                    vibrationButton.setVisibility(View.GONE);
//                    vibrationLinearlayout.setVisibility(View.GONE);
//
//                    repetitionLabel.setVisibility(View.GONE);
//                    repetitionText.setVisibility(View.GONE);
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

                break;
            default:
                break;
        }
        return true;
    }

    private void setupViews() {

        long alarmTime = pref.getLong(ALARM_TIME);
        if (alarmTime != 0) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(alarmTime);
            dateTimeButton.setText(df.format(date));
//            notificationSwitch.setChecked(true);
        }
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
                                alarmCalendar.set(Calendar.YEAR, y);
                                alarmCalendar.set(Calendar.MONTH, m);
                                alarmCalendar.set(Calendar.DAY_OF_MONTH, d);
                                alarmCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                alarmCalendar.set(Calendar.MINUTE, minute);
                                alarmCalendar.set(Calendar.SECOND, 0);
                                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                //Realmにdf.format(alarmCalendar.getTime()を保存

                                dateTimeButton.setText(df.format(alarmCalendar.getTime()));

                                register(alarmCalendar.getTimeInMillis());///////追加したところ

                            }
                        }, hour, minute, true);
                        timePickerDialog.show();
                    }
                }, year, monthOfYear, dayOfMonth);
                datePickerDialog.show();
            }
        });

//        dateTimeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if (isChecked) {
//                    register(alarmCalendar.getTimeInMillis());
//                } else {
//                    unregister();
//                }
//            }
//        });
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
        // 保存
        pref.setLong(ALARM_TIME, alarmTimeMillis);
    }

    // 解除
    private void unregister() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(getPendingIntent());
        pref.delete(ALARM_TIME);
    }

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.setClass(this, AlarmReceiver.class);
        // 複数のアラームを登録する場合はPendingIntent.getBroadcastの第二引数を変更する
        // 第二引数が同じで第四引数にFLAG_CANCEL_CURRENTがセットされている場合、2回以上呼び出されたときは
        // あとからのものが上書きされる
        return PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
    }

//    @Override
//    public void onBackPressed() {
//        finish();
//    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        pref = new PreferenceUtil(this);
//        setupViews();
//        setListeners();
//
//        if(!notificationSwitch.isChecked()) {
//            dateTimeLabel.setVisibility(View.GONE);
//            dateTimeButton.setVisibility(View.GONE);
//            dateTimeLinearlayout.setVisibility(View.GONE);
//
//            notificationSoundLabel.setVisibility(View.GONE);
//            notificationSoundText.setVisibility(View.GONE);
//            notificationSoundButton.setVisibility(View.GONE);
//            notificationSoundLinearlayout.setVisibility(View.GONE);
//
//            vibrationLabel.setVisibility(View.GONE);
//            vibrationText.setVisibility(View.GONE);
//            vibrationButton.setVisibility(View.GONE);
//            vibrationLinearlayout.setVisibility(View.GONE);
//
//            repetitionLabel.setVisibility(View.GONE);
//            repetitionText.setVisibility(View.GONE);
//            repetitionButton.setVisibility(View.GONE);
//            repetitionLinearlayout.setVisibility(View.GONE);
//        }
//
//
//        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked) {
//                    dateTimeLabel.setVisibility(View.VISIBLE);
//                    dateTimeButton.setVisibility(View.VISIBLE);
//                    dateTimeLinearlayout.setVisibility(View.VISIBLE);
//
//                    notificationSoundLabel.setVisibility(View.VISIBLE);
//                    notificationSoundText.setVisibility(View.VISIBLE);
//                    notificationSoundButton.setVisibility(View.VISIBLE);
//                    notificationSoundLinearlayout.setVisibility(View.VISIBLE);
//
//                    vibrationLabel.setVisibility(View.VISIBLE);
//                    vibrationText.setVisibility(View.VISIBLE);
//                    vibrationButton.setVisibility(View.VISIBLE);
//                    vibrationLinearlayout.setVisibility(View.VISIBLE);
//
//                    repetitionLabel.setVisibility(View.VISIBLE);
//                    repetitionText.setVisibility(View.VISIBLE);
//                    repetitionButton.setVisibility(View.VISIBLE);
//                    repetitionLinearlayout.setVisibility(View.VISIBLE);
//                }
//                else{
//                    dateTimeLabel.setVisibility(View.GONE);
//                    dateTimeButton.setVisibility(View.GONE);
//                    dateTimeLinearlayout.setVisibility(View.GONE);
//
//                    notificationSoundLabel.setVisibility(View.GONE);
//                    notificationSoundText.setVisibility(View.GONE);
//                    notificationSoundButton.setVisibility(View.GONE);
//                    notificationSoundLinearlayout.setVisibility(View.GONE);
//
//                    vibrationLabel.setVisibility(View.GONE);
//                    vibrationText.setVisibility(View.GONE);
//                    vibrationButton.setVisibility(View.GONE);
//                    vibrationLinearlayout.setVisibility(View.GONE);
//
//                    repetitionLabel.setVisibility(View.GONE);
//                    repetitionText.setVisibility(View.GONE);
//                    repetitionButton.setVisibility(View.GONE);
//                    repetitionLinearlayout.setVisibility(View.GONE);
//                }
//            }
//        });
//    }
}
