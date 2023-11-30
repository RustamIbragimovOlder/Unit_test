import controller.Controller;
import java.util.Arrays;
import model.ListNumbers;

public class Main {
  public static void main(String[] args) {

    ListNumbers listNumbers = new ListNumbers();
    Controller controller = new Controller();

    int[] listNumbers1 = listNumbers.createListNumbers();
    System.out.println("Первый список -> " + Arrays.toString(listNumbers1));

    int[] listNumbers2 = listNumbers.createListNumbers();
    System.out.println("Второй список -> " + Arrays.toString(listNumbers2));

    double averageList1 = controller.calculationAverage(listNumbers1);
    System.out.println("Среднее значение первого списка: " + averageList1);

    double averageList2 = controller.calculationAverage(listNumbers2);
    System.out.println("Среднее значение второго списка: " + averageList2);

    controller.comparisonAverages(averageList1, averageList2);

  }
}
