package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Projet;

public interface IProjetRepository extends JpaRepository<Projet, Long>{

}
