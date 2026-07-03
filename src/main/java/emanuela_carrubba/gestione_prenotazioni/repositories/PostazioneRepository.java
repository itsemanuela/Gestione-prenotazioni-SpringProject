package emanuela_carrubba.gestione_prenotazioni.repositories;

import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, String> {
}
