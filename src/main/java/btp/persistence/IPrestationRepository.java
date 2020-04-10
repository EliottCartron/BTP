package btp.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.PhasePresta;
import btp.model.Prestation;

public interface IPrestationRepository extends JpaRepository<Prestation, Long>{

	
	//Prestation en cours par projet
	@Query("select p from Prestation where p.offre.appelOffre.nom = :nom AND p.dtDebut >= CURRENT_DATE  AND p.dtFin <= CURRENT_DATE")
	List<Prestation> findPrestationEnCoursParProjet(@Param("nom") String nom);
	
	//Find Prestation by ETAT
	@Query("select p from Prestation where p.phasePresta = :phase")
	List<Prestation> findPrestationByPhase(@Param("phase") PhasePresta phase);
	
}
