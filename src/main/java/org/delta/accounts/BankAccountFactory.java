package org.delta.accounts;

import org.delta.persons.Owner;

public class BankAccountFactory {

    private BankAccountNumberGeneratorService bankAccountNumberGeneratorService;

    public BankAccountFactory(){
        this.bankAccountNumberGeneratorService = new BankAccountNumberGeneratorService();
    }

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
