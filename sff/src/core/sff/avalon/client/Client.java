package core.sff.avalon.client;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.avalon.domain.Book;
import core.sff.avalon.services.BookService;
import core.sff.avalon.services.PurchasingService;

public class Client {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationBookService.xml");

    BookService bookService = container.getBean(BookService.class);

    bookService.registerNewBook(new Book("2384928389223", "War and Peace", "Leo Tolstoy", 10.99));

    List<Book> allBooks = bookService.getEntireCatalogue();

    for (Book next: allBooks) {
      System.out.println(next);
    }

    container.close();
  }
}
