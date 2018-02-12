package core.sff.avalon.services;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import core.sff.avalon.data.BookDao;
import core.sff.avalon.data.BookNotFoundException;
import core.sff.avalon.domain.Book;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceProductionImpl implements BookService {
  private BookDao dao;

  public BookServiceProductionImpl(BookDao dao) {
    this.dao = dao;
  }

  @Override
  public List<Book> getAllBooksByAuthor(String author) {
    return dao.findBooksByAuthor(author);
  }

  @Override
  public List<Book> getAllRecommendedBooks(String userId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Book getBookByIsbn(String isbn) throws BookNotFoundException{
    return dao.findBookByIsbn(isbn);
  }

  @Override
  public List<Book> getEntireCatalogue() {
    return dao.allBooks();
  }

  @Override
  public void registerNewBook(Book newBook) {
    dao.create(newBook);
  }

  @Override
  public void deleteFromStock(Book oldBook) {
    dao.delete(oldBook);
  }
}
