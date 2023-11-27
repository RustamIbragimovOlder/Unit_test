class Tasks:
    # Задание 1
    # Напишите функцию для поиска среднего значения в списке чисел и соответствующие юниттесты с использованием фреймворка pytest.
    # @staticmethod
    # def find_average(numbers):
    #     if not numbers:
    #         return 0
    #     return sum(numbers) / len(numbers)

    # Задание 2
    # Модифицируйте функцию find_average так, чтобы она вызывала исключение TypeError, если ей передается не список.
    # Напишите тест, который проверяет вызов этого исключения
    @staticmethod
    def find_average(numbers):
        if not isinstance(numbers, list):
            raise TypeError("Input should be a list.")
        if not numbers:
            return 0
        return sum(numbers) / len(numbers)

    # Задание 3
    # Создайте два класса: Person и Bank.
    # Класс Person должен иметь метод transfer_money, который позволяет перевести деньги в Bank.
    # Класс Bank должен иметь метод receive_money.
    # Напишите тесты, проверяющие корректность взаимодействия этих классов.
    class Person:
        def __init__(self, balance=0):
            self.balance = balance

        def transfer_money(self, amount, bank):
            if amount <= 0 or amount > self.balance:
                raise ValueError("Invalid transfer amount")
            self.balance -= amount
            bank.receive_money(amount)

    class Bank:
        def __init__(self):
            self.balance = 0

        def receive_money(self, amount):
            self.balance += amount

    # Задание 5
    # Напишите функцию divide(a, b), которая возвращает результат деления a на b.
    # Если b равно нулю, функция должна вызывать исключение ZeroDivisionError.
    # Напишите тест, который проверяет, что при попытке деления на ноль функция вызывает исключение ZeroDivisionError.

    @staticmethod
    def divide(a, b):
        if b == 0:
            raise ZeroDivisionError("Cannot divide by zero")
        return a / b

    # Задание 6
    # Напишите функцию multiply(a, b), которая возвращает произведение a и b.
    # Затем напишите параметризованный тест, который проверяет эту функцию на нескольких наборах данных.
    @staticmethod
    def multiply(a, b):
        return a * b

    # Задание 8
    # Создайте функцию square(n), которая возвращает квадрат числа n.
    # Напишите doctest, который проверяет работу этой функции.
    # python -m doctest Tasks.py # Это запуск doctest из консоли
    @staticmethod
    def square(n):
        """
        This function returns the square of a number.
        >>> Tasks.square(4)
        16
        >>> Tasks.square(0)
        0
        """
        return n ** 2

    # Задание 9
    # Напишите функцию is_prime(n), которая проверяет, является ли число n простым.
    # Простое число - это число, которое делится только на 1 и на себя.
    # Напишите параметризованный тест с использованием pytest.mark.parametrize, который проверяет эту функцию на нескольких наборах данных.
    @staticmethod
    def is_prime(n):
        """Проверяет, является ли число простым."""
        if n < 2:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True
