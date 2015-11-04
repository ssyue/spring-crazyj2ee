package ch08.transaction01.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beansoftransaction01.xml");
		NewsDao dao=ctx.getBean("newsDaoTrans",NewsDao.class);
		dao.insert("yue","shun");
	}

}
