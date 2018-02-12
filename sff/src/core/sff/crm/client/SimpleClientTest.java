package core.sff.crm.client;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Collection;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.crm.domain.Action;
import core.sff.crm.domain.Call;
import core.sff.crm.domain.Customer;
import core.sff.crm.services.calls.CallHandlingService;
import core.sff.crm.services.customers.CustomerManagementService;
import core.sff.crm.services.customers.CustomerNotFoundException;
import core.sff.crm.services.diary.DiaryManagementService;

public class SimpleClientTest {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("appCRMAnnotations.xml");

    CustomerManagementService customerService = container.getBean(CustomerManagementService.class);
    CallHandlingService callService = container.getBean(CallHandlingService.class);
    DiaryManagementService diaryService = container.getBean(DiaryManagementService.class);

    try {
      Customer foundCustomer = customerService.findCustomerById("CS03939");
      foundCustomer.setTelephone("6467537683");
      foundCustomer.setEmail("run@gmail.com");
      customerService.updateCustomer(foundCustomer);
      customerService.deleteCustomer(foundCustomer);
    } catch (CustomerNotFoundException e) {
      System.out.println("Sorry, that customer couldn't be found.");
    }

    Call newCall = new Call("Larry Wall called from Acme Corp");

    Action action1 = new Action("Call back Larry to ask how things are going", new GregorianCalendar(2016, 0, 0), "run");
    Action action2 = new Action("Check out sales dept to make sure Larry is being tracked", new GregorianCalendar(2016, 5, 4), "run");

    List<Action> actions = new ArrayList<>();
    actions.add(action1);
    actions.add(action2);

    try {
      callService.recordCall("CS03939", newCall, actions);
    } catch (CustomerNotFoundException e) {
      System.out.println("That customer doesn't exist");
    }

    System.out.println("Here are the outstanding actions: ");
    Collection<Action> incompleteActions = diaryService.getAllIncompleteActions("run");
    for (Action next: incompleteActions) {
      System.out.println(next);
    }

    container.close();

  }
}
