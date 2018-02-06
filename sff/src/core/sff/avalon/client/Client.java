package core.sff.avalon.client;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.avalon.domain.Book;
import core.sff.avalon.services.BookService;

public class Client {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

    BookService service = container.getBean(BookService.class);
    List<Book> allBooks = service.getEntireCatalogue();

    for (Book book: allBooks) {
      System.out.println(book);
    }
  }
}
