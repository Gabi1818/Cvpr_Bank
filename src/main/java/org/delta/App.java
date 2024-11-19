package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.*;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.atm.ATMService;
import org.delta.interesting.InterestingService;
import org.delta.investments.InvestmentGrowthCalculator;
import org.delta.investments.InvestmentService;
import org.delta.observer.Observer;
import org.delta.observer.example.MyTopic;
import org.delta.observer.example.MyTopicSubscriber;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

public class App {
    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private ATMService atmService;

    @Inject
    InterestingService interestingService;

    @Inject
    InvestmentGrowthCalculator investmentGrowthCalculator;

    @Inject
    InvestmentService investmentService;


    public void run() throws Exception {
        TestBank();
    }


    private void TestBank() throws Exception {

        Owner owner = this.ownerFactory.createOwner("Gabi", "J", "0");

        /*
        //Serialization
        System.out.println(this.personJsonSerializationService.SerializeOwner(owner));
        BankAccount bankAccount = this.bankAccountFactory.CreateStudentBankAccount(500, owner, "not expired");
         */


        /*
        //Investment
        BankAccount bankAccount = this.bankAccountFacade.createInvestmentBankAccount(owner, 2500, 3);
        bankAccount.getInfo();

        investmentGrowthCalculator.assignRandomInvestmentGrowth();
        investmentService.addInvestmentToBankAccounts();

        bankAccount.getInfo();
         */


        /*
        BankAccount bankAccount2 = this.bankAccountFacade.createSavingBankAccount(owner, 2500);
        bankAccount2.getInfo();

        interestingService.addInterestToBankAccounts();
        bankAccount.getInfo();
        bankAccount2.getInfo();
         */

        /*
        String cardNumber = bankCard.getNumber();
        String pin = bankCard.getPin();

        atmService.getMoneyFromCard(cardNumber, pin, 200);
        bankAccount.getInfo();
        */


        /*
        //Money transfer
        bankAccount.getInfo();
        bankAccount2.getInfo();
        this.moneyTransferService.TransferMoneyBetweenAccounts(bankAccount2, bankAccount, 500);
        bankAccount.getInfo();
        bankAccount2.getInfo();
        */


        //Observer test
        MyTopic topic = new MyTopic();

        Observer myTopicSubscriber1 = new MyTopicSubscriber("Obj1");
        Observer myTopicSubscriber2 = new MyTopicSubscriber("Obj2");
        Observer myTopicSubscriber3 = new MyTopicSubscriber("Obj3");

        topic.register(myTopicSubscriber1);
        topic.register(myTopicSubscriber2);
        topic.register(myTopicSubscriber3);

        myTopicSubscriber1.update();

        topic.postMessage("New message");
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
