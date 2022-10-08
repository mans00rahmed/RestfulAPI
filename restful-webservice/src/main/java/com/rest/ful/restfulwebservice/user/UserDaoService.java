package com.rest.ful.restfulwebservice.user;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
	// JPA/H2 > Database
	// UserDaoService > Static List
	
	private static List<User> users = new ArrayList<>();
		
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(3,"Jim",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		//used functional programming
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		//used functional programming
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
}
