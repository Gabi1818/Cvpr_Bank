package org.delta.accounts;

import com.google.inject.Singleton;

@Singleton
public class BankAccountNumberGeneratorService implements  AccountNumberGenerator{
    private int lastNumber;

    public BankAccountNumberGeneratorService() {
        this.lastNumber = -1;
    }

    public String GenerateAccountNumber(){
        lastNumber++;
        return String.valueOf(lastNumber);
    }
}
