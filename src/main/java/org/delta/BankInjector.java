package org.delta;

import com.google.inject.AbstractModule;
import org.delta.accounts.AccountNumberGenerator;
import org.delta.accounts.SlovakiaAccountNumberGenerator;
import org.delta.accounts.cards.BankCardFactory;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(AccountNumberGenerator.class).to(SlovakiaAccountNumberGenerator.class);
        this.bind(BankCardFactory.class);
    }
}
