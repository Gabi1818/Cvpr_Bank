package org.delta.accounts;

public class BankAccountNumberGeneratorService {
    private int lastNumber;

    public BankAccountNumberGeneratorService() {
        this.lastNumber = -1;
    }

    public String GenerateAccountNumber(){
        lastNumber++;
        return String.valueOf(lastNumber);
    }
}
