package emanuela_carrubba.gestione_prenotazioni.repositories;


import emanuela_carrubba.gestione_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Utenterepository extends JpaRepository<Utente, String> {
}
