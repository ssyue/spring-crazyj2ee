package ch08.cache.ehcache.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ch08.cache.ehcache.User;
import ch08.cache.ehcache.UserService;
//指定类的缓存区为名为users的缓存区
//@Cacheable(value="users")
//@Cacheable(value="users", condition="#age<100")// 指定了condition属性，表示只有在复合某些条件情况下才使用缓存
@Cacheable(value="users", key="#name")// 指定了key属性,表示当name参数值相同时，就会使用到Spring缓存
@Service("userService")
public class UserServiceImpl  implements UserService{
	@Override
	
	public User getUserByNameAndAge(String name, int age) {
		System.out.println("---正在执行getUserByNameAndAge()查询方法---");
		return new User(name,age);
	}
	@Override
	public User getAnotherUser(String name, int age) {
		System.out.println("---正在执行getAnotherUser()查询方法---");
		return new User(name,age);
	}
}
