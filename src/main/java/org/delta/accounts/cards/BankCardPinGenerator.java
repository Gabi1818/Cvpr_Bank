package org.delta.accounts.cards;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class BankCardPinGenerator {
    public String Generate(){
            Random random = new Random();
            StringBuilder pin = new StringBuilder();

            // Generate a 4-digit random PIN
            for (int i = 0; i < 4; i++) {
                pin.append(random.nextInt(10)); // Append a random digit between 0-9
            }

            return pin.toString();
    }
}
