package core.sff.avalon.services;

import core.sff.avalon.data.BookNotFoundException;
import core.sff.avalon.domain.Book;

public class PurchasingServiceImpl implements PurchasingService {
  private AccountsService accounts;
  private BookService books;

  public PurchasingServiceImpl(AccountsService accountsService, BookService bookService) {
    this.accounts = accountsService;
    this.books = bookService;
  }

  public void buyBook(String isbn) {
    // Find the correct book
    Book requiredBook;
		try {
			requiredBook = books.getBookByIsbn(isbn);
	    // Now raise the invoice
	    accounts.raiseInvoice(requiredBook);
		} catch (BookNotFoundException e) {
			System.out.println("Book not found");
		}
  }
}
