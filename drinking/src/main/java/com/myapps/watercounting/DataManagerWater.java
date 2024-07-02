package com.myapps.watercounting;

import com.myapps.common.DataManagerBase;
import com.myapps.common.MSPV;

public class DataManagerWater extends DataManagerBase {

    private final int MINIMUM_GLASSES_PER_DAY = 8;
    @Override
    public int getAmountOfItems() {
        return MSPV.getMe().getAmount();
    }

    @Override
    public int minimumAmountPerDay() {
        return MINIMUM_GLASSES_PER_DAY;
    }
}
