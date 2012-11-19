package com.reefcrm.customer;
import java.sql.*;
import java.util.Vector;


public class DbAccess 
{
	String driver ="org.postgresql.Driver";
	String url = "jdbc:postgresql:fer"; 

	String user = "fer"; 
	String pwd = "fresenius65" ;

	static private String selectAllCustomerFields = "SELECT id, name, surname " + "FROM customer ";
	public DbAccess()
	{
		try {
			Class.forName(driver); 
		}
		catch (ClassNotFoundException e) {

			System.err.println("Can't load driver "+ e.getMessage());
		}

	}
	public Connection connect() throws SQLException
	{
		Connection con = DriverManager.getConnection(url, user,pwd);
		return con;
	}
	public RecCustomer[] getFirstCustomer(Connection con,int count) throws SQLException
	{
		Vector<RecCustomer> vec = new Vector<RecCustomer>();

		Statement query = con.createStatement();
		String sql = selectAllCustomerFields + "ORDER BY id";
		ResultSet result = query.executeQuery(sql);
		int i=0;
		while (result.next()) {
			i++;
			if(i>count) {
				break;
			}
			RecCustomer rec = getRecCustomer(result);
			vec.add(rec);
		}

		return vec.toArray(new RecCustomer[0]);
	}

	public RecCustomer getCustomerById(Connection con,String id) throws SQLException
	{
		Statement query = con.createStatement();
		String sql = selectAllCustomerFields+"where id = "+id;;
		ResultSet result = query.executeQuery(sql);
	
		while (result.next()) {
			RecCustomer rec = getRecCustomer(result);
			return rec;
		}
		return null;
	}
	
	public RecCustomer[] getCustomerByName(Connection con,String name) throws SQLException
	{
		Vector<RecCustomer> vec = new Vector<RecCustomer>();
		Statement query = con.createStatement();
		String sql = selectAllCustomerFields+"where name like '"+name+"'";
		ResultSet result = query.executeQuery(sql);
	
		while (result.next()) {
			RecCustomer rec = getRecCustomer(result);	
			vec.add(rec);
		}
		return vec.toArray(new RecCustomer[0]);
	}

	public RecCustomer[] getCustomerBySurname(Connection con,String surname) throws SQLException
	{
		Vector<RecCustomer> vec = new Vector<RecCustomer>();
		Statement query = con.createStatement();
		String sql = selectAllCustomerFields+"where surname like '"+surname+"'";
		ResultSet result = query.executeQuery(sql);
	
		while (result.next()) {
			RecCustomer rec = getRecCustomer(result);
			vec.add(rec);
		}
		return vec.toArray(new RecCustomer[0]);
	}
	private RecCustomer getRecCustomer(ResultSet result) throws SQLException
	{
		RecCustomer rec = new RecCustomer();
		rec.setId(result.getString("id"));
		rec.setName(result.getString("name"));
		rec.setSurname(result.getString("surname"));
		return rec;
		
	}
	public int getCustomerCount(Connection con) throws SQLException 
	{
		String sql = "select count(*) from customer";
		Statement query = con.createStatement();
		ResultSet result = query.executeQuery(sql);
	
		while (result.next()) {
			return result.getInt(1);
			
		}
		return -1;
	}

}
