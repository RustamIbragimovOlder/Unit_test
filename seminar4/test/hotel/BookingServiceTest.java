// Задание №4
        // Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
        // Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
        // который обычно проверяет, доступен ли номер в отеле.
        // Вам необходимо проверить правильность работы класса BookingService, который
        // использует HotelService для бронирования номера, если он доступен.

import hotel.BookingService;
import hotel.HotelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingServiceTest {

    private HotelService checkRoomMock;
    private BookingService bookingService;

    @BeforeEach
        void setUp() {

        checkRoomMock = mock(HotelService.class);
        bookingService = new BookingService(checkRoomMock);

    }

    @Test
    void checkEvenRoomBookingServiceTest() {

        when(checkRoomMock.isRoomAvailable(24)).thenReturn(true);

        boolean result = bookingService.bookRoom(24);

        assertTrue(result);

    }

    @Test
    void checkOddRoomBookingServiceTest() {

        when(checkRoomMock.isRoomAvailable(25)).thenReturn(false);

        boolean result = bookingService.bookRoom(25);

        assertFalse(result);

    }
}
