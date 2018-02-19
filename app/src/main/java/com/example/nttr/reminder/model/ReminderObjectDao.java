/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.nttr.reminder.model;

import com.example.nttr.reminder.entity.ReminderObject;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by seiji on 2018/02/18.
 */

public class ReminderObjectDao {
    /**
     * レコード件数取得
     *
     * @return レコード件数
     */
    public static int count() {
        try (Realm realm = Realm.getDefaultInstance()) {
            return (int) realm.where(ReminderObject.class).count();
        }
    }

    /**
     * 全レコードの取得
     *
     * @return 全レコード
     * <p>
     * favoriteId で昇順ソートされた結果を返す
     */
    public static List<ReminderObject> getRecords() {
        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<ReminderObject> results = realm.where(ReminderObject.class).findAll();
            results = results.sort("reminderId", Sort.ASCENDING);
            return realm.copyFromRealm(results);
        }
    }

    /**
     * レコード取得
     *
     * @param id リマインダーID
     * @return レコード
     * @throws RuntimeException 該当レコードが存在しない場合
     */
    public static ReminderObject All(int id) {
        try (Realm realm = Realm.getDefaultInstance()) {
            ReminderObject result = realm.where(ReminderObject.class)
                    .equalTo("reminderId", id)
                    .findFirst();
            if (result == null) {
                throw new RuntimeException();
            }
            return realm.copyFromRealm(result);
        }
    }

    /**
     * レコードの追加
     *
     * @param obj レコード
     */
    public static void add(ReminderObject obj) {
        obj.setReminderId(getNextId());
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(obj);
            realm.commitTransaction();
        }
    }

    /**
     * レコードの削除
     *
     * @param id リマインダーID
     */
    public static void remove(int id) {
        try (Realm realm = Realm.getDefaultInstance()) {
            realm.beginTransaction();
            RealmResults<ReminderObject> results = realm.where(ReminderObject.class)
                    .equalTo("reminderId", id)
                    .findAll();
            if (results.size() > 0) {
                results.deleteAllFromRealm();
            }
            realm.commitTransaction();
        }
    }

    /**
     * 次のIDを取得する
     *
     * @return 次のID
     */
    private static int getNextId() {
        try (Realm realm = Realm.getDefaultInstance()) {
            RealmResults<ReminderObject> results = realm.where(ReminderObject.class).findAll();
            if (results.isEmpty()) {
                return 1;
            }
            results = results.sort("reminderId", Sort.DESCENDING);
            return results.get(0).getReminderId() + 1;
        }
    }
}
