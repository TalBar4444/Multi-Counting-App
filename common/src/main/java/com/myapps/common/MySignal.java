package com.myapps.common;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MySignal {

    private static MySignal instance;
    private Context context;

    private MySignal(Context context) {
        this.context = context;
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new MySignal(context.getApplicationContext());
        }
    }

    public static MySignal getInstance() {
        return instance;
    }

    public void toast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void openDialog(final Context context, String title, String message, String button) {
        if (context == null) {
            return;
        }
        View customView = LayoutInflater.from(context).inflate(R.layout.activity_dialog, null);
        TextView messageTextView = customView.findViewById(R.id.message_text);
        messageTextView.setText(message);


        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context)
                .setTitle(title)
                .setPositiveButton(button, null);

        builder.setView(customView);
        builder.create().show();
    }

    public void vibrate() {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }
}