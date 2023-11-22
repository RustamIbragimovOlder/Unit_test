package tdd;

import java.util.Locale;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.toLowerCase().contains("отличный")) {
            return "Happy";
        }
        if (message.toLowerCase().contains("ужас")) {
            return "Unhappy";
        }
        return "Normal";
    }

}
