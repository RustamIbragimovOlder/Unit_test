import main.java.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

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










}
