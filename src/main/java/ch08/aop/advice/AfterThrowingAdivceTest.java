package ch08.aop.advice;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAdivceTest {
	@AfterThrowing(throwing="ex",pointcut="execution(* ch08.aop.advice.impl.Chinese.*(..))")
	public void doexception(Throwable ex){
		System.out.println("AfterThrowingAdivceTest 处理异常"+ex);
	}
}
