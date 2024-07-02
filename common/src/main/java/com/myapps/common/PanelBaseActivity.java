package com.myapps.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import com.google.android.material.textview.MaterialTextView;

public class PanelBaseActivity extends AppCompatActivity {
    protected DataManagerBase dataManagerBase;
    private AppCompatImageButton panel_BTN_add, panel_BTN_sub;
    private MaterialTextView panel_EDT_amount;
    private AppManager appManager;
    private BroadcastReceiver radio_reset = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(Intent.ACTION_DATE_CHANGED)) {
                appManager.setAmountInPref(0);
                runOnUiThread(() -> {
                    panel_EDT_amount.setText(String.valueOf(0)); // Update view
                });
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
        findViews();
        appManager = new AppManager(dataManagerBase);

        panel_EDT_amount.setText("" + appManager.getCurrentAmount());
        panel_BTN_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmount("+");
            }
        });
        panel_BTN_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmount("-");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(radio_reset, new IntentFilter(Intent.ACTION_DATE_CHANGED));

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(radio_reset);
    }

    private void changeAmount(String action){
        int amount = appManager.changeAmountOfItems(action);
        panel_EDT_amount.setText("" + amount);
        checkAmount(amount);
    }

    private void checkAmount(int amount){
        if(amount == dataManagerBase.minimumAmountPerDay()){
            MySignal.getInstance().openDialog(this, "Well done !","You have reached the desired daily amount","Got it");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(radio_reset);
    }

    private void findViews() {
        panel_EDT_amount = findViewById(R.id.panel_EDT_amount);
        panel_BTN_add = findViewById(R.id.panel_BTN_add);
        panel_BTN_sub = findViewById(R.id.panel_BTN_sub);

    }

}
