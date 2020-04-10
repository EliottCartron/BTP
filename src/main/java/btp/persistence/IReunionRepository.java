package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import btp.model.Reunion;

public interface IReunionRepository extends JpaRepository<Reunion, Long>{

	
	//Affichage des reunion effectuées ou planifiées
	@Query("select r from Reunion r where r.dtReunion > current_date")
	List<Reunion> findAllByDate();
	
}
