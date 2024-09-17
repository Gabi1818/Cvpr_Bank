package org.delta.accounts;

public class MoneyTransferService {

    private MoneyTransferFeeCalculator moneyTransferFeeCalculator;

    public MoneyTransferService(){
        this.moneyTransferFeeCalculator = new MoneyTransferFeeCalculator();
    }

    public void addMoneyToBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        currentBalance -= moneyTransferFeeCalculator.calculateFee(amount);
    }

    public void removeMoneyFromBankAccount(BankAccount account, double amount){
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);
    }


    public void TransferMoneyBetweenAccounts(BankAccount from, BankAccount to, double amount) throws Exception {

        if (amount <= 0){
            throw new Exception("Amount transferred must be greater than 0.");
        }

        double currentBalance = from.getBalance();
        currentBalance -= amount;
        if (currentBalance < 0){
            throw new Exception("Not enough money.");
        }
        from.setBalance(currentBalance);

        currentBalance = to.getBalance();
        currentBalance += amount;

        if (!(to instanceof StudentBankAccount)) {
            currentBalance -= moneyTransferFeeCalculator.calculateFee(amount);
        }

        to.setBalance(currentBalance);
    }
}
