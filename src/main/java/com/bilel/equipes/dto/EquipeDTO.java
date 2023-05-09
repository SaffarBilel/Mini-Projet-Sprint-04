package com.bilel.equipes.dto;

import java.util.Date;

import com.bilel.equipes.entities.League;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
	public class EquipeDTO {
	
	private Long idEquipe;
	
	private String nomEquipe;
	
	
	private Date dateCreation;
	
	private League league;
	
	private String nomleag;
	


	public League getLeague() {
		
		return null;
	}
	
	
	}


