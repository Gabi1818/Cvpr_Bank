package org.delta.investments;

import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class InvestmentCalculator {

    public double calculateMoneyToAdd(List<Investment> investments, double totalAmountOfMoneyOnAccount) {
        double moneyToAdd = 0;

        for (Investment investment : investments) {
            double percentageToInvest = investment.getPercentageToInvest();
            double initialInvestmentAmount = (percentageToInvest / 100) * totalAmountOfMoneyOnAccount;
            double growthPercentage = investment.getInvestmentGrowth();
            double growthAmount = (growthPercentage / 100) * initialInvestmentAmount;

            moneyToAdd += growthAmount;
        }

        return moneyToAdd;
    }
}
