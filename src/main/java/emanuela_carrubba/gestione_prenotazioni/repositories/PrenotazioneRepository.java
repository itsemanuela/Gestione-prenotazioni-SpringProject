package emanuela_carrubba.gestione_prenotazioni.repositories;

import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import emanuela_carrubba.gestione_prenotazioni.entities.Prenotazione;
import emanuela_carrubba.gestione_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    //  controllo se l'utente ha già prenotazioni per quella data
    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data_prenotazione);

    // controllo se la postazione è già presa per quella data
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data_prenotazione);
}
