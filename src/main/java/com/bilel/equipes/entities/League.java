package com.bilel.equipes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class League {
	
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idLea;
   private String nomLea;
   private int nombreEquipes;
   
   
   @OneToMany(mappedBy = "league")
   @JsonIgnore
   private List<Equipe> Equipes;

   

}
