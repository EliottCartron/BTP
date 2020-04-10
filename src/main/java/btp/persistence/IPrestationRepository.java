package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Prestation;

public interface IPrestationRepository extends JpaRepository<Prestation, Long>{

}
