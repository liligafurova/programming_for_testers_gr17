package com.example.tests;

//public class ContactData implements Comparable<ContactData>{
public class ContactData implements Comparable<ContactData>{
	
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	//public String newgroup;
	public String address2;
	public String phone2;

	public ContactData() {
		
	}
	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String newgroup, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		//this.newgroup = newgroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	
	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	
	@Override
	  public int compareTo(ContactData other) {
	  int lastNameResult = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		if (lastNameResult != 0) {
		  return lastNameResult;
	    } 
		else {
		  return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		}
	}
	
	public ContactData withId (String id) {
		this.id = id;
		return this;
	}
	
	public ContactData withFirstname (String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}