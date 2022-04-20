package com.spr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="persons")
@Table(name="person")
public class Person {
	@Id
	@Column(name = "pid")
	private int pid;
	@Column(name = "pname")
	private String pname;
	@Column(name = "pjob")
	private String pjob;
	
	public Person() {
	}
	public Person(int pid, String pname, String pjob) {
		this.pid = pid;
		this.pname = pname;
		this.pjob = pjob;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPjob() {
		return pjob;
	}
	public void setPjob(String pjob) {
		this.pjob = pjob;
	}
	
	
}
