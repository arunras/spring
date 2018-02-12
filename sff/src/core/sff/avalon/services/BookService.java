package core.sff.avalon.services;

import java.util.List;

import core.sff.avalon.data.BookNotFoundException;
import core.sff.avalon.domain.Book;

public interface BookService {
  public List<Book> getAllBooksByAuthor(String author);
  public List<Book> getAllRecommendedBooks(String userId);
  public Book getBookByIsbn(String isbn) throws BookNotFoundException;
  public List<Book> getEntireCatalogue();
  public void registerNewBook(Book newBook);
  public void deleteFromStock(Book oldBook);
}
