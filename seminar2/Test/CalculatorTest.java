import org.junit.jupiter.api.Test;
import task_lection2.Calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 2, '+')).isEqualTo(4);
    }

    @Test
    void subsctractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 1, '-')).isEqualTo(1);
    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 3, '*')).isEqualTo(6);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(8, 2, '/')).isEqualTo(4);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol () {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8,4,'_')).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "59"; // Значение для тестов
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in; // Сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // Подменяем ввод
        Calculator.getOperand(); // Вызываем метод
        System.out.println(testedValue); // Для наглядности вывода
        System.setIn(inputStream); // Подменяем обратно
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class).describedAs("Ошибка в вводимых данных");
        System.setIn(inputStream);
        System.setOut(null);
    }

//    Примеры анотаций

//    1. @BeforeEach - Означает, что аннотированный метод должен выполняться перед каждым методом @Test, @RepeatedTest, @ParameterizedTest или @TestFactory в текущем классе.

//    @BeforeEach
//    public void initEach(){
//        //test setup code
//    }

//    2. @AfterEach - Означает, что аннотированный метод должен выполняться после каждого метода @Test, @RepeatedTest, @ParameterizedTest или @TestFactory в текущем классе.
//
//    @AfterEach
//    public void cleanUpEach(){
//        //Test cleanup code
//    }

//    3. @BeforeAll - Означает, что аннотированный метод должен выполняться перед всеми методами @Test, @RepeatedTest, @ParameterizedTest и @TestFactory в текущем классе; аналогично @BeforeClass в JUnit 4. Такие методы должны быть статическими, если не используется жизненный цикл тестового экземпляра «для каждого класса».
//
//    @BeforeAll
//    public static void init(){
//        System.out.println("BeforeAll init() method called");
//    }

//    4. @AfterAll - Означает, что аннотированный метод должен выполняться после всех методов @Test, @RepeatedTest, @ParameterizedTest и @TestFactory в текущем классе.
//    Такие методы должны быть статическими, если не используется жизненный цикл экземпляра теста «для каждого класса».
//
//    @AfterAll
//    public static void cleanUp(){
//        System.out.println("After All cleanUp() method called");
//    }

//    5. @DisplayName - Объявляет пользовательское отображаемое имя для тестового класса или тестового метода.
//
//    @Test
//    @DisplayName("╯°□°）╯")
//    void testWithDisplayNameContainingSpecialCharacters() {
//    }

//    6. @Disable - Используется для отключения тестового класса или тестового метода;
//
//    @Disabled("Disabled until bug #42 has been resolved")
//    @Test
//    void testWillBeSkipped() {
//    }

//    7. @RepeatedTest - Означает, что метод является шаблоном теста для повторного тестирования
//
//    @RepeatedTest(10)
//    void repeatedTest() {
//        // ...
//    }

//    8. @ParameterizedTest - Означает, что метод является параметризованным тестом
//
//    @ParameterizedTest
//    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
//            void palindromes(String candidate) {
//        assertTrue(StringUtils.isPalindrome(candidate));
//    }

////    Попробуйте написать тесты, аналогично коду с урока. Добавьте проверки на граничные случаи
//
//// Проверка максимального и минимального значения, которое может хранить тип int
//assert Integer.MAX_VALUE == Calculator.calculation(Integer.MAX_VALUE - 1, 1, '+');
//assert Integer.MIN_VALUE == Calculator.calculation(Integer.MIN_VALUE + 1, -1, '+');
//// Проверка переполнения
//try {
//        Calculator.calculation(Integer.MAX_VALUE, 1, '+');
//        assert false; // Если мы здесь, значит, ожидаемого исключения не было
//    } catch (ArithmeticException e) {
//        assert true; // Мы ожидаем исключение ArithmeticException при переполнении
//    }
//try {
//        Calculator.calculation(Integer.MIN_VALUE, -1, '+');
//        assert false; // Если мы здесь, значит, ожидаемого исключения не было
//    } catch (ArithmeticException e) {
//        assert true; // Мы ожидаем исключение ArithmeticException при переполнении
//    }
//// Проверка деления на ноль
//try {
//        Calculator.calculation(1, 0, '/');
//        assert false; // Если мы здесь, значит, ожидаемого исключения не было
//    } catch (ArithmeticException e) {
//        assert true; // Мы ожидаем исключение ArithmeticException при делении на ноль
//    }
//// Проверка неправильного оператора
//try {
//        Calculator.calculation(1, 1, 'a');
//        assert false; // Если мы здесь, значит, ожидаемого исключения не было
//    } catch (IllegalStateException e) {
//        assert true; // Мы ожидаем исключение IllegalStateException при использовании неправильного оператора
//    }


    //    Добавьте функцию возведения в степень в калькулятор и протестируйте

    @Test
    public void testPowPositiveNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(8.0, calculator.pow(2.0, 3.0), 0.001); // 0.001 - погрешность
    }
    @Test
    public void testPowZeroExponent() {
        Calculator calculator = new Calculator();
        assertEquals(1.0, calculator.pow(2.0, 0.0), 0.001);
    }
    @Test
    public void testPowOneExponent() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.pow(2.0, 1.0), 0.001);
    }
    @Test
    public void testPowNegativeBase() {
        Calculator calculator = new Calculator();
        assertEquals(-8.0, calculator.pow(-2.0, 3.0), 0.001);
    }
    @Test
    public void testPowNegativeExponent() {
        Calculator calculator = new Calculator();
        assertEquals(0.5, calculator.pow(2.0, -1.0), 0.001);
    }





}
