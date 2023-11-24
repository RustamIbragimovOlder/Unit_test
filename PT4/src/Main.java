import book.Book;
import book.BookRepository;
import book.BookService;
import book.InMemoryBookRepository;

import java.util.List;

public class Main {

    /*
     * HW4.2. У вас есть класс BookService, который использует интерфейс BookRepository
     * для получения информации о книгах из базы данных.
     *  Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
     * */
    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService bookService = new BookService(repository);

        Book book1 = bookService.findBookById("1");
        System.out.println("Найдена книга: " + book1.getTitle() + " by " + book1.getAuthor());

        List<Book> allBooks = bookService.findAllBooks();
        System.out.println("Все книги:");
        for (Book book : allBooks) {
            System.out.println("- " + book.getTitle() + " от " + book.getAuthor());
        }
    }
}