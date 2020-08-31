package org.inspire.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAspect {

	public Object myAroundAdice(ProceedingJoinPoint pjp) {
		Object returnValue = null;
		try {
			System.out.println("Before AroundAdvice");
			returnValue = pjp.proceed();
			System.out.println("After AroundAdvice");
		} catch (Throwable e) {
			System.out.println("After Throwing AroundAdvice");
			e.printStackTrace();
		}
		System.out.println("After Finally AroundAdvice");
		return returnValue;
	}
	
	public void loggingAdvice() {
		System.out.println("Logging from the advice");
	}
}
