package org.delta.interesting;

import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;

@Singleton
public class InterestingCalculator {

    public double calculateMoneyAdded(BankAccount bankAccount, double interestFactor) {
        double balance = bankAccount.getBalance();
        double interestRate = interestFactor / 100.0;
        double moneyAdded = balance * interestRate;
        return moneyAdded;
    }
}
