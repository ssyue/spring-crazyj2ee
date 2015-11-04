package ch08.cache.ehcache;


public interface UserService {

	User getUserByNameAndAge(String name, int age);
	
	User getAnotherUser(String name, int age);
	
}
