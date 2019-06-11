package com.myRootPackage.Model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String messagel;
	private Date created;
	private String author;
	
	
	public Message(){
		
	}
	
	
	
	public Message(long id, String messagel, String author) {
		super();
		this.id = id;
		this.messagel = messagel;
		this.author = author;
		this.created=new Date();//self made to pick the current date and time
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessagel() {
		return messagel;
	}
	public void setMessagel(String messagel) {
		this.messagel = messagel;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
