/**
 * 
 */
package com.hibernate.init;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

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

	HibernateUtilImpl(SessionFactory sessionfactory)
	{
		if(this.sessionfactory==null)
			this.sessionfactory=sessionfactory;

	}

	public  response storeuser(UserDetail userdetail) {

		try{
			Session session=this.sessionfactory.openSession();
			session.beginTransaction();
			session.save(userdetail);
			session.getTransaction().commit();
			session.close();
			return response.sucess;
		}
		catch(DataIntegrityViolationException ex)
		{
			return response.duplicate;

		}
		catch(Exception ex)
		{	 return response.error ; 
		}
	}



	public  List getallusers() {
		Session session=this.sessionfactory.openSession();
		return session.createCriteria(UserDetail.class).list();
	}






}
