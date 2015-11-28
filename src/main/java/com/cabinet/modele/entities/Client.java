package com.cabinet.modele.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name = "client")
@TableGenerator(name="client_gen",table="hibernate_seq",pkColumnName="client_pk",pkColumnValue="client_pk_value",valueColumnName="client_pk",initialValue=1,allocationSize=1)
@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7969383845884985225L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="client_gen")
	private long id;
	@Column(name="nom",nullable=false)
	private String firstName;
	@Column(name="prenom",nullable=false)
	private String lastName;

	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	Set<RendezVous> rendezVous;
	
	public Client() {
	 }

	public Client(String firstName, String lastName) {
	 this.firstName = firstName;
	 this.lastName = lastName;
	 }

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public String toString() {
		return String.format("Client[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

}
