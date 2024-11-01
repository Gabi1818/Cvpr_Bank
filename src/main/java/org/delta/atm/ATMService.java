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


    public void getMoneyFromCard(String cardNumber, String pin, int money) throws Exception {
        BankCard card = findBankCard(cardNumber);
        BankAccount owner = card.getOwner();

        if (card.getPin() != pin)
            throw new Exception("Invalid pin.");

        moneyTransferService.removeMoneyFromBankAccount(owner, money);
    }

    public void getMoneyFromCardToOtherAccount(String cardNumber, String pin, double money, String receivingAccountNumber) throws Exception {
        BankCard card = findBankCard(cardNumber);
        BankAccount owner = card.getOwner();

        if (card.getPin() != pin)
            throw new Exception("Invalid pin.");

        moneyTransferService.removeMoneyFromBankAccount(owner, money);

        BankAccount receivingAccount = findBankAccount(receivingAccountNumber);
        moneyTransferService.addMoneyToBankAccount(receivingAccount, money);
    }

    private BankCard findBankCard(String cardNumber) throws Exception {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();
        BankCard card = null;

        for (BankAccount bankAccount : bankAccountList) {
            try {
                card = bankAccount.getCard(cardNumber);
                if (card != null) {
                    return card;
                }
            } catch (Exception e) {
                throw new Exception("Card not found.");
            }
        }

        throw new Exception("Card not found.");
    }

    private BankAccount findBankAccount(String accountNumber) throws Exception {
        List<BankAccount> bankAccountList = bankAccountFacade.getBankAccounts();
        String currentAccountNumber;

        for (BankAccount bankAccount : bankAccountList) {
            try {
                currentAccountNumber = bankAccount.getAccountNumber();
                if (currentAccountNumber == accountNumber) {
                    return bankAccount;
                }
            } catch (Exception e) {
                throw new Exception("Bank account not found.");
            }
        }

        throw new Exception("Bank account not found.");
    }
}
