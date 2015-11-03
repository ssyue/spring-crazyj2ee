package ch08.aop.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningAdviceTest {
	@AfterReturning(returning="arg1",pointcut="execution(* ch08.aop.advice.impl.Chinese.*(..))")
	public void log(Object arg1){
		System.out.println("获取目标方法返回值 "+arg1);
		System.out.println("模拟日志");
	}
}
