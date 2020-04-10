package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Offre;

public interface IOffreRepository extends JpaRepository<Offre, Long> {

}
