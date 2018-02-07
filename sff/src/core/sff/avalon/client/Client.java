package core.sff.avalon.client;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.avalon.domain.Book;
import core.sff.avalon.services.BookService;
import core.sff.avalon.services.PurchasingService;

public class Client {
  public static void main(String[] args) {
    System.out.println("Testing buying a book....");
    String requiredIsbn = "ISBN1";
 
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationBookService.xml");

    PurchasingService purchasing1 = container.getBean(PurchasingService.class);
    PurchasingService purchasing2 = container.getBean(PurchasingService.class);
    PurchasingService purchasing3 = container.getBean(PurchasingService.class);
    PurchasingService purchasing4 = container.getBean(PurchasingService.class);
    PurchasingService purchasing5 = container.getBean(PurchasingService.class);
    PurchasingService purchasing6 = container.getBean(PurchasingService.class);

    purchasing1.buyBook(requiredIsbn);

    container.close();
    /*
    //BookService service = container.getBean(BookService.class);
    //List<Book> allBooks = service.getEntireCatalogue();

    for (Book book: allBooks) {
      System.out.println(book);
    }
    */
  }
}
