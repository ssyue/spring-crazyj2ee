package ch08.cache.evict;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch08.cache.ehcache.User;


public class SpringTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beansofehcache.xml");

		UserService us = ctx.getBean("userService3", UserService.class);
		// 调用us对象的2个带缓存的方法，系统会缓存两个方法返回的数据
		User u1 = us.getUserByNameAndAge("孙悟空", 500);
		User u2 = us.getAnotherUser("猪八戒", 400);
		// 调用evictUser()方法清除缓存中指定的数据
		us.evictUser("猪八戒", 400);
		// 由于前面根据"猪八戒", 400缓存的数据已经被清除了，
		// 因此下面代码会重新执行，方法返回的数据将被再次缓存。
		User u3 = us.getAnotherUser("猪八戒", 400); // ①
		System.out.println(u2 == u3); // 输出false
		// 由于前面前面已经缓存了参数为"孙悟空", 500的数据，
		// 因此下面代码不会重新执行，直接利用缓存中的数据。
		User u4 = us.getAnotherUser("孙悟空", 500); // ②
		System.out.println(u1 == u4); // 输出true
		// 清空整个缓存。
		us.evictAll();
		// 由于整个缓存都已经被清空，因此下面两行代码都会重新执行
		User u5 = us.getAnotherUser("孙悟空", 500);
		User u6 = us.getAnotherUser("猪八戒", 400);
		System.out.println(u1 == u5); // 输出false
		System.out.println(u3 == u6); // 输出false

		ctx.close();
	}

}
