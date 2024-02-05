package es.competition.surf.repository;

import es.competition.surf.entities.SurfBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurfBoardRepository extends JpaRepository<SurfBoard,Long>{

    @Query("SELECT s FROM SurfBoard s WHERE s.sbyear= :anyo" )
    List<SurfBoard> findSurfBoardByNowYear(int anyo);
}
