package org.delta.interesting;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFacade;
import org.delta.accounts.MoneyTransferService;
import org.delta.accounts.SavingBankAccount;

import java.util.List;

@Singleton
public class InterestingService {

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private InterestingCalculator interestingCalculator;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void addInterestToBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();

        /*
        int interestFactor = 4;
        for (BankAccount bankAccount : bankAccountList) {
            double moneyToAdd = interestingCalculator.calculateMoneyAdded(bankAccount, interestFactor);
            System.out.println(moneyToAdd);
            moneyTransferService.addMoneyToBankAccount(bankAccount, moneyToAdd);
        }
        */

        int defaultInterestFactor = 2;

        for (BankAccount bankAccount : bankAccountList) {
            double interestFactor;

            if (bankAccount instanceof SavingBankAccount) {
                interestFactor = ((SavingBankAccount) bankAccount).getInterest();
            } else {
                interestFactor = defaultInterestFactor;
            }

            double moneyToAdd = interestingCalculator.calculateMoneyAdded(bankAccount, interestFactor);
            System.out.println("Money to add:" + moneyToAdd);

            moneyTransferService.addMoneyToBankAccount(bankAccount, moneyToAdd);
        }
    }
}
