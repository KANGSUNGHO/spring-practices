package com.bit2020.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public com.bit2020.aoptest.vo.ProductVo com.bit2020.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("----- before advice -----"); // what
		
	}
	

	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("----- after advice -----"); // what
		
	}
	
	@AfterReturning("execution(* *..*.service.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("----- afterReturning advice -----"); // what
		
	}

	@AfterThrowing(value="execution(* *..*.service.ProductService.*(..))",throwing="ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("----- afterThrowing advice -----" + ex); // what
		
	}
	
	@Around("execution(* *..*.service.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		
		// before advice
		System.out.println("----- @Arround(before) Advice -----"); // what
		
		Object result = pjp.proceed();
		// after advice
		System.out.println("----- @Arround(after) Advice -----"); // what
	
		return result;
	}
}

