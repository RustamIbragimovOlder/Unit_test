package number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberModule {

    public List<Integer> generateListNumbers() {
        List<Integer> listNumbers = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            listNumbers.add(rnd.nextInt(101));
        }
        return listNumbers;
    }

}
