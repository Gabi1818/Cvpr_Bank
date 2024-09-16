package org.delta.accounts;

public class MoneyTransferService {

    private MoneyTransferFeeCalculator moneyTransferFeeCalculator;

    public MoneyTransferService(){
        MoneyTransferFeeCalculator moneyTransferFeeCalculator = new MoneyTransferFeeCalculator();
    }

    public void addMoneyToBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        currentBalance -= moneyTransferFeeCalculator.calculateFee(amount);
    }

    public void removeMoneyFromBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);
    }
}
