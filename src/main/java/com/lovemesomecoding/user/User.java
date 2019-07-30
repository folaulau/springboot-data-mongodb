package com.lovemesomecoding.user;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.order.Order;

@Document
public class User {

	@Id
	private String id;
	
	private String name;
	
	@NotEmpty
	@Field
	@Indexed(unique=true)
	private String email;
	
	private Address address;
	
	private int age;
	
	private Set<Order> orders;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		if(this.orders == null){
			this.orders = new HashSet<>();
		}
		this.orders.add(order);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}


	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		User other = (User) obj;
		return new EqualsBuilder().append(this.id, other.id).isEquals();
	}
}
