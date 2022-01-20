package sopra.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Matiere;

public interface IMatiereDao extends JpaRepository<Matiere, Long> {
	
	@Query("select m from Matiere m")
	List<Matiere> findAllMatiere();
	
	@Query("select m from Matiere m where m.id = :id")
	Optional<Matiere> findMatiereById(@Param("id") Long id);

}
