package org.delta.accounts.cards;

import com.google.inject.Inject;

import com.google.inject.Singleton;


@Singleton
public class BankCardFactory {

    @Inject
    CardNumberGenerator cardNumberGenerator;

    @Inject
    BankCardPinGenerator bankCardPinGenerator;

    public BankCard CreateBankCard() {
        return new BankCard(cardNumberGenerator.Generate(), bankCardPinGenerator.Generate());
    }
}
