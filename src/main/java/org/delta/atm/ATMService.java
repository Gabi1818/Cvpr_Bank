package org.delta.atm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFacade;
import org.delta.accounts.MoneyTransferService;
import org.delta.accounts.cards.BankCard;

import java.util.List;

@Singleton
public class ATMService {

    @Inject
    BankAccountFacade bankAccountFacade;

    @Inject
    MoneyTransferService moneyTransferService;


    public void getMoneyFromCard(String cardNumber, String pin, int money){
        List<BankAccount> bankAccountList = bankAccountFacade.GetBankAccounts();
        BankCard card = null;
        BankAccount ownerBankAccount = null;

        for (BankAccount bankAccount : bankAccountList) {
            try {
                card = bankAccount.getCard(cardNumber);
                if (card != null) {
                    ownerBankAccount = bankAccount;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Card not found in this bank account: " + bankAccount.getAccountNumber());
                return;
            }
        }

        if (card.getPin() != pin)
            return;

        if (ownerBankAccount.getBalance() >= money){
            moneyTransferService.removeMoneyFromBankAccount(ownerBankAccount, money);
        }
    }
}
