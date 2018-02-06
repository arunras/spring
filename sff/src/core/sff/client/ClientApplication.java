package core.sff.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.sff.motd.MessageOfTheDayService;

public class ClientApplication {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
    MessageOfTheDayService helloWorld = container.getBean("motdMessage", MessageOfTheDayService.class);

    System.out.print(helloWorld.getTodaysMessage());
    container.close();
  }
}
