package org.delta.investments;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;
import java.util.Random;

@Singleton
public class InvestmentGrowthCalculator {
    @Inject
    InvestmentsFacade investmentsFacade;

    List<Investment> investments = investmentsFacade.getInvestments();

    public void assignRandomInvestmentGrowth() {
        Random random = new Random();

        int minGrowth = -10;
        int maxGrowth = 20;

        for (Investment investment : investments) {
            int randomGrowth = random.nextInt(maxGrowth - minGrowth + 1) + minGrowth;
            investment.setInvestmentGrowth(randomGrowth);
        }
    }
}
