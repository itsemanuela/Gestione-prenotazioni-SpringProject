package emanuela_carrubba.gestione_prenotazioni.runners;


import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import emanuela_carrubba.gestione_prenotazioni.entities.TipoPostazione;
import emanuela_carrubba.gestione_prenotazioni.entities.Utente;
import emanuela_carrubba.gestione_prenotazioni.repositories.EdificioRepository;
import emanuela_carrubba.gestione_prenotazioni.service.PostazioneService;
import emanuela_carrubba.gestione_prenotazioni.service.PrenotazioneService;
import emanuela_carrubba.gestione_prenotazioni.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;
@Autowired
private PostazioneService postazioneService;
@Autowired
private UtenteService utenteService;
@Autowired
private PrenotazioneService prenotazioneService;




    @Override
    public void run(String... args) throws Exception {
        System.out.println("prova di salvataggio nel db");
        // mi creo una lista di sette edifici e me li salvo  nel db

        Edificio e1 = edificioRepository.save(new Edificio("Palazzo delle Arti", "Via dei Mille 12", "Milano"));
        Edificio e2 = edificioRepository.save(new Edificio("Centro Direzionale Sud", "Corso Umberto 45", "Napoli"));
        Edificio e3 = edificioRepository.save(new Edificio("Torre Cristallo", "Viale Europa 88", "Roma"));
        Edificio e4 = edificioRepository.save(new Edificio("Complesso Quadrifoglio", "Via Dante Alighieri 5", "Firenze"));
        Edificio e5 = edificioRepository.save(new Edificio("Business Hub Nord", "Via Torino 102", "Torino"));
        Edificio e6 = edificioRepository.save(new Edificio("Palazzo del Sole", "Via della Libertà 21", "Palermo"));
        Edificio e7 = edificioRepository.save(new Edificio("Edificio Tecnopolo", "Via Bologna 33", "Bologna"));

// Lista postazioni
        List<Postazione> listaPostazioni = List.of(
                new Postazione("POST-MI-02", 5, "Scrivania singola in area tranquilla", TipoPostazione.OPEN_SPACE, e1),
                new Postazione("POST-NA-02", 1, "Ufficio privato con Wi-Fi dedicato", TipoPostazione.PRIVATO, e2),
                new Postazione("POST-RM-02", 10, "Sala riunioni tecnica con lavagna", TipoPostazione.SALA_RIUNIONI, e3),
                new Postazione("POST-FI-02", 12, "Open space moderno stile industriale", TipoPostazione.OPEN_SPACE, e4),
                new Postazione("POST-TO-02", 1, "Box telefonico insonorizzato", TipoPostazione.PRIVATO, e5),
                new Postazione("POST-PA-02", 25, "Aula formazione con schermi LED", TipoPostazione.SALA_RIUNIONI, e6),
                new Postazione("POST-BO-02", 6, "Open space lato vetrata", TipoPostazione.OPEN_SPACE, e7)
        );
for(Postazione p : listaPostazioni){
    postazioneService.salvaPostazione(p);
}

//lista utenti
        List<Utente> listaUtente = List.of(
                new Utente ("Mario" , "Rossi", "mariorossi@gmail.com"),
                new Utente("Carla", "Bianchi", "carlabianchi@gmail.com"),
                new Utente ("Irene", "Verdi", "ireneverdi@gmail.com"),
        new Utente("Luca", "Neri", "lucaneri@gmail.com"),
                new Utente("Elena", "Gialli", "elenagialli@gmail.com"),
                new Utente("Marco", "Blu", "marcoblu@gmail.com"),
                new Utente("Sara", "Viola", "saraviola@gmail.com"),
                new Utente("Giorgio", "Grigi", "giorgiogrigi@gmail.com")
        );
for(Utente u : listaUtente){
    utenteService.salvaUtente(u);
}

//prenoto una sala
        // mi recupero prima i dati precedentemente salvati e resi oggetti
 LocalDate dataScelta= LocalDate.of(2026, 07, 10);
Utente utentePrenotante= listaUtente.get(0);
Postazione postazioneDaPrenotare= listaPostazioni.get(2);

prenotazioneService.prenotaPostazione(utentePrenotante, postazioneDaPrenotare, dataScelta);
 System.out.println("L'utente" + utentePrenotante +  "ha richiesto" + postazioneDaPrenotare + "in data" + dataScelta);

 // try catch per prenotare e gestire errori

        // prenotazione 1
        try {
            prenotazioneService.prenotaPostazione(listaUtente.get(0), listaPostazioni.get(0), LocalDate.of(2026, 8, 1));
            System.out.println("Prenotazione 1 effettuata!");
        } catch (Exception e) {
            System.err.println("Errore prenotazione 1: " + e.getMessage());
        }

// prenotazione due
        try {
            prenotazioneService.prenotaPostazione(listaUtente.get(1), listaPostazioni.get(1), LocalDate.of(2026, 8, 2));
            System.out.println("Prenotazione 2 effettuata!");
        } catch (Exception e) {
            System.err.println("Errore prenotazione 2: " + e.getMessage());
        }

// prenotazione provando a violare una regola
        try {
            // stesso utente, stessa data, diversa postazione
            prenotazioneService.prenotaPostazione(listaUtente.get(0), listaPostazioni.get(2), LocalDate.of(2026, 8, 1));
            System.out.println("Prenotazione 3 effettuata!");
        } catch (Exception e) {
           System.err.println("Errore atteso su Prenotazione 3: " + e.getMessage());
        }

// testo metodo di ricerca per postazioni
        // --- TEST RICERCA POSTAZIONI ---
        System.out.println("\n--- TEST RICERCA POSTAZIONI ---");

        String cittaDaCercare = "Napoli";
        TipoPostazione tipoDaCercare = TipoPostazione.PRIVATO;

        List<Postazione> risultati = postazioneService.cercaPostazione(tipoDaCercare, cittaDaCercare);

        if (!risultati.isEmpty()) {
            System.out.println("Trovate " + risultati.size() + " postazione/i di tipo " + tipoDaCercare + " a " + cittaDaCercare + ":");
            risultati.forEach(p -> System.out.println(" - Codice: " + p.getCodice_univoco() + ", Descrizione: " + p.getDescrizione()));
        } else {
            System.out.println("Nessuna postazione trovata per i criteri specificati.");
        }




    }}


