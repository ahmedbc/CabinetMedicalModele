package com.cabinet.modele.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable, Comparable<Role> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "role_name")
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	Set<User> users = new TreeSet<User>();

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String roleName, Set<User> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Role) {
			if (this.id == ((Role) obj).id)
				return true;
		}
		return false;
	}

	public int compareTo(Role o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}

}
