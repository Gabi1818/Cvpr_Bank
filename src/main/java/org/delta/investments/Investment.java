package org.delta.investments;

public class Investment {
    private String name;
    private double percentageToInvest;
    private double investmentGrowth;

    public Investment(String name, double percentageToInvest, double investmentGrowth) {
        this.name = name;
        this.percentageToInvest = percentageToInvest;
        this.investmentGrowth = investmentGrowth;
    }

    public void setInvestmentGrowth(int investmentGrowth) {
        this.investmentGrowth = investmentGrowth;
    }

    public double getPercentageToInvest() { return percentageToInvest; }

    public double getInvestmentGrowth() { return investmentGrowth; }

    public String getName() { return name; }
}
