package org.delta;

import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
import org.delta.accounts.MoneyTransferService;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

public class App {
    public void run() throws Exception {
        TestBank();
    }


    private void TestBank() throws Exception {
        MoneyTransferService moneyTransferService = new MoneyTransferService();
        OwnerFactory ownerFactory = new OwnerFactory();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        Owner owner = ownerFactory.CreateOwner("Gabi", "J", "0");


        BankAccount bankAccount = bankAccountFactory.CreateStudentBankAccount(500, owner, "not expired");
        BankAccount bankAccount2 = bankAccountFactory.CreateBankAccount(2500, owner);

        bankAccount.getInfo();
        bankAccount2.getInfo();

        moneyTransferService.TransferMoneyBetweenAccounts(bankAccount2, bankAccount, 500);


        bankAccount.getInfo();
        bankAccount2.getInfo();

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
