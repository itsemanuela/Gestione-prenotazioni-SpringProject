package emanuela_carrubba.gestione_prenotazioni.repositories;

import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
