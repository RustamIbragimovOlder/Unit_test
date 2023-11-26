package number;

import java.util.List;

public class MaxNumberModule {

    public int maxNumberInList (List<Integer> list) {
        int maxNumber = 0;
        for (Integer element : list) {
            if (element > maxNumber) {
                maxNumber = element;
            }
        }
        return maxNumber;
    }

}
