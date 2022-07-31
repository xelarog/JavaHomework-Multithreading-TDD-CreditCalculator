import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreditCalculator {

    @Test
    @DisplayName("Тест расчёта ежемесячного платежа")
    public void testCalculateMonthlyPayment() {
        int creditSum = 100_000;
        double interestRate = 21;
        int creditPeriod = 24;
        CreditCalculator creditCalculator = new CreditCalculator(creditSum, interestRate, creditPeriod);

        double expected = creditSum * (interestRate / 12 / 100  + (interestRate / 12 / 100 /( Math.pow(1 + interestRate / 12 / 100, creditPeriod) - 1)));         // СЗ*(П+(П/(1+П)*СК-1)),

        double result = creditCalculator.calculateMonthlyPayment();

        assertTrue(result == expected);
    }

    @Test
    @DisplayName("Тест расчёта полной суммы кредита")
    public void testCalculateFullCreditAmount() {
        int creditSum = 100_000;
        double interestRate = 9;
        int creditPeriod = 24;
        CreditCalculator creditCalculator = new CreditCalculator(creditSum, interestRate, creditPeriod);

        double monthlyPayment = creditSum * (interestRate / 12 / 100  + (interestRate / 12 / 100 /( Math.pow(1 + interestRate / 12 / 100, creditPeriod) - 1)));
        double expected = monthlyPayment * creditPeriod;

        double result = creditCalculator.calculateFullCreditAmount();

        assertTrue( result == expected);
    }

    @Test
    @DisplayName("Тест расчёта переплаты за весь кредитный период")
    public void testCalculateOverpaymentFullPeriod() {
        int creditSum = 100_000;
        double interestRate = 9;
        int creditPeriod = 24;
        CreditCalculator creditCalculator = new CreditCalculator(creditSum, interestRate, creditPeriod);

        double monthlyPayment = creditSum * (interestRate / 12 / 100  + (interestRate / 12 / 100 /( Math.pow(1 + interestRate / 12 / 100, creditPeriod) - 1)));
        double expexted = monthlyPayment * creditPeriod - creditSum;

        double result = creditCalculator.calculateOverpaymentFullPeriod();
        assertTrue(result == expexted);
    }
}
