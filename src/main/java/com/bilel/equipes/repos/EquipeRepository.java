package com.bilel.equipes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bilel.equipes.entities.League;
import com.bilel.equipes.entities.Equipe;



@RepositoryRestResource(path = "rest")
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	List<Equipe> findByNomEquipe(String nom);
	List<Equipe> findByNomEquipeContains(String nom);
    
	
	
	@Query("select p from Equipe p where p.nomEquipe like  %:nomEquipe and p.classementEquipe> :classementEquipe")
	List<Equipe> findByNomEquipeClassementEquipe (@Param("nomEquipe") String nomEquipe,@Param("classementEquipe") int classementEquipe);


	@Query("select p from Equipe p where p.league = ?1")
	List<Equipe> findByLeague (League league);

	List<Equipe> findByLeagueIdLea(Long id);
	
	List<Equipe> findByOrderByNomEquipeAsc();
	
	@Query("select p from Equipe p order by p.nomEquipe ASC, p.classementEquipe DESC")
	List<Equipe> trierEquipesNomEquipeClassementEquipe ();


}
