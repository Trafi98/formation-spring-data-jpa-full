package sopra.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Competence;

public interface ICompetenceDao extends JpaRepository<Competence, Long> {
	
	@Query("select c from Competence c where c.id = :id")
	Optional<Competence> findCompetenceById(@Param("id") Long id);

}
