package emanuela_carrubba.gestione_prenotazioni;

import emanuela_carrubba.gestione_prenotazioni.entities.*;
import emanuela_carrubba.gestione_prenotazioni.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPrenotazione {

    @Autowired private PostazioneService postazioneService;
    @Autowired private PrenotazioneService prenotazioneService;
    @Autowired private EdificioService edificioService;
    @Autowired private UtenteService utenteService;

    // test ricerca postazione (verifica che il filtro città funzioni)
    @Test
    void testRicercaPostazionePerCitta() {
        List<Postazione> risultati = postazioneService.cercaPostazione(TipoPostazione.OPEN_SPACE, "Roma");
        assertNotNull(risultati);

    }

    // test disponibilità ddificio (verifica che trovi almeno un edificio)
    @Test
    void testTrovaEdificiPerCitta() {
        List<Edificio> edifici = edificioService.findByCitta("Napoli");
        assertFalse(edifici.isEmpty(), "Dovrebbe esserci almeno un edificio a Napoli");
    }




    //  Test sull Utente (verifica che gli utenti vengano caricati correttamente)
    @Test
    void testRecuperoUtenti() {
        List<Utente> utenti = utenteService.findAll();
        assertFalse(utenti.isEmpty(), "Il database dovrebbe contenere utenti");
    }
}