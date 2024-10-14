package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.Injector;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    private BankAccountNumberGeneratorService bankAccountNumberGeneratorService;

    public BankAccount CreateBankAccount(double balance, Owner owner) {
        String accountNumber = bankAccountNumberGeneratorService.GenerateAccountNumber();
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount CreateStudentBankAccount(double balance, Owner owner, String studentStudiesConfirmationExpired) {
        String accountNumber = bankAccountNumberGeneratorService.GenerateAccountNumber();
        return new StudentBankAccount(accountNumber, balance, owner, studentStudiesConfirmationExpired);
    }

    public BankAccount CreateBankAccount(String accountNumber, double balance, Owner owner) {
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount CreateStudentBankAccount(String accountNumber, double balance, Owner owner, String studentStudiesConfirmationExpired) {
        return new StudentBankAccount(accountNumber, balance, owner, studentStudiesConfirmationExpired);
    }

}
