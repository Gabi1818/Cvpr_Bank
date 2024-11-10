package org.delta.accounts;

import org.delta.investments.Investment;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

public class InvestmentBankAccount extends  BankAccount{

    public InvestmentBankAccount(String accountNumber, double balance, Owner owner) {
        super(accountNumber, balance, owner);
    }

    private List<Investment> investments = new LinkedList<Investment>();

    public List<Investment> getInvestments() {return investments;}

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    public void addInvestments(List<Investment> investments) {
        this.investments.addAll(investments);
    }
}
