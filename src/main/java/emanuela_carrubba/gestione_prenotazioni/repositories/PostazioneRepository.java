package emanuela_carrubba.gestione_prenotazioni.repositories;

import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import emanuela_carrubba.gestione_prenotazioni.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, String> {
    //metodo per cercare tramite postazione, edificio e cittò
    List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipo, String citta);
}

