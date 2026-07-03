package emanuela_carrubba.gestione_prenotazioni.runners;


import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import emanuela_carrubba.gestione_prenotazioni.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("prova di salvataggio nel db");

        Edificio edificio = new Edificio("Palazzo Chigi", "Via Roma", "Roma");
        edificioRepository.save(edificio);
    }
}
