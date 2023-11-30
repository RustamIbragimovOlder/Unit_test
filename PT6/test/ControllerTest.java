import controller.Controller;
import model.ListNumbers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    ListNumbers listNumbers;

    int[] arrayTest;

    // Юнит-тест метода расчета среднего значения списка чисел

    @Test
    void calculationAverageTest() {
        listNumbers = new ListNumbers();
        arrayTest = new int[]{5, 10, 15};
        Controller controller = new Controller();

        assertThat(controller.calculationAverage(arrayTest)).isEqualTo(10);
    }

    // Юнит-тесты метода сравнения средних значений двух списков чисел

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void comparisonAveragesTestMore() {
        Controller controller = new Controller();

        controller.comparisonAverages(10.5, 10.0);
        assertEquals("Первый список имеет большее среднее значение", outputStreamCaptor.toString().trim());

    }

    @Test
    public void comparisonAveragesTestLess() {
        Controller controller = new Controller();

        controller.comparisonAverages(10.5, 10.5);
        assertEquals("Средние значения равны", outputStreamCaptor.toString().trim());

    }

    @Test
    public void comparisonAveragesTestEqually() {
        Controller controller = new Controller();

        controller.comparisonAverages(10.0, 10.5);
        assertEquals("Второй список имеет большее среднее значение", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}

