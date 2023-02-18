
import java.util.Scanner;


public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
       double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return roundResult(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
         return roundResult(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundResult(double value, int exponent) {
       double scale= Math.pow(10, exponent);

       return Math.round(value * scale) / scale;
    }

    void compareDeposits() {
      int period;
      int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
      int amount = scanner.nextInt();
      System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double resultValue = 0;
        if (action == 1) {
            resultValue = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            resultValue = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultValue);
    }

    public static void main(String[] args) {
        new DepositCalculator().compareDeposits();
    }

}
