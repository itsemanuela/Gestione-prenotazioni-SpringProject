package emanuela_carrubba.gestione_prenotazioni.runners;


import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import emanuela_carrubba.gestione_prenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("prova di salvataggio nel db");
        // mi creo una lista di sette edifici e me li salvo con il foreach nel db
        List<Edificio> listaEdifici = List.of(
                new Edificio("Palazzo delle Arti", "Via dei Mille 12", "Milano"),
                new Edificio("Centro Direzionale Sud", "Corso Umberto 45", "Napoli"),
                new Edificio("Torre Cristallo", "Viale Europa 88", "Roma"),
                new Edificio("Complesso Quadrifoglio", "Via Dante Alighieri 5", "Firenze"),
                new Edificio("Business Hub Nord", "Via Torino 102", "Torino"),
                new Edificio("Palazzo del Sole", "Via della Libertà 21", "Palermo"),
                new Edificio("Edificio Tecnopolo", "Via Bologna 33", "Bologna")
        );
        for (Edificio edificio : listaEdifici) {
            edificioRepository.save(edificio);
            System.out.println("Lista degli edifici disponibili: " + edificio);
        }

    }
}
