package core.sff.avalon.services;

import core.sff.avalon.data.BookNotFoundException;

public interface PurchasingService 
{
	public void buyBook(String isbn) throws BookNotFoundException, CustomerCreditExcededException;
}