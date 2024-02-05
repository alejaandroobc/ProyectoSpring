package es.competition.surf.service;

import es.competition.surf.entities.Spot;
import es.competition.surf.repository.SpotRepository;
import org.springframework.stereotype.Service;

@Service
public class SpotService {
    private final SpotRepository repository;

    public SpotService(SpotRepository repository) {
        this.repository = repository;
    }

    public Spot createSpot(Spot spot){
        return repository.save(spot);
    }

    public Spot updateSpot(Spot spot){return repository.save(spot);}

    public Spot updatePartialSpot(Spot spot){
        if (spot.getId()!=null){
            return repository.save(spot);
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
