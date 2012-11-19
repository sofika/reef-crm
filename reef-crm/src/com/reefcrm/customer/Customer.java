package com.reefcrm.customer;


import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/customer")
public class Customer {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextCustomer() {
		return "Hello Customer";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLCustomer() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Customer, jetzt geht es aber auf mit XML !!" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlCustomer() {
		/*
    return "<html> " + "<title>" + "Hello Customer" + "</title>"
        + "<body><h1>" + "Hello Customer jetzt get es aber auf mit HTML" + "</body></h1>" + "</html> ";
		 */
		RecCustomer[] tabCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			tabCustomer = db.getFirstCustomer(con, 10);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			error=e.toString();
			tabCustomer =null;
		}

		String s=getHtmlHead();
		if(tabCustomer!=null) {
			s+="<table align='center' border='1'>";
			s+=RecCustomer.toHtmlHeader();
	
			for(int i=0;i<tabCustomer.length;i++) {
				s+=tabCustomer[i].toHtmlRow();
			}
			s+="</table>";
		}
		else {
			s+=getHtmlError(error);
		}
		s+=getHtmlFoot();
		return s;
	}

	private String getHtmlError(String error) {
		String s="<h2>error connecting database</h2>";
		s+="<p>"+error+"</p>";
		return s;
	}

	@GET
	@Path("/byId/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String getByIdHtmlCustomer(@PathParam("id") String id) 
	{
		RecCustomer recCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			recCustomer = db.getCustomerById(con, id);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			recCustomer =null;
		}

		String s=getHtmlHead();
	
		if(recCustomer!=null) {
			s+="<table align='center' border='1'>";
			s+=RecCustomer.toHtmlHeader();
			s+=recCustomer.toHtmlRow();
			s+="</table>";

		}
		else {
			s+=getHtmlError(error);
		}
		s+=getHtmlFoot();

		return s;
	}
	
	@GET
	@Path("/byId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecCustomer getByIdCustomer(@PathParam("id") String id) 
	{
		RecCustomer recCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			recCustomer = db.getCustomerById(con, id);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			recCustomer =null;
		}
		return recCustomer;
	}
	
	
	@GET
	@Path("/byName/{name}")
	@Produces(MediaType.TEXT_HTML)
	public String getByNameHtmlCustomer(@PathParam("name") String name) 
	{
		RecCustomer[] tabCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			tabCustomer = db.getCustomerByName(con, name);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			tabCustomer =null;
		}
		String s="";
		s+=getHtmlHead();
		if(tabCustomer!=null) {
			s+="<table align='center' border='1'>";
			s+="<tr>";
			s+=RecCustomer.toHtmlHeader();
			for(int i=0;i<tabCustomer.length;i++) {
				s+=tabCustomer[i].toHtmlRow();
			}
			s+="</table>";
		}
		else {
			s+=getHtmlError(error);
		}
		s+=getHtmlFoot();
		return s;
	}
	
	
	
	@GET
	@Path("/byName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecCustomer[] getByNameJsonCustomer(@PathParam("name") String name) 
	{
		RecCustomer[] tabCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			tabCustomer = db.getCustomerByName(con, name);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			tabCustomer =null;
		}
	
		return tabCustomer;
	}
	
	
	@GET
	@Path("/bySurname/{surname}")
	@Produces(MediaType.TEXT_HTML)
	public String getBySurnameHtmlCustomer(@PathParam("surname") String surname) 
	{
		RecCustomer[] tabCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			tabCustomer = db.getCustomerBySurname(con, surname);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			tabCustomer =null;
		}
		String s="";
		s+=getHtmlHead();
		if(tabCustomer!=null) {
			s+="<table align='center' border='1'>";
			s+="<tr>";
			s+=RecCustomer.toHtmlHeader();
			for(int i=0;i<tabCustomer.length;i++) {
				s+=tabCustomer[i].toHtmlRow();
			}
			s+="</table>";
		}
		else {
			s+=getHtmlError(error);
		}
		s+=getHtmlFoot();
		return s;
	}
	@GET
	@Path("/bySurname/{surname}")
	@Produces(MediaType.APPLICATION_JSON)
	public RecCustomer[] getBySurnameJsonCustomer(@PathParam("surname") String surname) 
	{
		RecCustomer[] tabCustomer =null;
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			tabCustomer = db.getCustomerBySurname(con, surname);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			tabCustomer =null;
		}
	
		return tabCustomer;
	}
	
	
	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_HTML)
	public String getCountCustomer() 
	{
		int count = -1;
	
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			count = db.getCustomerCount(con);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			
		}
		String s="";
		s+=getHtmlHead();
		if(count!=-1) {
			s+="<h1>count of customers: "+count+"</h1>";
		}
		else {
			s+=getHtmlError(error);
		}
		s+=getHtmlFoot();
		return s;
	}
	
	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountJsonCustomer() 
	{
		int count = -1;
	
		String error=null;
		DbAccess db = new DbAccess();
		try {
			Connection con = db.connect();
			count = db.getCustomerCount(con);
		} 
		catch (SQLException e) {

			e.printStackTrace();
			error=e.toString();
			
		}
		String s = "{\"count\":\""+count+"\"}";
		return s;
	}
	

	private String getHtmlFoot() 
	{
		String s="</body>";
		s+="</html>";
		return s;
	}

	private String getHtmlHead() 
	{
		String s="<html>";
		s+="<title>";
		s+="List of customers";
		s+="</title>";
		s+="<body>";
		s+="<h1 align='center'>list of customers</h1>";
		return s;
	}
	
	
	
	
} 