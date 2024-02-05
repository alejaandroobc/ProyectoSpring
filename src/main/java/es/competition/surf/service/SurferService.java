package es.competition.surf.service;

import es.competition.surf.entities.Surfer;
import es.competition.surf.repository.SurferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurferService {
    private final SurferRepository repository;


    public SurferService(SurferRepository repository) {
        this.repository = repository;
    }

    public List<Surfer> findAll(){
        return repository.findAll();
    }

    public Surfer createSurfer(Surfer surfer){
        return repository.save(surfer);
    }
    public Surfer updateSurfer(Surfer surfer){return repository.save(surfer);}

    public Surfer updatePartialSurfer(Surfer surfer){
        if (surfer.getId()!=null){
            return repository.save(surfer);
        }
        throw new RuntimeException();
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    public Surfer getSurferWithLessScore(){
        return repository.findFirstByOrderByScoreAsc();
    }

    public List<Surfer> getSurferBySurfBoardMaker(String maker){
        return repository.getSurfersBySurfBoardMaker(maker);
    }
}
