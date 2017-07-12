/**
 * 
 */
package com.hibernate.init;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.hibernate.dataobject.UserDetail;

import com.userdetails_mgmtstystem.resource.response;





/**
 * @author PRATIK SHAH
 *
 */

public class HibernateUtilImpl implements Hibernate  {


	/**
	 * @param args
	 */
	@Autowired
	private static  SessionFactory sessionfactory;
	  String message;

	public  String getMessage() {
		return message;
	}

	public  void setMessage(String message) {
		this.message = message;
	}

	HibernateUtilImpl(SessionFactory sessionfactory)
	{
		if(this.sessionfactory==null)
			this.sessionfactory=sessionfactory;

	}

	public  response storeuser(UserDetail userdetail) {

		Session session=this.sessionfactory.openSession();
		if(this.sessionfactory==null) return response.emptysession ;
		session.beginTransaction();
		try{


			session.save(userdetail);
			session.getTransaction().commit();
			session.close();
			return response.sucess;
		}

		catch(Exception ex)
		{	session.getTransaction().rollback();
		session.close();
		
		setMessage(ex.getLocalizedMessage());
		return response.error ; 
		}
	}



	public  List getallusers() {
		if(this.sessionfactory==null) return null;
		Session session=this.sessionfactory.openSession();
		List<UserDetail> userlist= session.createCriteria(UserDetail.class).list();
		session.close();
		return userlist;
	}


	public response updateuser(UserDetail userdetail) {

		if(this.sessionfactory==null) return response.emptysession ;
		Session session=this.sessionfactory.openSession();
		session.beginTransaction();
		try{

			UserDetail userDetails=session.get(UserDetail.class, userdetail.getId());
			if(userDetails==null) {
				session.close();
				setMessage("Data for "+userdetail.getId()+"Not found");
				return response.notfound;}
			else
			{
				session.clear();
				
			}
			session.delete(userdetail);
			session.flush();		
			session.save(userdetail);
			session.getTransaction().commit();
			session.close();
			return response.sucess;
		}

		catch(Exception ex)
		{	session.getTransaction().rollback();
		session.close();
		setMessage(ex.getLocalizedMessage());
		return response.error ; 
		}
	}








}
