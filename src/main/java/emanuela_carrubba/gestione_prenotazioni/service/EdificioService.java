package emanuela_carrubba.gestione_prenotazioni.service;

import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import emanuela_carrubba.gestione_prenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio) {
edificioRepository.save(edificio);
        System.out.println("Edificio salvata" + edificio);


    }
}
