package emanuela_carrubba.gestione_prenotazioni.entities;

 import  emanuela_carrubba.gestione_prenotazioni.entities.Prenotazione;
 import jakarta.persistence.*;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;

 import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "utente")

public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;

    // un utente può avere piu prenotazioni
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;



    }

}