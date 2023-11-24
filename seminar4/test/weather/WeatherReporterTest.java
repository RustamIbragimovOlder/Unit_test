// Задание №3
        // Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
        // обращающийся к внешнему API для получения информации о текущей температуре.
        // Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
        // Создайте мок-объект для WeatherService с использованием Mockito.

import org.junit.jupiter.api.Test;
import weather.WeatherReporter;
import weather.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherReporterTest {

    @Test
    void weatherTest() {

        WeatherService serviceMock = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(serviceMock);

        when(serviceMock.getCurrentTemperature()).thenReturn(25);
        String result = weatherReporter.generateReport();

        assertEquals("Текущая температура: " + 25 + " градусов.", result);
    }
}
