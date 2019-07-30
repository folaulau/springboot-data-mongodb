package com.lovemesomecoding.user;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.order.OrderRepository;
import com.lovemesomecoding.utils.ObjectUtils;
import com.lovemesomecoding.utils.RandomGeneratorUtils;

@Component
public class UserLoader {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@PostConstruct
	public void init() {
		User user = new User();
		user.setEmail("folaukaveinga+" + RandomGeneratorUtils.getIntegerWithin(0, 100000) + "@gmail.com");
		user.setAge(3);
		user.setName("Folau");

		Address address = new Address();
		address.setStreet("4849 111th st");
		user.setAddress(address);
		
		Order order = new Order();
		order.setSubmittedAt(new Date());
		order.setTotal(RandomGeneratorUtils.getDoubleWithin(0.1, 1000000.0));
		
		order = orderRepository.save(order);
		
		user.addOrder(order);

		User savedUser = userRepository.save(user);

		log.info("user:{}", ObjectUtils.toJson(user));
		log.info("savedUser:{}", ObjectUtils.toJson(savedUser));

		// User user1 = new User();
		//
		// user1.setAge(13);
		// user1.setName("Folau template");
		// mongoTemplate.insert(user1);
		//
		// // save if id doesn't exist
		// // update if id exists
		// user1.setId("5d400c8b1dab0ae965ad8152");
		// mongoTemplate.save(user1);
		
		
		

		Pageable pageableRequest = PageRequest.of(0, 15);

		Page<User> page = userRepository.findAll(pageableRequest);

		log.info("users:{}", ObjectUtils.toJson(page.getContent()));
		
		

	}
}
