package com.ticktask.springboot.webapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.ticktask.springboot.webapp.entity.User;
import com.ticktask.springboot.webapp.repositories.UserRepository;


@DataJpaTest 
@AutoConfigureTestDatabase(replace = Replace.NONE) // test with real database
@Rollback (false)
//test Repository layer
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("john@gmail.com");
		user.setPassword("345");
		user.setFirstname("john");
		user.setLastname("dep");
		
	User savedUser = repo.save(user);
	User existUser = entityManager.find(User.class, savedUser.getId());
	assertThat(existUser.getEmail()).isEqualTo(existUser.getEmail());
	
		
	}

}
