package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.accounts.InvestmentBankAccount;
import org.delta.accounts.BankAccount;

import org.delta.accounts.BankAccountFacade;
import org.delta.investments.Investment;
import org.delta.investments.InvestmentGrowthCalculator;
import org.delta.investments.InvestmentService;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvestmentsTest {

    Injector i = Guice.createInjector(new BankInjector());

    private OwnerFactory ownerFactory;
    private BankAccountFacade bankAccountFacade;
    private InvestmentService investmentService;

    @BeforeEach
    public void setUp() {
        ownerFactory = i.getInstance(OwnerFactory.class);
        bankAccountFacade = i.getInstance(BankAccountFacade.class);
        investmentService = i.getInstance(InvestmentService.class);
    }

    @Test
    @DisplayName("Investments test")
    void testInvestments() throws Exception {
        Owner ownerTest = this.ownerFactory.createOwner("G", "J", "123");
        InvestmentBankAccount testInvestmentAccount = (InvestmentBankAccount)this.bankAccountFacade.createInvestmentBankAccount(ownerTest, 1000, 3);

        List<Investment> investments = testInvestmentAccount.getInvestments();
        double currentBalance = testInvestmentAccount.getBalance();
        double balanceTest = 0;

        for (Investment investment : investments) {
            double percentageToInvest = investment.getPercentageToInvest();
            double initialInvestmentAmount = (percentageToInvest / 100) * currentBalance;
            double growthPercentage = investment.getInvestmentGrowth();
            double growthAmount = (growthPercentage / 100) * initialInvestmentAmount;

            balanceTest += growthAmount;
        }

        investmentService.addInvestmentToBankAccounts();
        assertEquals(testInvestmentAccount.getBalance(), balanceTest + testInvestmentAccount.getBalance());
    }
}
