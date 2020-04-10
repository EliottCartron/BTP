package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Projet;

public interface IProjetRepository extends JpaRepository<Projet, Long>{

	//Page accueil Maitre Ouvrage liste deroulante projets
	@Query("select p from Projet p where p.offre.maitreOuvrage.nom= :nom")
	List <Projet> findAllByMaitreOuvrage(@Param("nom") String nom);
	
	//Page accueil EG liste deroulante projets
	@Query("select p from Projet p where p.offre.prestataire.nom= :nom")
	List <Projet> findAllByPrestataire(@Param("nom") String nom);
	
	//Page accueil Maitre œuvre liste deroulante projets
	@Query("select p from Projet p where p.offre.prestataire.nom= :nom")
	List <Projet> findAllByMaitreOeuvre(@Param("nom") String nom);
	
}

