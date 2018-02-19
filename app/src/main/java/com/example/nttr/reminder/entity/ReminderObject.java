/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder.entity;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by seiji on 2018/02/18.
 */

public class ReminderObject extends RealmObject {
    @PrimaryKey
    private int reminderId = 0;
    @NonNull
    private String titleName = null;
    private String notification = null;
    private String dateAndTime = null;
    private String notificationSound = null;
    private String vibration = null;
    private String repeatInterval = null;
    private String content = null;

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public void setTitleName(String titleName){
        this.titleName = titleName;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setNotification (String notification) {
        this.notification = notification;
    }

    public String getNotification() {
        return this.notification;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public  String getDateAndTime() {
        return this.dateAndTime;
    }

    public void setNotificationSound(String notificationSound) {
        this.notificationSound = notificationSound;
    }

    public String getNotificationSound() {
        return this.notificationSound;
    }

    public void setVibration(String vibration) {
        this.vibration = vibration;
    }

    public String getVibration() {
        return this.vibration;
    }

    public void setRepeatInterval(String repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public String getRepeatInterval() {
        return this.repeatInterval;
    }

    public void setContent(String note) {
        this.content = note;
    }

    public String getContent() {
        return this.content;
    }

}
