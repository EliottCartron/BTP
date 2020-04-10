package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Materiel;

public interface IMaterielRepository extends JpaRepository<Materiel, Long>{

}
