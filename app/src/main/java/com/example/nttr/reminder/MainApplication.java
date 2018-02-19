/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder;

import android.app.Application;

import com.example.nttr.reminder.model.RealmInitializer;

/**
 * Created by seiji on 2018/02/17.
 */

public class MainApplication extends Application {
    private static MainApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RealmInitializer.initialize(this);
    }
    public static MainApplication getInstance() {
        return instance;
    }
}
