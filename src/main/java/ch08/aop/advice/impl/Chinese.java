package ch08.aop.advice.impl;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

@Component
public class Chinese {
	@SuppressWarnings("resource")
	public String sayhello(String name){
		System.out.println("hello "+name);
		try {
			new java.io.FileInputStream("xx.xml");
		} catch (FileNotFoundException e) {
			System.out.println("找不到对象");
		}
		return "hello "+name;
	}
	public String saybye(String name){
		System.out.println("bye "+name);
		return "bye "+name;
	}
	public void divide(){
		int a=1/0;
		System.out.println("divide=== 1/0");
	}
}
