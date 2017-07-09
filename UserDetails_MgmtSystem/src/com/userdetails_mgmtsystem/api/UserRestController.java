/**
 * 
 */
package com.userdetails_mgmtsystem.api;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hibernate.dataobject.UserDetail;
import com.hibernate.init.Hibernate;
import com.userdetails_mgmtstystem.resource.response;




/**
 * @author PRATIK SHAH
 *
 */
@Controller
public class UserRestController {
	@Autowired
	SessionFactory sessionfactory;


	@Autowired
	private Hibernate hibernate;
	private HttpStatus returnstatus;

	@ResponseBody
	@RequestMapping(value="/createuser",method = {RequestMethod.POST},consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String>  createuser(@RequestBody UserDetail userDetails,ModelMap model,HttpServletRequest request) {
		response status = hibernate.storeuser(userDetails);
		if(status==response.sucess){
			returnstatus=HttpStatus.CREATED;

		}

		else
			returnstatus=HttpStatus.ALREADY_REPORTED;

		return new ResponseEntity<String>(response.values().toString(),returnstatus);

	}


	@ResponseBody
	@RequestMapping(value="/getalluser",method = {RequestMethod.GET},produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  ResponseEntity<List<UserDetail>>  getalluser(ModelMap model,HttpServletRequest request) throws SQLException, ClassNotFoundException{
		List<UserDetail> list= hibernate.getallusers();
		
		if(list.isEmpty())
		{
	returnstatus=HttpStatus.BAD_REQUEST;
			
		}
		else
			returnstatus=HttpStatus.OK;
		return new ResponseEntity<List<UserDetail>>(list, returnstatus);

	}

}
