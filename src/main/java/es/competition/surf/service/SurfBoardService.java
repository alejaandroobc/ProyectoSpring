package es.competition.surf.service;

import es.competition.surf.entities.Spot;
import es.competition.surf.entities.SurfBoard;
import es.competition.surf.repository.SurfBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurfBoardService {
    private final SurfBoardRepository repository;

    public SurfBoardService(SurfBoardRepository repository) {
        this.repository = repository;
    }

    public List<SurfBoard>findAll(){
        return repository.findAll();
    }
    public SurfBoard createSurfBoard(SurfBoard surfBoard){
        return repository.save(surfBoard);
    }
    public SurfBoard updateSurfBoard(SurfBoard surfBoard){return repository.save(surfBoard);}
    public SurfBoard updatePartialSurfBoard(SurfBoard surfBoard){
        if (surfBoard.getId()!=null){
            return repository.save(surfBoard);
        }
        throw new RuntimeException();
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<SurfBoard> getSurfBoardCurrentYear(Integer year){
        return repository.findSurfBoardByNowYear(year);
    }

}
