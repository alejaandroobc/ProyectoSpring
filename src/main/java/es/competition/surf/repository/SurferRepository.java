package es.competition.surf.repository;

import es.competition.surf.entities.Surfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurferRepository extends JpaRepository<Surfer,Long> {
    Surfer findFirstByOrderByScoreAsc();

    /// objetos
    @Query("SELECT new es.competition.surf.dto.SurferDTO(s.name,s.age,s.country)" +
    "FROM Surfer s WHERE s.surfBoard.id = (SELECT b.id FROM SurfBoard b WHERE b.maker LIKE :fabricante)")
    List<Surfer> getSurfersBySurfBoardMaker(String fabricante);
}
