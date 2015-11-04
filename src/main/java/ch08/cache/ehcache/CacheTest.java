package ch08.cache.ehcache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheTest {
	public static void main(String[] agrs){
			ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beansofehcache.xml");
			UserService userService=ctx.getBean(UserService.class);
			//UserServiceImpl上注解为　@Cacheable(value="users")// 指定类的缓存区为名为users的缓存区
			//name,age必须相同
			/*User user1=userService.getUserByNameAndAge("ssyue", 22);//输出
			User user2=userService.getUserByNameAndAge("ssyue", 22);//不输出
			User user3=userService.getAnotherUser("ssyue", 22);//不输出
			//all true
			System.out.println(user1==user2);
			System.out.println(user3==user2);*/
			ctx.close();
			testKey();
	}
		static void  testKey(){
			ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beansofehcache.xml");
			UserService userService=ctx.getBean(UserService.class);
			//UserServiceImpl上注解为　@Cacheable(value="users", key="#name")// 指定了key属性,表示当name参数值相同时，就会使用到Spring缓存
			//忽略age,name相同则缓存
			User user1=userService.getUserByNameAndAge("ssyue", 22);//输出
			User user2=userService.getUserByNameAndAge("ssyue", 23);//不输出
			User user3=userService.getAnotherUser("ssyue", 24);//不输出
			//all true
			System.out.println(user1==user2);
			System.out.println(user3==user2);
			ctx.close();
		}
	
}
