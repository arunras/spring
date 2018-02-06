package core.sff.crm.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.crm.domain.Customer;
import core.sff.crm.services.customers.CustomerManagementService;

public class SimpleClientTest {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationCRM.xml");

    CustomerManagementService customerService = container.getBean(CustomerManagementService.class);

    List<Customer> allCustomers = customerService.getAllCustomers();

    for (Customer next: allCustomers) {
      System.out.println(next);
    }

    container.close();
  }
}
