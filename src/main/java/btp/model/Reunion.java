package btp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reunion {
	@Id
	@GeneratedValue
	private Long id;
	private String sujet;
	private Integer numeroCompteRendu;
	private Date dtReunion;
	@ManyToOne
	@JoinColumn(name= "projet_id")
	private Projet projet;
	
	public Reunion() {
		super();
	}

	public Reunion(String sujet, Integer numeroCompteRendu, Date dtReunion) {
		super();
		this.sujet = sujet;
		this.numeroCompteRendu = numeroCompteRendu;
		this.dtReunion = dtReunion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Integer getNumeroCompteRendu() {
		return numeroCompteRendu;
	}

	public void setNumeroCompteRendu(Integer numeroCompteRendu) {
		this.numeroCompteRendu = numeroCompteRendu;
	}

	public Date getDtReunion() {
		return dtReunion;
	}

	public void setDtReunion(Date dtReunion) {
		this.dtReunion = dtReunion;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	

}
