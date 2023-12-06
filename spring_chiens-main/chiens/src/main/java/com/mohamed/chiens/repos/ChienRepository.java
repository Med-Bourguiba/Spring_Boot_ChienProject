package com.mohamed.chiens.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.entities.Race;

@RepositoryRestResource(path="rest")
public interface ChienRepository extends JpaRepository<Chien, Long> {

	List<Chien> findByNomChien (String nom);
	List<Chien> findByNomChienContains (String nom);
	

	
	@Query ("select c from Chien c where c.nomChien like %:nom and c.prixChien > :prix")
	List<Chien> findByNomPrix (@Param("nom") String nom,@Param("prix") double prix);

	@Query ("select c from Chien c where c.race =?1")
	List<Chien> findByRace(Race race);
	
	List<Chien> findByRaceIdRc(Long id);
	
	List<Chien> findByOrderByNomChienDesc();
	
	@Query ("select c from Chien c order by c.nomChien ASC ,c.prixChien DESC")
	List<Chien> trierChiensNomsPrix();
	
   
}
