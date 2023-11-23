package main.java;

import java.util.List;

import static org.mockito.Mockito.*;

public class Mockito {

    public static void main(String[] args) {
        List mockedList = mock(List.class); // Создание mock

        mockedList.add("one"); // Использование
        System.out.println(mockedList.get(0)); // Выведет "null"
        mockedList.clear();

        when(mockedList.get(0)).thenReturn("nullValue");
        System.out.println(mockedList.get(0)); // Выведет "nullValue"

        when(mockedList.get(0)).thenReturn("Hello Rustam");
        System.out.println(mockedList.get(0)); // Выведет "Hello Rustam"

        // Можно настраивать выбрасываемое исключение:
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        System.out.println(mockedList.get(1)); // Вернет исключение runtime exception

        // Mockito отслеживает все вызовы методов и их параметров для mock-объекта. Вы можете использовать метод verify(), чтобы убедиться, что метод был вызван с определёнными параметрами.
        verify(mockedList).get(0);

        // Вызов реальных методов:
        // when(mock.someMethod()).thenCallRealMethod();

        // Проверка точного количества вызовов:
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, never()).add("never happened");

        // Проверка с таймаутом:
        // verify(mock, timeout(100)).someMethod();

        // Есть также класс BDDMockito, предоставляющий примерно те же возможности, что и класс Mockito в форме, более подходящей для BDD.
        // import static org.mockito.BDDMockito.*;
        // Seller seller = mock(Seller.class);
        // Shop shop = new Shop(seller);
        // public void shouldBuyBread() throws Exception {

            // given(seller.askForBread()).willReturn(new Bread());  // given

            // Goods goods = shop.buyBread(); // when

            // assertThat(goods, containBread()); // then
        // }





    }

}
