import model.ListNumbers;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ListNumbersTest {
    ListNumbers listNumbers;

    // Юнит-тест метода создания списка чисел

    @Test
    void createListNumbersTest() {
        listNumbers = new ListNumbers();

        assertThat(listNumbers.createListNumbers().length).isEqualTo(7);

    }

}
