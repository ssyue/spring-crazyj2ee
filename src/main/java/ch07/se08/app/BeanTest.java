package ch07.se08.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch07.se09.service.Person;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beanse08.xml");
		Person p = ctx.getBean("chinese", Person.class);
		p.useAxe();
		p.useAxe();
		Person p2 = ctx.getBean("chinese", Person.class);
		System.out.println(p==p2);
		System.out.println(ctx.getBean("&chinese"));
	}
}
