package org.delta.investments;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.*;

import java.util.List;

@Singleton
public class InvestmentService {

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private InvestmentCalculator investmentCalculator;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void addInvestmentToBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();

        List<Investment> investment;
        double moneyToAdd;

        for (BankAccount bankAccount : bankAccountList) {

            if (bankAccount instanceof InvestmentBankAccount) {
                investment = ((InvestmentBankAccount) bankAccount).getInvestments();
                double money = bankAccount.getBalance();

                moneyToAdd = investmentCalculator.calculateMoneyToAdd(investment, money);
                System.out.println("Money to add:" + moneyToAdd);

                moneyTransferService.addMoneyToBankAccount(bankAccount, moneyToAdd);
            }
        }
    }
}
