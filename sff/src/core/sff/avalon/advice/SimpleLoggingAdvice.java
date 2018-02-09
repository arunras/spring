package core.sff.avalon.advice;

import java.util.List;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.AfterReturningAdvice;


public class SimpleLoggingAdvice implements AfterReturningAdvice {
  @Override
  public void afterReturning(Object returnValue, Method method, Object[] arguments, Object targetObject) throws Throwable {
    if (returnValue instanceof List) {
      List returnList = (List) returnValue;
      returnList.clear();
    }
    System.out.println("Now finished calling the " + method.getName() + " method");
    System.out.println("The target method returning the value : " + returnValue);
  }

  // for MethodBeforeAdvice Interface
  public void before(Method method, Object[] arguments, Object targetObject) throws Throwable{
    System.out.println("Now about to call the " + method.getName() + " method");
  }
}
