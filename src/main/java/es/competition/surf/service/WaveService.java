package es.competition.surf.service;

import es.competition.surf.entities.Surfer;
import es.competition.surf.entities.Wave;
import es.competition.surf.repository.WaveRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class WaveService {
    private final WaveRepository repository;


    public WaveService(WaveRepository repository) {
        this.repository = repository;
    }

    public Wave createWave( Wave wave){
        return repository.save(wave);
    }
    public Wave updateWave(Wave wave){return repository.save(wave);}

    public Wave updatePartialWave(Wave wave){
        if (wave.getId()!=null){
            return repository.save(wave);
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Wave> getWavesBySpotAndSurfer(String spotname,String surfername){
        return repository.getWavesBySpotAndSurfer();
    }

    public List<Wave> getWavesOrderBySize(){
        return repository.findAllByOrderByHeightDesc();
    }
}
