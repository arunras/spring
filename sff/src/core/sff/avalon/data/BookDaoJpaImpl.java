package core.sff.avalon.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import core.sff.avalon.domain.Book;

public class BookDaoJpaImpl implements BookDao {
  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Book> allBooks() {
    return em.createQuery("select book from Book as book").getResultList();
  }

  @Override
  public Book findBookByIsbn(String isbn) throws BookNotFoundException {
    return (Book) em.createQuery("select book from Book as book where book.isbn=:isbn").setParameter("isbn", isbn).getSingleResult();
  }

  @Override
  public void create(Book newBook) {
    em.persist(newBook);
  }

  @Override
  public void delete(Book redundantBook) {
    Book book = em.find(Book.class, redundantBook.getIsbn());
    em.remove(book);
  }

  @Override
  public List<Book> findBooksByAuthor(String author) {
    return em.createQuery("select book from Book as book where book.author=:author").setParameter("author", author).getResultList();
  }
}


