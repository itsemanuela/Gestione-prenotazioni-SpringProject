package emanuela_carrubba.gestione_prenotazioni.runners;


import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import emanuela_carrubba.gestione_prenotazioni.entities.TipoPostazione;
import emanuela_carrubba.gestione_prenotazioni.repositories.EdificioRepository;
import emanuela_carrubba.gestione_prenotazioni.repositories.PostazioneRepository;
import emanuela_carrubba.gestione_prenotazioni.service.PostazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;
@Autowired
private PostazioneService postazioneService;



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
    }}


