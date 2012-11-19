package com.reefcrm.customer;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class RecCustomer 
{
	static public String LBL_ID = "id";
	static public String LBL_NAME = "name";
	static public String LBL_SURNAME = "surname";
	
	private String id;
	private String name;
	private String surname;
	public RecCustomer()
	{
		id="";
		name="";
		surname="";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString()
	{
		String s="";
		s+=" "+LBL_ID+"="+id;
		s+=" "+LBL_NAME+"="+name;
		s+=" "+LBL_SURNAME+"="+surname;
		return s.trim();
		
	}
	public String toHtmlRow()
	{
		String s="";
		s+="<tr>";
		s+="<td>"+getId()+"</td>";
		s+="<td>"+getName()+"</td>";
		s+="<td>"+getSurname()+"</td>";
		s+="</tr>";
		return s.trim();
		
	}

	public static String toHtmlHeader() 
	{
		String s="";
		s+="<tr>";
		s+="<th>"+RecCustomer.LBL_ID+"</th>";
		s+="<th>"+RecCustomer.LBL_NAME+"</th>";
		s+="<th>"+RecCustomer.LBL_SURNAME+"</th>";
		s+="</tr>";
		return s;
	}
}
