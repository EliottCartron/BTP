package btp.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btp.model.Facture;

public interface IFactureRepository extends JpaRepository<Facture, Long>{

//	Affichage des factures en fonction du projet et si payee ou non
	@Query("select f from Facture f where f.projet.id = :id and f.payee = :payee and f.prestataire.nom = :nomPresta")
	List<Facture> findAllByProjetAndPayee(@Param("id") Long id, @Param("payee") Boolean payee, @Param("nomPresta") String nom);
	
	
}
