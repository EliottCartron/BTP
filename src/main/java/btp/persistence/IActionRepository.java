package btp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import btp.model.Action;

public interface IActionRepository extends JpaRepository<Action, Long>{

}
