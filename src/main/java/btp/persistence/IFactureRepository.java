package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Facture;

public interface IFactureRepository extends JpaRepository<Facture, Long>{

	//Affichage des factures en fonction du projet et si payee ou non
	@Query("select f from Facture f where f.projet.offre.appelOffre.nom = :nom and f.payee = :payee")
	List<Facture> findAllByProjetAndPayee(@Param("nom") String nom, @Param("payee") Boolean payee);
	
}
