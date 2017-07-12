/**
 * 
 */
package com.hibernate.dataobject;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

/**
 * @author PRATIK SHAH
 *
 */

@Entity
@Table(name="User_Details")
public class UserDetail {
	@JsonProperty("id") @NotNull @Id
	UUID id;
	@JsonProperty("firstName") @NotBlank(message="FirstName must not be blank") @Pattern(regexp="(^[a-zA-Z]*)",message="FirstName must only have alphabets")
	 String firstName ; 
	
	@JsonProperty("middleName") @Basic(optional=true)   @Pattern(regexp="(^[a-zA-Z]*)",message="middleName must only have alphabets")
	String middleName ;
	@JsonProperty("lastName") @NotBlank(message="lastName must not be blank") @Pattern(regexp="(^[a-zA-Z]*)",message="lastName must only have alphabets")
	String lastName ;
	@JsonProperty("age") @NotNull  @Range(min=1, max=99,message=
			"age must be between 1-99")
	int age;
	@JsonProperty("gender") @NotBlank(message="Gender must not be blank") @Pattern(regexp="(^[M|F]{1}$)",message="Gender must only ne M/F")
	String gender;
	@JsonProperty("phone") @NotBlank(message="Phone number must not be blank") @Pattern(regexp="(^$|[0-9]{10})",message="Phone number must only have 10-digits")
	String phone;
	@JsonProperty("zip") @Basic(optional=true)   @Pattern(regexp="(^[0-9]*)",message="zipcode  must only have digits")
	String zip;
	
		public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
		public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}	


}
