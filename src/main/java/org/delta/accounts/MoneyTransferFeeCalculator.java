package org.delta.accounts;

import com.google.inject.Singleton;

@Singleton
public class MoneyTransferFeeCalculator {

    private static double ADD_MONEY_FEE = 10;
    private static double ADD_MONEY_FEE_LIMIT = 500;

    public double calculateFee(double amount){
        if (amount <= ADD_MONEY_FEE_LIMIT){
            return ADD_MONEY_FEE;
        }
        else{
            double additionalFee = amount/100;
            return additionalFee + ADD_MONEY_FEE;
        }
    }
}
