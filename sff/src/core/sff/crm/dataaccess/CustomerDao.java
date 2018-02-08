package core.sff.crm.dataaccess;

import java.util.List;

import core.sff.crm.domain.Call;
import core.sff.crm.domain.Customer;

// FOR USE IN A LATER CHAPTER - PLEASE IGNORE UNTIL THEN

public interface CustomerDao 
{
	public void create(Customer customer);
	public Customer getById(String customerId) throws RecordNotFoundException;
	public List<Customer> getByName(String name);
	public void update(Customer customerToUpdate) throws RecordNotFoundException;
	public void delete(Customer oldCustomer) throws RecordNotFoundException;
	public List<Customer> getAllCustomers();
	public Customer getFullCustomerDetail(String customerId) throws RecordNotFoundException;
	public void addCall (Call newCall, String customerId) throws RecordNotFoundException;
}
