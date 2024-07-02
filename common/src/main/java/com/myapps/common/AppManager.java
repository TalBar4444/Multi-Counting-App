package com.myapps.common;
public class AppManager {
    private int amount = 0;

    public AppManager(DataManagerBase dataManager){
        amount = dataManager.getAmountOfItems();

    }

    public int getCurrentAmount(){
        return amount;
    }

    public void setAmountInPref(int localAmount){
        amount = localAmount;
        MSPV.getMe().setAmount(amount);
    }



    public int changeAmountOfItems(String action) {
        if(action.equals("+")) {
            amount++;
        }
        else if(action.equals("-")){
            if(amount > 0)
                amount--;
            else
                amount =0;
        }
        setAmountInPref(amount);
        return amount;
    }
}
