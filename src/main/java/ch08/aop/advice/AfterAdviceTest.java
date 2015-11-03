package ch08.aop.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterAdviceTest {
	@After("execution(* ch08.aop.advice.impl.Chinese.*(..))")
	public void release(){
		System.out.println("after release");
	}
	
	
}
