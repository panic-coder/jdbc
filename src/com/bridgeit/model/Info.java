/**
 * Purpose: POJO for information details
 * 
 * @author Kumar Shubham
 * @since 23/06/2018
 *
 */

package com.bridgeit.model;

public class Info {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String maritalStatus;
	@Override
	public String toString() {
		return ""+id+",'"+firstName+"','"+lastName+"','"+gender+"','"+maritalStatus+"'";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	private long phoneNumber;
	 
}
