package org.delta.accounts.cards;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class CardNumberGenerator {
    public String Generate() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        // Generate a 16-digit random card number
        for (int i = 0; i < 16; i++) {
            cardNumber.append(random.nextInt(10)); // Append a random digit between 0-9
        }

        return cardNumber.toString();
    }
}
