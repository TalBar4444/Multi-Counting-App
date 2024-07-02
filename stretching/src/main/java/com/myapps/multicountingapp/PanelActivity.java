package com.myapps.multicountingapp;

import android.os.Bundle;
import com.myapps.common.PanelBaseActivity;

public class PanelActivity extends PanelBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManagerStretches();
        super.onCreate(savedInstanceState);

    }


}