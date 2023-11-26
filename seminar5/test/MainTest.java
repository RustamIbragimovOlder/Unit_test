import number.MaxNumberModule;
import number.RandomNumberModule;
import order.OrderService;
import order.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import user.UserRepository;
import user.UserService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    // 5.1.
    // Создайте два модуля. Первый модуль генерирует список случайных чисел.
    // Второй модуль находит максимальное число в этом списке.
    // Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
    // тест, который проверяет, что оба модуля работают вместе правильно


    // Юнит-тест для модуля RandomNumberModule
    @Test
    void checkListNumbers() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Integer> listNumbers = randomNumberModule.generateListNumbers();

        assertThat(listNumbers.size()).isEqualTo(10);
    }

    // Юнит-тест для модуля MaxNumberModule
    @Test
    void searchMax() {
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 36, 29, 57, 44, 88, 5));

        assertThat(maxNumberModule.maxNumberInList(list)).isEqualTo(88);
    }

    // Интеграционный тест для обоих модулей
    @Test
    void integrationTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> listNumbers = randomNumberModule.generateListNumbers();
        int maxNumber = maxNumberModule.maxNumberInList(listNumbers);

        assertThat(maxNumber).isEqualTo(Collections.max(listNumbers));

    }

    // 5.2.
    // У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для получения информации о пользователе.
    // Ваша задача - написать интеграционный тест, который проверяет, что UserService и UserRepository работают вместе должным образом.

    @ParameterizedTest
    @ValueSource(ints = {1, 100, -10, 0})
    void testUserIntegration(int id) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String result = userService.getUserName(id);

        assertEquals("select username from users where id = " + id, result);
    }

    // 5.3.
    // У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и PaymentService.
    // Класс OrderService обрабатывает заказы и делает вызовы к PaymentService для обработки платежей.
    // Ваша задача - написать интеграционный тест, который проверяет, что OrderService и PaymentService взаимодействуют корректно

    @Test
    void orderServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("10", 150);

        assertTrue(result);
    }
}