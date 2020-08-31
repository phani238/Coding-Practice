package org.inspire.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

//	@Before("execution(public String org.inspire.aop.model.Circle.getName())")
//	@Before("execution(public String getName())")
//	@Before("execution(public * get*(*))") //for only single parameter methods 
//	@Before("execution(public * get*(..))")// for zero or more parameters
//	@Before("execution(public * get*())")
//	@Before("allGetters() && allCircleMethods()")
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {
//		Circle circle = (Circle) joinPoint.getTarget();
//		System.out.println(joinPoint.getTarget());
	}

//	@Before("args(String)")
	@Before("args(name)")
	public void stringArgumentsMethods(String name) {
		System.out.println("A method that takes String Arguments has been called. The value is: '" + name + "'");
	}

	/*
	 * @Before("allGetters()") public void SecondAdvice() {
	 * System.out.println("Second Adivce Ececuted"); }
	 */

	@Pointcut("execution(public * get*())")
	public void allGetters() {
	}
	
//	@Pointcut("execution(* org.inspire.aop.*Service.*(..))")

//	@Pointcut("execution(* * org.inspire.aop.model.Circle.*(..))")
//	@Pointcut("within(org.inspire.aop.model.*)")
//	@Pointcut("within(org.inspire.aop.model..*)")
	@Pointcut("within(org.inspire.aop.model.Circle)")
	public void allCircleMethods() {
	}

//	@After("args(name)")
	@AfterReturning(pointcut = "args(name)", returning = "returnSting")
	public void stringAfterArgumentsMethods(String name, Object returnSting) {
		// public void stringAfterArgumentsMethods(String name, String returnSting) {
		System.out.println(
				"After has been called. The Value is: '" + name + "'. The output value is: '" + returnSting + "'");
	}

//	@AfterThrowing("args(name)")
	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void execeptionAdvice(String name, RuntimeException ex) {
		System.out.println("Testing AspectExceptionHandling " + ex);
	}

	
//	@Around("allGetters()")
//	@Around("@annotation(org.inspire.aop.aspect.Loggable)")
	@Around("allGetters()")
	public Object myAroundAdive(ProceedingJoinPoint pjp) {
//		public void myAroundAdive(ProceedingJoinPoint pjp) {
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
}
