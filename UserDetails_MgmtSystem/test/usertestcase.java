import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.runners.MethodSorters;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import junit.framework.TestCase;
import static com.jayway.restassured.RestAssured.given;
/**
 * 
 */

/**
 * @author PRATIK SHAH
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class usertestcase  {
	
	
	
	@Test
	public void test1queryblankdb() throws ClientProtocolException, IOException
	{
		
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/getalluser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		assertEquals("Pass,returns 400 as bad request for empty DB",conn.getResponseCode(), HttpStatus.BAD_REQUEST.value());
	
	}
	
	
	@Test
	public void test2insertdata() throws ClientProtocolException, IOException
	{
		
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/createuser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input="  { \"id\": \"079df5e7-8194-11f6-917b-a6006dc3dba1\",\"firstName\": \"ag\","
				+ " \"middleName\": \"pqr\", \"lastName\": \"aaaz\", \"age\": 49,\"gender\": \"F\", \"phone\": \"1234567899\",\"zip\": \"411001\" }";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		assertEquals("Pass,returns 201 as created",conn.getResponseCode(), HttpStatus.CREATED.value());
	
	}

	@Test
	public void test3inserterrordata() throws ClientProtocolException, IOException
	{
		
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/createuser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input="  { \"id\": \"079df5e7-8194-11f6-917b-a6006dc3dba1\",\"firstName\": \"ag\","
				+ " \"middleName\": \"pqr\", \"lastName\": \"aaaz\", \"age\": 149,\"gender\": \"F\", \"phone\": \"1234567899\",\"zip\": \"411001\" }";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		assertEquals("Pass,returns request not accepted as age was improper",conn.getResponseCode(), HttpStatus.NOT_ACCEPTABLE.value());
	
	}
	
	
	@Test
	public void test4insertsamedata() throws ClientProtocolException, IOException
	{
		
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/createuser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input="  { \"id\": \"079df5e7-8194-11f6-917b-a6006dc3dba1\",\"firstName\": \"ag\","
				+ " \"middleName\": \"pqr\", \"lastName\": \"aaaz\", \"age\": 49,\"gender\": \"F\", \"phone\": \"1234567899\",\"zip\": \"411001\" }";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		assertEquals("Pass,returns duplicate data message",conn.getResponseCode(), HttpStatus.NOT_ACCEPTABLE.value());
	
	}

	
	@Test
	public void test5viewoutput() throws ClientProtocolException, IOException
	{
		
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/getalluser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		assertEquals("Pass,returns 200 as success",conn.getResponseCode(), HttpStatus.OK.value());
	
	}
	
	@Test
	public void test6updateuser() throws ClientProtocolException, IOException
	{
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/updateuser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input="  { \"id\": \"079df5e7-8194-11f6-917b-a6006dc3dba1\",\"firstName\": \"ag\","
				+ " \"middleName\": \"pqr\", \"lastName\": \"doe\", \"age\": 49,\"gender\": \"F\", \"phone\": \"1234567899\",\"zip\": \"411001\" }";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		assertEquals("Pass,last name changed",conn.getResponseCode(), HttpStatus.OK.value());
	
	
	}
	
	@Test
	public void test7updateusernotfound() throws ClientProtocolException, IOException
	{
		URL url = new URL("http://localhost:8091/UserDetails_MgmtSystem/updateuser");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input="  { \"id\": \"097df5e7-8194-11f6-917b-a6006dc3dba1\",\"firstName\": \"ag\","
				+ " \"middleName\": \"pqr\", \"lastName\": \"doe\", \"age\": 49,\"gender\": \"F\", \"phone\": \"1234567899\",\"zip\": \"411001\" }";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		assertEquals("Pass,user not found",conn.getResponseCode(), HttpStatus.NOT_FOUND.value());

	
	
	}
	
}
