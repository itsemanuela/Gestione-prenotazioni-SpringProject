package emanuela_carrubba.gestione_prenotazioni.service;

import emanuela_carrubba.gestione_prenotazioni.PostazioneException;
import emanuela_carrubba.gestione_prenotazioni.PrenotazioneException;
import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import emanuela_carrubba.gestione_prenotazioni.entities.Prenotazione;
import emanuela_carrubba.gestione_prenotazioni.entities.Utente;
import emanuela_carrubba.gestione_prenotazioni.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void prenotaPostazione(Utente utente, Postazione postazione, LocalDate data_prenotazione) {
        // controllo se l'utente ha già una prenotazione per quel giorno
        if (prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data_prenotazione)) {
            throw new PrenotazioneException("L'utente ha già una prenotazione per questa data!");
        }

        // verifico se La postazione è già occupata in quel giorno
        if (prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data_prenotazione)) {
            throw new PostazioneException("La postazione è già occupata per questa data!");
        }

        // se i controlli passano, salvo la prenotazione
        prenotazioneRepository.save(new Prenotazione(data_prenotazione, utente, postazione));
        System.out.println("Prenotazione effettuata con successo!");
    }
}
