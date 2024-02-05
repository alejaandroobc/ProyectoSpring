package es.competition.surf.repository;

import es.competition.surf.entities.Wave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaveRepository  extends JpaRepository<Wave,Long> {
    @Query(value = "SELECT w FROM Wave w WHERE w.id=(SELECT s.id FROM Spot s WHERE s.name LIKE :nombrespot) " +
            "AND w.surfer.id =(SELECT t.id FROM Surfer t WHERE t.name LIKE :nombresurfer)")
    List<Wave> getWavesBySpotAndSurfer();

    List<Wave> findAllByOrderByHeightDesc();
}
