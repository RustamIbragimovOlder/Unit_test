import hw.MainHW;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    @Test
    void evenNumberTest() {
        assertTrue(MainHW.evenOddNumber(2));
    }

    @Test
    void oddNumberTest() {
        assertFalse(MainHW.evenOddNumber(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 50, 100})
    void gettingNumberIntoInterval(int i) {
        assertTrue(MainHW.numberInInterval(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 101})
    void nonOccurrenceNumberInInterval(int i) {
        assertFalse(MainHW.numberInInterval(i));
    }
}
