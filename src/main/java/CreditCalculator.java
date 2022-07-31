public class CreditCalculator {
    private final int creditSum;
    private final double interestRate;
    private final int creditPeriod;

    public CreditCalculator(int creditSum, double interestRate, int creditPeriod) {
        this.creditSum = creditSum;
        this.interestRate = interestRate;
        this.creditPeriod = creditPeriod;
    }

    public double calculateMonthlyPayment() {
        double rateMonth = interestRate / 12;
        return creditSum * (rateMonth / 100  + (rateMonth / 100 /( Math.pow(1 + rateMonth / 100, creditPeriod) - 1)));
    }

    public double calculateFullCreditAmount() {
        return calculateMonthlyPayment() * creditPeriod;
    }

    public double calculateOverpaymentFullPeriod() {
        return calculateFullCreditAmount() - creditSum;
    }

    @Override
    public String toString() {
        return "Информация по кредиту: " +
                " сумма кредита : " + creditSum +
                " руб., процентная ставка : " + interestRate + " %" +
                ", срок кредитования : " + creditPeriod + " мес.";
    }
}