package com.myapps.multicountingapp;

import com.myapps.common.DataManagerBase;
import com.myapps.common.MSPV;

public class DataManagerStretches extends DataManagerBase  {
    private final int MINIMUM_STRETCHES_PER_DAY = 5;
    @Override
    public int getAmountOfItems() {
        return MSPV.getMe().getAmount();
    }

    @Override
    public int minimumAmountPerDay() {
        return MINIMUM_STRETCHES_PER_DAY;
    }

}
