package core.sff.avalon.client;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.avalon.data.BookNotFoundException;
import core.sff.avalon.domain.Book;
import core.sff.avalon.services.AccountsService;
import core.sff.avalon.services.BookService;
import core.sff.avalon.services.CustomerCreditExcededException;
import core.sff.avalon.services.PurchasingService;

public class Client {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("appTransactionAnnotation.xml");

    try {
      PurchasingService purchasing = container.getBean(PurchasingService.class);	
      BookService bookService = container.getBean(BookService.class);

      // begin
      //bookService.registerNewBook(new Book("100039939369", "Test Title", "Author", 10.99));
      // commit
      
      // begin
      try {
        purchasing.buyBook("100039939369");
      } catch (BookNotFoundException e) {
        System.out.println("Sorry, that book doesn't exist");
      } catch (CustomerCreditExcededException e) {
      		System.out.println("Sorry, you can't afford it. Go away!");
      }
      // commit

    } finally {
    		container.close();
    }
  }
}
 
