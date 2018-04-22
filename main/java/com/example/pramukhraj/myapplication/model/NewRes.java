package com.example.pramukhraj.myapplication.model;

import java.io.Serializable;
import java.util.List;

public class NewRes implements Serializable{
	private List<ContactsItem> contacts;

	public void setContacts(List<ContactsItem> contacts){
		this.contacts = contacts;
	}

	public List<ContactsItem> getContacts(){
		return contacts;
	}

	@Override
 	public String toString(){
		return 
			"NewRes{" + 
			"contacts = '" + contacts + '\'' + 
			"}";
		}
}