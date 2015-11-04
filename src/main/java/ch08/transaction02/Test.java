package ch08.transaction02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.transaction01.dao.NewsDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beansoftransaction2.xml");
		NewsDao dao=ctx.getBean("newsDao",NewsDao.class);
		dao.insert("yue","shun");
	}

}
