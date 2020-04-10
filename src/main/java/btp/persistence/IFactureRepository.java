package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Facture;

public interface IFactureRepository extends JpaRepository<Facture, Long>{

}
