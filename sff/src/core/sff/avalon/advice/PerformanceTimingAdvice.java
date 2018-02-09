package core.sff.avalon.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceTimingAdvice implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation method) throws Throwable {
    // before
    long startTime = System.nanoTime();

    try {
	    // proceed to target
	    Object returnValue = method.proceed();
	    return returnValue;
	  } finally {
	    // after
	    long endTime = System.nanoTime();
	    long timeTaken = endTime - startTime;
	
	    System.out.println("The method " + method.getMethod().getName() + " took " + timeTaken + " nanosecond");
    }
  }

}
