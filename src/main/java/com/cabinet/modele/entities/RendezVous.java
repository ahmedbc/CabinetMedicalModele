package com.cabinet.modele.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table
@TableGenerator(name = "rdv_gen", table = "hibernate_seq", pkColumnName = "rdv_pk", pkColumnValue = "rdv_pk_value", valueColumnName = "rdv_pk_value", initialValue = 1, allocationSize = 1)
@Entity
public class RendezVous implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1197097805829195931L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "rdv_gen")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date jour;

	// un rv est lié à un client
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private Client client;

	// un rv est lié à un créneau
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_creneau")
	private Creneau creneau;
	// clés étrangères
	@Column(name = "id_client", insertable = false, updatable = false)
	private long idClient;
	@Column(name = "id_creneau", insertable = false, updatable = false)
	private long idCreneau;

	// constructeur par défaut
	public RendezVous() {
	}

	// avec paramètres
	public RendezVous(Date jour, Client client, Creneau creneau) {
		this.jour = jour;
		this.client = client;
		this.creneau = creneau;
	}

	// toString
	public String toString() {
		return String.format("Rv[%d, %s, %d, %d]", id, jour, client.getId(), creneau.getId());
	}

}
