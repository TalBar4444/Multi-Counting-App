package com.myapps.watercounting;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.myapps.common.PanelBaseActivity;

public class PanelActivity extends PanelBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManagerWater();
        super.onCreate(savedInstanceState);
    }
}