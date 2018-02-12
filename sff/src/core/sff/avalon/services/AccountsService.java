package core.sff.avalon.services;

import core.sff.avalon.domain.Book;

public interface AccountsService 
{
	public void raiseInvoice(Book requiredBook) throws CustomerCreditExcededException;
}
