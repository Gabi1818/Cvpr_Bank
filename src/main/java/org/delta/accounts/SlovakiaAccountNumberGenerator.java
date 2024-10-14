package org.delta.accounts;

import com.google.inject.Singleton;

@Singleton
public class SlovakiaAccountNumberGenerator implements AccountNumberGenerator {
    @Override
    public String GenerateAccountNumber() {
        return "Sk";
    }
}
