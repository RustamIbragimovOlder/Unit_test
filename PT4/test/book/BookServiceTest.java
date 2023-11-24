package book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;
class BookServiceTest {

    private BookRepository bookRepositoryMock;

    private BookService bookService;


    @BeforeEach
    void setUp() {

        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);

    }

    @Test
    void findBookByIdTest() {

        when(bookService.findBookById("10")).thenReturn(new Book("10"));

        assertEquals("10", bookService.findBookById("10").getId());

    }

    @Test
    public void findAllBooksTest() {

        when(bookRepositoryMock.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Book("1"), new Book("2"), new Book("3"))));

        assertThat(bookService.findAllBooks()).hasSize(3);
    }
}