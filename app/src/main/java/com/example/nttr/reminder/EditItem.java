package com.example.nttr.reminder;

/**
 * Created by nttr on 2017/12/07.
 */

public class EditItem {
    // タイトル
    String title;
    // 通知の有無選択
    Boolean notification;
    // 指定日時
    String dateTime;
    // 通知音
    String notificationSound;
    // 振動
    String vibration;
    // 繰り返し間隔
    String repeatInterval;
    // ノート
    String note;


    // コンストラクタ
    // Ctrl + Enterキーで、GeneratorからConstructorを生成します。
    public EditItem(String title, Boolean notification, String dateTime, String notificationSound, String vibration, String repeatInterval, String note) {
        this.title = title;
        this.notification = notification;
        this.dateTime = dateTime;
        this.notificationSound = notificationSound;
        this.vibration = vibration;
        this.repeatInterval = repeatInterval;
        this.note = note;
    }
}