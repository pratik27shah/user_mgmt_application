/**
 * 
 */
package com.hibernate.init;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.dataobject.UserDetail;
import com.userdetails_mgmtstystem.resource.response;

/**
 * @author PRATIK SHAH
 *
 */
public interface Hibernate {
	response storeuser(UserDetail userdetail);
	List getallusers();
}
