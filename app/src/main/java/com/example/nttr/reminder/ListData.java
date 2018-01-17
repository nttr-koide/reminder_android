package com.example.nttr.reminder;

/**
 * Created by nttr on 2017/12/13.
 */

public class ListData {
    String titleName;
    String notification;
    String dateAndTime;
    String notificationSound;
    String vibration;
    String repeatInterval;
    String note;

    public void setTitleName(String titleName){
        this.titleName = titleName;
    }

    public String getTitleName(){
        return this.titleName;
    }

    public void setNotification (String notification){
        this.notification = notification;
    }

    public String getNotification(){
        return this.notification;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public  String getDateAndTime(){
        return this.dateAndTime;
    }

    public void setNotificationSound(String notificationSound){
        this.notificationSound = notificationSound;
    }

    public String getNotificationSound(){
        return this.notificationSound;
    }

    public void setVibration(String vibration){
        this.vibration = vibration;
    }

    public String getVibration(){
        return this.vibration;
    }

    public void setRepeatInterval(String repeatInterval){
        this.repeatInterval = repeatInterval;
    }

    public String getRepeatInterval(){
        return this.repeatInterval;
    }

    public void setNote(String note){
        this.note = note;
    }

    public String getNote(){
        return this.note;
    }
}
