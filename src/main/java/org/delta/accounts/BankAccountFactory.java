package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.Injector;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    private BankAccountNumberGeneratorService bankAccountNumberGeneratorService;

    public BankAccount createBankAccount(double balance, Owner owner) {
        String accountNumber = bankAccountNumberGeneratorService.GenerateAccountNumber();
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, String studentStudiesConfirmationExpired) {
        String accountNumber = bankAccountNumberGeneratorService.GenerateAccountNumber();
        return new StudentBankAccount(accountNumber, balance, owner, studentStudiesConfirmationExpired);
    }

    public BankAccount createBankAccount(String accountNumber, double balance, Owner owner) {
        return new BankAccount(accountNumber, balance, owner);
    }

    public BankAccount createStudentBankAccount(String accountNumber, double balance, Owner owner, String studentStudiesConfirmationExpired) {
        return new StudentBankAccount(accountNumber, balance, owner, studentStudiesConfirmationExpired);
    }

    public BankAccount createSavingBankAccount(Owner owner, double balance) {
        String accountNumber = bankAccountNumberGeneratorService.GenerateAccountNumber();

        return new SavingBankAccount(balance, owner, accountNumber);
    }

    public BankAccount createInvestmentBankAccount(Owner owner, double balance) {
        String accountNumber = bankAccountNumberGeneratorService.GenerateAccountNumber();
        return new InvestmentBankAccount(accountNumber, balance, owner);
    }

}
