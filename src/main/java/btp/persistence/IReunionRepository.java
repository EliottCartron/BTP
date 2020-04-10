package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Reunion;

public interface IReunionRepository extends JpaRepository<Reunion, Long>{

}
