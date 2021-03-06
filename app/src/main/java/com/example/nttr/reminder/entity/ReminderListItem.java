/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder.entity;

/**
 * Created by seiji on 2018/02/18.
 */

public class ReminderListItem {

    private ReminderObject object;

    public ReminderListItem(ReminderObject object) {
        this.object = object;
    }

    public ReminderObject getObject() {
        return object;
    }

    public void setObject(ReminderObject object) {
        this.object = object;
    }

}
