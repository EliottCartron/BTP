package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Salarie;

public interface ISalarieRepository extends JpaRepository<Salarie, Long>{

}
