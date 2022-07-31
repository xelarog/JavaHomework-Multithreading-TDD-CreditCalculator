public class Main {
    public static void main(String[] args) {

        CreditCalculator creditCalculator = new CreditCalculator(100_000, 21, 24);

        System.out.println(creditCalculator);
        System.out.format("%s %.2f руб.\n", "Полная сумма кредита =", creditCalculator.calculateFullCreditAmount());
        System.out.format("%s %.2f руб.\n", "Ежемесячный платёж =", creditCalculator.calculateMonthlyPayment());
        System.out.format("%s %.2f руб.\n","Общая сумма переплаты по кредиту =", creditCalculator.calculateOverpaymentFullPeriod());
    }
}
