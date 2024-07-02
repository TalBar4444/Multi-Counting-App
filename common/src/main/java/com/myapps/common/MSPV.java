package com.myapps.common;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.work.Configuration;

public class MSPV{
    private static final String SP_FILE_NAME = "SP_FILE_NAME";
    private static final String SP_COUNTER = "SP_COUNTER";
    private SharedPreferences prefs = null;
    private static MSPV me;

    private MSPV(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }
    public static void init(Context context) {
        if (me == null) {
            me = new MSPV(context);
        }
    }
    public static MSPV getMe() { //getInstance
        return me;
    }

    public void saveInt(String key, int value){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int readInt(String key, int def){
        int value = prefs.getInt(key, def);
        return value;
    }

    public void setAmount(int value) {
        saveInt(SP_COUNTER,value);
    }

    public int getAmount() {
        int amount = this.getMe().readInt(SP_COUNTER,0);
        return amount;
    }

}
