package core.sff.avalon.services;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import core.sff.avalon.domain.Book;

@Transactional(propagation = Propagation.SUPPORTS)
public class AccountsServiceMockImpl implements AccountsService
{	
	public void raiseInvoice(Book requiredBook) throws CustomerCreditExcededException {
		System.out.println("Raised an invoice");
    //throw new CustomerCreditExcededException();
	}
}
