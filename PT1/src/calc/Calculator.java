package calc;

public class Calculator {

    public static void main(String[] args) {
        System.out.printf("Сумма покупки с учетом скидки " + calculatingDiscount(100.00, 10));
//        System.out.println(calculatingDiscount(100.00, 101)); // скидка больше 100%
//        System.out.println(calculatingDiscount(100.00, -10)); // скидка меньше 0
//        System.out.println(calculatingDiscount(0.00, 10)); // сумма покупки равна 0
//        System.out.println(calculatingDiscount(-100.00, 10)); // сумма покупки меньше 0
    }
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) {
        if (number == 0) {
            throw new ArithmeticException("It is not possible to extract the root from 0");
        }
        if (number < 0) {
            throw new ArithmeticException("It is impossible to extract the root from negative numbers");
        }

        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;

        // или просто return Math.sqrt(number);
    }

    /**
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return возвращает purchaseAmountIncludingDiscount сумму покупки с учетом скидки
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double purchaseAmountIncludingDiscount = purchaseAmount - (purchaseAmount * discountAmount / 100);

        // С использованием assert
        assert discountAmount < 100 : "Внимание! Скидка не может превышать 100%!";
        assert discountAmount > 0 : "Внимание! Скидка не может быть меньше нуля!";
        assert purchaseAmount > 0 : "Внимание! Сумма покупки должна превышать 0!";

        // С использованием ArithmeticException
//        if (discountAmount > 100) {
//            throw new ArithmeticException("Скидка не может превышать 100");
//        }
//        if (discountAmount < 0) {
//            throw new ArithmeticException("Скидка не может быть меньше нуля");
//        }
//        if (purchaseAmount <= 0) {
//            throw new ArithmeticException("Сумма покупки должна превышать 0");
//        }
        return purchaseAmountIncludingDiscount;
    }
}
