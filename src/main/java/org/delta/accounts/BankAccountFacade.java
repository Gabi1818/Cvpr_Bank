package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class BankAccountFacade {

    private List<BankAccount> bankAccounts = new LinkedList<BankAccount>();

    @Inject
    BankAccountFactory bankAccountFactory;


    public BankAccount createBankAccount(Owner owner, int balance) {
        BankAccount bankAccount = this.bankAccountFactory.createBankAccount(balance, owner);
        this.bankAccounts.add(bankAccount);
        return bankAccount;
    }

    public BankAccount createStudentBankAccount(Owner owner, int balance, String expired) {
        BankAccount bankAccount = this.bankAccountFactory.createStudentBankAccount(balance, owner, expired);
        this.bankAccounts.add(bankAccount);
        return  bankAccount;
    }

    public BankAccount createSavingBankAccount(Owner owner, double balance) {
        BankAccount account = this.bankAccountFactory.createSavingBankAccount(owner, balance);
        this.bankAccounts.add(account);

        return account;
    }

    public List<BankAccount> getBankAccounts() {
        return this.bankAccounts;
    }
}
