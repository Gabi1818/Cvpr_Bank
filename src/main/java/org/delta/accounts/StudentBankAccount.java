package org.delta.accounts;

import org.delta.persons.Owner;

public class StudentBankAccount extends BankAccount {
    private String studentStudiesConfirmationExpired;
    public StudentBankAccount(String accountNumber, double balance, Owner owner, String studentStudiesConfirmationExpired) {
        super(accountNumber, balance, owner);

        this.studentStudiesConfirmationExpired = studentStudiesConfirmationExpired;
    }

    public String getStudentStudiesConfirmationExpired() {
        return studentStudiesConfirmationExpired;
    }
}
