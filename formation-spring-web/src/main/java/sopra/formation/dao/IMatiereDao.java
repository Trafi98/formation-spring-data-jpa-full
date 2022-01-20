package sopra.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.formation.model.Matiere;

public interface IMatiereDao extends JpaRepository<Matiere, Long> {
	
	@Query("select m from Matiere m")
	List<Matiere> findAllMatiere();

}
