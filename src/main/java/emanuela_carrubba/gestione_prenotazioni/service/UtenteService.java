package emanuela_carrubba.gestione_prenotazioni.service;

import emanuela_carrubba.gestione_prenotazioni.entities.Utente;
import emanuela_carrubba.gestione_prenotazioni.repositories.Utenterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private Utenterepository repository;
    public void salvaUtente(Utente utente){
        repository.save(utente);
        System.out.println("Utente salvato" + utente);

    }

    public List<Utente> findAll() {
return  (List<Utente>) repository.findAll();
    }
}
