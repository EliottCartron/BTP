package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Action;


public interface IActionRepository extends JpaRepository<Action, Long>{

	
	//affichage des action par projet et par etat
	@Query("select a from Action a where a.projet.offre.appelOffre.nom = :nom and a.effectuee = :effectuee")
	List<Action> findAllByProjetAndEffectuee(@Param("nom") String nom, @Param("effectuee") Boolean effectuee);
	
}
