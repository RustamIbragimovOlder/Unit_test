package main.java;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    public static void main(String[] args) {

//        if (4 != Calculator.calculation(2, 2, '+')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//        if (1 != Calculator.calculation(2, 1, '-')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//        if (6 != Calculator.calculation(2, 3, '*')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//        if (4 != Calculator.calculation(8, 2, '/')) {
//            throw new AssertionError("Ошибка в методе");
//        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
//        assert 4 == Calculator.calculation(2, 2, '+');
//        assert 1 == Calculator.calculation(2, 1, '-');
//        assert 6 == Calculator.calculation(2, 3, '*');
//        assert 4 == Calculator.calculation(8, 2, '/');

//        Библиотека

        assertThat(Calculator.calculation(2, 2, '+')).isEqualTo(4);
        assertThat(Calculator.calculation(2, 1, '-')).isEqualTo(1);
        assertThat(Calculator.calculation(2, 3, '*')).isEqualTo(6);
        assertThat(Calculator.calculation(8, 2, '/')).isEqualTo(4);

        // Случаи с неправильными аргументами: аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_')).isInstanceOf(IllegalStateException.class);

        // Случаи с неправильными аргументами: аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
//        try {
//            Calculator.calculation(8, 4, '_');
//        } catch (IllegalStateException e) {
//            if (!e.getMessage().equals("Unexpected value operator: _"))
//            {
//                throw new AssertionError("Ошибка в методе");
//            }
//        }
    }

}


//    проверка на соответствие строки
//    assertThat(frodo.getName()).isEqualTo("Frodo");
//    assertThat(frodo).isNotEqualTo(sauron);
//
//    инструмент для работы с коллекциями, в примере ниже в передаваемом списке fellowshipOfTheRing размером 9 элементов утверждается наличие
//    элементов frodo, sam и отсутствие sauron. Если будет передан список, который не удовлетворяет этим условиям, будет выброшено исключение
//
//    assertThat(fellowshipOfTheRing).hasSize(9) .contains(frodo, sam) .doesNotContain(sauron);
//
//    Причём передаваемую коллекцию можно заранее отфильтровать:
//
//     assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o")) .containsOnly(aragorn, frodo, legolas, boromir);
//
//     Есть возможность дополнить сообщение об ошибке с помощью as(), оно будет выводиться перед ошибкой:
//
//     assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);

