//Задание №6
//        Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
//        Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
//        Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
//        выполнения запроса и обработки результатов.


import database.DataProcessor;
import database.Database;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DataProcessorTest {

    @Test
    void checkDataTest() {
        Database databaseMock = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(databaseMock);
        when(databaseMock.query(anyString())).thenReturn(Arrays.asList("Data1", "Data1", "Data1"));

        List<String> result = dataProcessor.processData("запрос");

        verify(databaseMock).query("запрос");
        assertThat(result).hasSize(3);
    }
}
