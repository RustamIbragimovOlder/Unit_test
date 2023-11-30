package controller;

public class Controller {

  // Метод расчета среднего значения списка чисел
  public static double calculationAverage(int[] listNumbers) {

    int sum = 0;
    for (int number : listNumbers) {
      sum += number;
    }
    double averageList = sum / listNumbers.length;
    return averageList;
  }

  // Метод сравнения средних значений двух списков чисел
  public void comparisonAverages(double averageList1, double averageList2) {

    if (averageList1 > averageList2) {
      System.out.println("Первый список имеет большее среднее значение");
    } else if (averageList1 < averageList2) {
      System.out.println("Второй список имеет большее среднее значение");
    } else {
      System.out.println("Средние значения равны");
    }
  }
}
