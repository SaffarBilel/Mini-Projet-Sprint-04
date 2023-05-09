package com.bilel.equipes.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Equipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idEquipe;
@NotNull
@Size (min = 4 ,max = 20)
private String nomEquipe;
@Min(value = 1)
@Max(value = 10000)
private int classementEquipe;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;
@ManyToOne
private League league;
public Equipe() {
super();
}
public Equipe(Long idEquipe, String nomEquipe, int classementEquipe, Date dateCreation, League league) {
	super();
	this.idEquipe = idEquipe;
	this.nomEquipe = nomEquipe;
	this.classementEquipe = classementEquipe;
	this.dateCreation = dateCreation;
	this.league = league;
}
public Long getIdEquipe() {
	return idEquipe;
}
public void setIdEquipe(Long idEquipe) {
	this.idEquipe = idEquipe;
}
public String getNomEquipe() {
	return nomEquipe;
}
public void setNomEquipe(String nomEquipe) {
	this.nomEquipe = nomEquipe;
}
public int getClassementEquipe() {
	return classementEquipe;
}
public void setClassementEquipe(int classementEquipe) {
	this.classementEquipe = classementEquipe;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public League getLeague() {
	return league;
}
public void setLeague(League league) {
	this.league = league;
}

}
