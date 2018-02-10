package core.sff.crm.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceTimingAdvice {
  private static final int NANOSECOND_IN_A_MILLISECOND = 1_000_000;
  public Object recordTiming(ProceedingJoinPoint jp) throws Throwable {
    double timeNow = System.nanoTime(); 
    try { 
      Object returnValue = jp.proceed();
      return returnValue;
    } finally {
      double timeAfter = System.nanoTime();
      double timeTaken = timeAfter - timeNow;
      double timeInMilliseconds = timeTaken / NANOSECOND_IN_A_MILLISECOND;
      System.out.println("Time taken for the method: " + jp.getSignature().getName() + " from class " +
         jp.getTarget().getClass().getSimpleName() + " took " + timeInMilliseconds +"ms");
    }
  }
}
