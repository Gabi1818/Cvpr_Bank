package org.delta;

import org.delta.accounts.BankAccount;
import org.delta.accounts.MoneyTransferService;
import org.delta.persons.Owner;

public class App {
    public void run(){
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        //Calc calc = new Calculator();
        //calc.div(10,0);

        TestBank();
    }

    private void TestBank(){
        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner("Gabi", "J");
        BankAccount bankAccount = new BankAccount("123", 500, owner);

        System.out.println(owner.getName());
        System.out.println(bankAccount.getBalance());

        bankAccount.setBalance(500 + 100);
        bankAccount.setBalance(500 - 200);

        moneyTransferService.addMoneyToBankAccount(bankAccount, 500);


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
