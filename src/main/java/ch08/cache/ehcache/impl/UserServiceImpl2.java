package ch08.cache.ehcache.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ch08.cache.ehcache.User;
import ch08.cache.ehcache.UserService;

@Service("userService2")
public class UserServiceImpl2 implements UserService {

	@Cacheable(value = "users1")
	@Override
	public User getUserByNameAndAge(String name, int age) {
		System.out.println("---正在执行getUserByNameAndAge()查询方法---");
		return new User(name, age);
	}

	@Cacheable(value = "users2")
	@Override
	public User getAnotherUser(String name, int age) {
		System.out.println("---正在执行getAnotherUser()查询方法---");
		return new User(name, age);
	}

}
