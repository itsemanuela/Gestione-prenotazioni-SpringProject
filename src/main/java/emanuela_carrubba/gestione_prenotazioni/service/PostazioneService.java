package emanuela_carrubba.gestione_prenotazioni.service;

import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import emanuela_carrubba.gestione_prenotazioni.entities.TipoPostazione;
import emanuela_carrubba.gestione_prenotazioni.repositories.EdificioRepository;
import emanuela_carrubba.gestione_prenotazioni.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione) {
       postazioneRepository.save(postazione);
        System.out.println("Postazione salvata" + postazione);


    }

    public List<Postazione> cercaPostazione(TipoPostazione tipo, String citta) {
        List<Postazione> risultati = postazioneRepository.findByTipoPostazioneAndEdificioCitta(tipo, citta);
        if (risultati.isEmpty()) {
            System.out.println("Nessuna postazione trovata per " + tipo + " a " + citta);
        }
        return risultati;
    }



}
