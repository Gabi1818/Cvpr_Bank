package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.*;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.atm.ATMService;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonJsonSerializationService;
import org.delta.persons.PersonalIDValidator;

public class App {
    @Inject
    private BankAccountNumberGeneratorService bankAccountNumberGenerator;

    @Inject
    private MoneyTransferFeeCalculator transferFeeCalculator;

    @Inject
    private PersonalIDValidator personIdValidator;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private PersonJsonSerializationService personJsonSerializationService;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private ATMService atmService;


    public void run() throws Exception {
        TestBank();
    }


    private void TestBank() throws Exception {

        Owner owner = this.ownerFactory.CreateOwner("Gabi", "J", "0");

        /*
        System.out.println(this.personJsonSerializationService.SerializeOwner(owner));
        BankAccount bankAccount = this.bankAccountFactory.CreateStudentBankAccount(500, owner, "not expired");
         */

        BankAccount bankAccount = this.bankAccountFacade.CreateBankAccount(owner, 2500);
        BankCard bankCard = bankCardFactory.createBankCard(bankAccount);

        bankAccount.getInfo();

        String cardNumber = bankCard.getNumber();
        String pin = bankCard.getPin();

        atmService.getMoneyFromCard(cardNumber, pin, 200);
        bankAccount.getInfo();

        /*
        bankAccount.getInfo();
        bankAccount2.getInfo();
        this.moneyTransferService.TransferMoneyBetweenAccounts(bankAccount2, bankAccount, 500);
        bankAccount.getInfo();
        bankAccount2.getInfo();
        */

    }

    private void TestFor(){
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    private void TestString(){
        String text = "textaa";
        System.out.println(text.length());

        int pocetA = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'A' || text.charAt(i) == 'a') {
                pocetA++;
            }
        }

        System.out.println(pocetA);
    }
}
