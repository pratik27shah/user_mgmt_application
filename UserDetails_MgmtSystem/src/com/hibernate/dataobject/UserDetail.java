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
	@JsonProperty("firstName") @NotNull  @Pattern(regexp="(^[a-zA-Z]*)")
	 String firstName ; 
	
	@JsonProperty("middleName") @Basic(optional=true)   @Pattern(regexp="(^[a-zA-Z]*)")
	String middleName ;
	@JsonProperty("lastName") @NotNull @Pattern(regexp="(^[a-zA-Z]*)")
	String lastName ;
	@JsonProperty("age") @NotNull  @Range(min=1, max=99)
	int age;
	@JsonProperty("gender") @NotNull @Pattern(regexp="(^[M|F]{1}$)")
	String gender;
	@JsonProperty("phone") @Pattern(regexp="(^$|[0-9]{10})")
	String phone;
	@JsonProperty("zip") @Basic(optional=true)   @Pattern(regexp="(^[0-9]*)")
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
