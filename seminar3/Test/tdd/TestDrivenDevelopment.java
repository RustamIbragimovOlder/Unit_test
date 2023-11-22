import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.MoodAnalyser;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    //3.5. Red-Green-Refactor

    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void goodMood() {
        assertThat(moodAnalyser.analyseMood("Отличный день")).isEqualTo("Happy");
    }

    @Test
    void badMood() {
        assertThat(moodAnalyser.analyseMood("Ужасный день")).isEqualTo("Unhappy");
    }

    @Test
    void normalMood() {
        assertThat(moodAnalyser.analyseMood("Нормальный день")).isEqualTo("Normal");
    }
}