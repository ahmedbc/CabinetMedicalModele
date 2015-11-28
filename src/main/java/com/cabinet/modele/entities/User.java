package com.cabinet.modele.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User implements Serializable, Comparable<User> {

	private static final long serialVersionUID = 6015977880522977050L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "user_password", nullable = false,length=100)
	private String password;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "user_roles", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	Set<Role> roles;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(Integer id, String userName, String password, UserStatus status, Set<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.roles = roles;
	}



	public Integer getId() {
		return id;
	}

	void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object o) {

		if (o instanceof User)
			if (this.id == ((User) o).id)
				return true;
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}

}
