package org.delta.accounts.cards;

import com.google.inject.Inject;

import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;


@Singleton
public class BankCardFactory {

    @Inject
    CardNumberGenerator cardNumberGenerator;

    @Inject
    BankCardPinGenerator bankCardPinGenerator;

    public BankCard createBankCard(BankAccount owner) {
        return new BankCard(cardNumberGenerator.Generate(), bankCardPinGenerator.Generate(), owner);
    }
}
