package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Materiel;

public interface IMaterielRepository extends JpaRepository<Materiel, Long>{

	@Query("select m from Materiel m where m.prestataire.nom = :nom")
	List<Materiel> findByEntreprise(@Param("nom") String nom);
	
	
}

