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


    public BankAccount CreateBankAccount(Owner owner, int balance) {
        BankAccount bankAccount = this.bankAccountFactory.CreateBankAccount(balance, owner);
        this.bankAccounts.add(bankAccount);
        return  bankAccount;
    }

    public BankAccount CreateStudentBankAccount(Owner owner, int balance, String expired) {
        BankAccount bankAccount = this.bankAccountFactory.CreateStudentBankAccount(balance, owner, expired);
        this.bankAccounts.add(bankAccount);
        return  bankAccount;
    }

    public List<BankAccount> GetBankAccounts() {
        return this.bankAccounts;
    }
}
