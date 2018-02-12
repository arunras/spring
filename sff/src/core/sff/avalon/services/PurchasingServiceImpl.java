package core.sff.avalon.services;

import org.springframework.transaction.annotation.Transactional;

import core.sff.avalon.data.BookNotFoundException;
import core.sff.avalon.domain.Book;

@Transactional
public class PurchasingServiceImpl implements PurchasingService {
  private AccountsService accounts;
  private BookService books;

  public PurchasingServiceImpl(AccountsService accountsService, BookService bookService) {
    this.accounts = accountsService;
    this.books = bookService;
  }

  public void buyBook(String isbn) throws BookNotFoundException {
    // Find the correct book
    Book requiredBook = books.getBookByIsbn(isbn);

    // delete the book from stock
    books.deleteFromStock(requiredBook);

	  // Now raise the invoice
	  accounts.raiseInvoice(requiredBook);
  }
}
