package model;

import java.util.Random;

public class ListNumbers {

  // Метод создания списка из 15 случайных чисел в диапазоне от 0 до 100
  public int[] createListNumbers() {
    Random random = new Random();
    int[] listNumbers = random.ints(0, 30).distinct().limit(7).toArray();
    return listNumbers;
  }

}
