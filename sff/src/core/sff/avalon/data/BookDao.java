package core.sff.avalon.data;

import java.util.List;

import core.sff.avalon.domain.Book;

public interface BookDao {
  public void create(Book newBook);
  public void delete(Book redundantBook);
  public List<Book> allBooks();
  public List<Book> findBooksByAuthor(String author);
  public Book findBookByIsbn(String isbn);
}
