package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.persons.Owner;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private Owner owner;

    private Map<String, BankCard> cardsInMap;



    public BankAccount(String accountNumber, double balance, Owner owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        cardsInMap = new HashMap<String, BankCard>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void getInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Owner: " + owner.getName());
        System.out.println("Cards: ");

        for (BankCard card : cardsInMap.values()) {
            System.out.println(card.getNumber());
        }
    }

    public BankCard getCard(String cardNumber){
        return cardsInMap.get(cardNumber);
    }

    public int getAmountOfBankCards(){
        return cardsInMap.size();
    }

    public void assignNewCard(BankCard bankCard){
        cardsInMap.put(bankCard.getNumber(), bankCard);
    }

    public Map<String, BankCard> getCards() {
        return cardsInMap;
    }
}
