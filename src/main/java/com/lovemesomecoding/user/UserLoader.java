package com.lovemesomecoding.user;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.utils.ObjectUtils;

@Component
public class UserLoader {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		User user = new User();
		user.setEmail("folaukaveinga@gmail.com");
		user.setAge(3);
		user.setName("Folau");
		
		User savedUser = userRepository.save(user);
		
		log.info("user:{}", ObjectUtils.toJson(user));
		log.info("savedUser:{}", ObjectUtils.toJson(savedUser));
		
		
		User user1 = new User();
		
		user1.setAge(13);
		user1.setName("Folau template");
		mongoTemplate.insert(user1);
		
		// save if id doesn't exist
		// update if id exists
		user1.setId("5d400c8b1dab0ae965ad8152");
		mongoTemplate.save(user1);
	}
}
