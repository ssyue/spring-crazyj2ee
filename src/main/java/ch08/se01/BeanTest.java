package ch08.se01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import ch08.se01.service.Person;
import ch08.se01.service.impl.MyProfessor;

public class BeanTest {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
/*	ctx = new ClassPathXmlApplicationContext("beans08se01.xml");
		// 获取名为person的bean
		Person p = ctx.getBean("chinese", Person.class);
		p.useAxe();*/
		//test();
		testPlaceHolder();
	}
	public static void test(){
		ClassPathResource isr=new ClassPathResource("beans08se01.xml");
		XmlBeanFactory factory=new XmlBeanFactory(isr);
		MyProfessor p=factory.getBean("myprofessor", MyProfessor.class);
		factory.addBeanPostProcessor(p);
		
		System.out.println("begin");
		Person person=factory.getBean("chinese", Person.class);
		System.out.println("down");
		person.useAxe();	
	}

	public static void testPlaceHolder() {
		ctx = new ClassPathXmlApplicationContext("beans08se01placeholder.xml");	
		DataSource data=	(DataSource) ctx.getBean("dataSource");
		try {
			Connection c=data.getConnection();
			 ResultSet r=c.prepareStatement("select * from user").executeQuery();	
			while(r.next()){
				System.out.println(r.getString(4)+r.getString(1)+r.getInt(2)+r.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(data.toString());
	}
}
