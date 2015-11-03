package ch08.aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAdviceTest {
	@Before("execution(* ch08.aop.advice.impl.Chinese.*(..))")
	public void test(){
		System.out.println("test down");
	}
}
