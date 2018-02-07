package core.sff.avalon.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import core.sff.avalon.domain.Book;

public class BookDaoCleanerJdbcImpl implements BookDao {
  private JdbcTemplate jdbcTemplate;

  // SQL
	private static final String INSERT_BOOK_SQL = "insert into BOOK (ISBN, TITLE, AUTHOR,PRICE) values (?, ?, ?, ?) ";
	private static final String CREATE_TABLE_SQL = "create table BOOK(ISBN VARCHAR(20), TITLE VARCHAR(50), AUTHOR VARCHAR(50), PRICE DOUBLE)";
	private static final String GET_ALL_BOOKS_SQL = "select * from BOOK";

  public BookDaoCleanerJdbcImpl(JdbcTemplate template) {
    this.jdbcTemplate = template;
  }

  public void createTables() {
    // TODO: impove this try block
    try {
      jdbcTemplate.update(CREATE_TABLE_SQL);
    } catch (Exception e) {
      System.out.println("Assuming that table alread exists");
    }

  }

  @Override
  public List<Book> allBooks() {
    return jdbcTemplate.query(GET_ALL_BOOKS_SQL, new BookMapper());
  }

  @Override
  public Book findBookByIsbn(String isbn) {
    return jdbcTemplate.queryForObject("SELECT * FROM Book WHERE isbn=?", new BookMapper(), isbn);
  }

  @Override
  public void create(Book newBook) {
    jdbcTemplate.update(INSERT_BOOK_SQL, new Object[] {newBook.getIsbn(), newBook.getTitle(), newBook.getAuthor(), newBook.getPrice()});
  }

  @Override
  public void delete(Book redundantBook) {
    jdbcTemplate.update("DELETE FROM Book WHERE isbn=?", redundantBook.getIsbn()); 
  }

  @Override
  public List<Book> findBooksByAuthor(String author) {
    return jdbcTemplate.query("SELECT * FROM Book WHERE author=?", new BookMapper(), author);
  }
}

class BookMapper implements RowMapper<Book> {
  @Override
  public Book mapRow(ResultSet rs, int rowNumber) throws SQLException {
    String isbn = rs.getString("ISBN");
    String title = rs.getString("TITLE");
    String author = rs.getString("AUTHOR");
    double price = rs.getDouble("PRICE");

    Book theBook = new Book(isbn, title, author, price);
    return theBook;
  }
}







