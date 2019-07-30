package com.lovemesomecoding.address;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String street;

	private String street2;

	private String city;
	
	private String state;

	private String zip;

	private Double lon;

	private Double lat;
	
	private String timezone;

	public Address() {
		this( null, null, null, null, null, null, null);
	}

	public Address(String street, String street2, String city, String state, String zip,
			Double lon, Double lat) {
		super();
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.lon = lon;
		this.lat = lat;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String generateAsString() {
		return this.street+", "+this.city+", "+this.state+", "+this.zip;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}