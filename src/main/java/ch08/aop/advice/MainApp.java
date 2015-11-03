/**
 * 
 */
package ch08.aop.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.aop.advice.impl.Chinese;

/**
 * @author yuess
 *
 */
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beansAOP.xml");
		Chinese c=ctx.getBean(Chinese.class);
		c.sayhello("yuess");
		c.saybye("yuess");
		c.divide();
	}
}
