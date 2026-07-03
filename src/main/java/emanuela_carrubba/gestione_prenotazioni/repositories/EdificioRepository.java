package emanuela_carrubba.gestione_prenotazioni.repositories;

import emanuela_carrubba.gestione_prenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
List<Edificio> findByCitta(String citta);

@Query("SELECT DISTINCT e.citta FROM Edificio e")
    List<String> findAllCitta();
}
