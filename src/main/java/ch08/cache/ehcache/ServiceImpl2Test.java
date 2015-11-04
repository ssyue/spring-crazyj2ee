/**
 * 
 */
package ch08.cache.ehcache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.cache.ehcache.impl.UserServiceImpl2;

/**
 * @author yuess
 *
 */
public class ServiceImpl2Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beansofehcache.xml");
		UserService service = ctx.getBean("userService2", UserService.class);

		User u1 = service.getUserByNameAndAge("ssyue", 20);// 输出
		User u2 = service.getAnotherUser("ssyue", 20);// 输出

		System.out.println(u1 == u2);// false
		User u3 = service.getAnotherUser("ssyue", 20);// 不输出
		System.out.println(u3 == u2);// true
	}

}
