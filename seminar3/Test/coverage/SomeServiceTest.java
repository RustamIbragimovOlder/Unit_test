import coverage.SomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.w3c.dom.ls.LSOutput;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    // 3.1.
    @Test
    void testReturnFizz() {
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void testReturnBuzz() {
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void testReturnFizzBuzz() {
        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    // 3.2.
    @Test
    void checkFirstLast6() {
        assertThat(someService.firstLast6(new int[] {6, 5, 4, 6})).isTrue();
    }

    // 3.3.
    @ParameterizedTest
    @CsvSource({"2000.0, 50, 1000", "2000, 100, 0", "2000, 0, 2000"})
    void calculatingDiscountPositiveCase(double amount, int discount, double finish) {
        assertThat(someService.calculatingDiscount(amount, discount)).isEqualTo(finish);
    }

    @Test
    void insufficentCoverageTest() {

        assertThatThrownBy(() -> someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // Скидка больше 100%

        assertThatThrownBy(() -> someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // Скидка меньше 0%

        assertThatThrownBy(() -> someService.calculatingDiscount(-2000.0, 10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Сумма покупки не может быть отрицательной"); // Сумма меньше 0
    }

    // 3.4.
    @Test
    void summCorrect() {
        assertThat(someService.luckySum(1, 2, 3)).isEqualTo(6);
    }

    @Test
    void summCorrectA() {
        assertThat(someService.luckySum(13, 2, 3)).isEqualTo(5);
    }

    @Test
    void summCorrectB() {
        assertThat(someService.luckySum(1, 13, 3)).isEqualTo(4);
    }

    @Test
    void summCorrectC() {
        assertThat(someService.luckySum(1, 2, 13)).isEqualTo(3);
    }


}
