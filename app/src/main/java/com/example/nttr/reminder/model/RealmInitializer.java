/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder.model;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by seiji on 2018/02/17.
 */

public class RealmInitializer {
    private static final int SCHEMA_VERSION = 1;

    public static void initialize(Context context) {
        Realm.init(context);
        Realm.setDefaultConfiguration(buildRealmConfiguration());
    }

    /*
    マイグレーション処理はここで行う
     */
    private static RealmConfiguration buildRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .schemaVersion(SCHEMA_VERSION)
                .build();
    }
}
