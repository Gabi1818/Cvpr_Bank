package org.delta.investments;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;
import org.delta.accounts.InvestmentBankAccount;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Singleton
public class InvestmentsFacade {

    private List<Investment> investments = new LinkedList<Investment>();

    @Inject
    InvestmentsFactory investmentsFactory;

    public void createNewInvestments(int numberOfInvestments, BankAccount bankAccount) {
        Random random = new Random();
        int remainingPercentage = 100;

        for (int i = 0; i < numberOfInvestments; i++) {
            int percentageToInvest;

            if (i == numberOfInvestments - 1) {
                percentageToInvest = remainingPercentage;
            } else {
                int maxPercentageForCurrentInvestment = remainingPercentage - (numberOfInvestments - i - 1);
                percentageToInvest = random.nextInt(maxPercentageForCurrentInvestment) + 1;
            }

            remainingPercentage -= percentageToInvest;

            String name = "Investment " + (i + 1);

            Investment investment = this.investmentsFactory.createInvestment(name, percentageToInvest, 0);
            this.investments.add(investment);
            ((InvestmentBankAccount) bankAccount).addInvestment(investment);
        }
    }


    public List<Investment> getInvestments() {return this.investments;}
}
