package org.delta.investments;

import com.google.inject.Singleton;

@Singleton
public class InvestmentsFactory {
    public Investment createInvestment(String name, int percentageToInvest, int investmentGrowth) {
        return new Investment(name, percentageToInvest, investmentGrowth);
    }
}
