package com.pegadaian.exercise.model;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="email")
	private String email;
	@Column(name="nama")
	private String nama;
	@Column(name="last_access")
	private String last_access;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getLast_access() {
		return last_access;
	}
	public void setLast_access(String last_access) {
		this.last_access = last_access;
	}
}
