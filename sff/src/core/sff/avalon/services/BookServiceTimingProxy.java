package core.sff.avalon.services;

import java.util.List;

import core.sff.avalon.data.BookNotFoundException;
import core.sff.avalon.domain.Book;
import core.sff.avalon.services.BookService;

public class BookServiceTimingProxy implements BookService {
  private BookService originalBookService;
  
  public void setOriginalBookService(BookService originalBookService) {
  		this.originalBookService = originalBookService;
  }

  @Override
  public List<Book> getAllBooksByAuthor(String author) {
    long nanoSecondsInAMillisecond = 1_000_000;
    long timeThen = System.nanoTime();
    List<Book> allBooks = originalBookService.getEntireCatalogue();


    long timeNow = System.nanoTime();
    long timeTaken = timeNow - timeThen;
    System.out.println("getEntireCatalogue took " + timeTaken / nanoSecondsInAMillisecond + " milliseconds");
    return null;
  }

  @Override
  public List<Book> getAllRecommendedBooks(String userId) {
    long nanoSecondsInAMillisecond = 1_000_000;
    long timeThen = System.nanoTime();
    List<Book> allBooks = originalBookService.getEntireCatalogue();



    long timeNow = System.nanoTime();
    long timeTaken = timeNow - timeThen;
    System.out.println("getEntireCatalogue took " + timeTaken / nanoSecondsInAMillisecond + " milliseconds");
    return null;
  }

  @Override
  public Book getBookByIsbn(String isbn) throws BookNotFoundException {
    long nanoSecondsInAMillisecond = 1_000_000;
    long timeThen = System.nanoTime();

    try {
      Book foundBook = originalBookService.getBookByIsbn(isbn);
      return foundBook;
    } finally {

      long timeNow = System.nanoTime();
      long timeTaken = timeNow - timeThen;
      System.out.println("getBookByIsbn took " + timeTaken / nanoSecondsInAMillisecond + " milliseconds");
    }
  }

  @Override
  public List<Book> getEntireCatalogue() {
    long nanoSecondsInAMillisecond = 1_000_000;

    // start the clock
    long timeThen = System.nanoTime();

    // do the work, but how?
    List<Book> allBooks = originalBookService.getEntireCatalogue();

    // stop the clock
    long timeNow = System.nanoTime();

    // report (actually would be done using a logger)
    long timeTaken = timeNow - timeThen;
    System.out.println("getEntireCatalogue took " + timeTaken / nanoSecondsInAMillisecond + " milliseconds");

    // get out
    return allBooks;
  }

  @Override
  public void registerNewBook(Book newBook) {
    long nanoSecondsInAMillisecond = 1_000_000;
    long timeThen = System.nanoTime();
    List<Book> allBooks = originalBookService.getEntireCatalogue();

    originalBookService.registerNewBook(newBook);

    long timeNow = System.nanoTime();
    long timeTaken = timeNow - timeThen;
    System.out.println("registerNewBook took " + timeTaken / nanoSecondsInAMillisecond + " milliseconds");
  }
}
