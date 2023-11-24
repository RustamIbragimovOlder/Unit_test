//Задание №5
//        Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
//        Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
//        recipient), который отправляет сообщение получателю.
//        Вам необходимо проверить правильность работы класса NotificationService, который использует
//        MessageService для отправки уведомлений.


import message.MessageService;
import message.NotificationService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotificationServiceTest {

    @Test
    void checkMessage() {
        MessageService messageServiceMock = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageServiceMock);

        notificationService.sendNotification("это сообщение", "для Рустама");

        verify(messageServiceMock).sendMessage("это сообщение", "для Рустама");

    }
}
