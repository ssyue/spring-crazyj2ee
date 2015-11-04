package ch08.cache.evict;

import ch08.cache.ehcache.User;

public interface UserService {

	User getUserByNameAndAge(String name, int age);
	
	User getAnotherUser(String name, int age);

	void evictUser(String name, int age);
	
	void evictAll();
	
}
