/**
 * 
 */
package com.hibernate.init;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.dataobject.UserDetail;
import com.userdetails_mgmtstystem.resource.response;

/**
 * @author PRATIK SHAH
 *
 */
public interface Hibernate {
	  String getMessage();
	response storeuser(UserDetail userdetail);
	List getallusers();
	response updateuser(UserDetail userdetail);
	void setMessage(String message);
}
