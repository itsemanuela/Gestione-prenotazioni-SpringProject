package emanuela_carrubba.gestione_prenotazioni.entities;

import emanuela_carrubba.gestione_prenotazioni.entities.Postazione;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_prenotazione;

    @ManyToOne
    @JoinColumn(name = "prenotazione_utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_codice")
    private  Postazione postazione;

//passo questi tre parametri al costruttore perché sono gli elementi minimi necessari
// per definire l'esistenza di una prenotazione nel database, chi ha prenotato, quando e per quale postazione.

    public Prenotazione(LocalDate data_prenotazione, Utente utente, Postazione postazione) {
        this.data_prenotazione = data_prenotazione;
        this.utente = utente;
        this.postazione = postazione;

    }
}
