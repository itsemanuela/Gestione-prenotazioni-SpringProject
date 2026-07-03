package entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "postazione")
public class Postazione {
    @Id
    private String codice_univoco; //lo utilizzo come PK
    private int max_partecipanti;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo_postazione;


    //un edificio puo avere piu postazioni quindi in questo caso definisco una ManyToOne verso edificio
    @ManyToOne
    private Edificio edificio;


    public Postazione(String codice_univoco, int max_partecipanti,String descrizione, TipoPostazione tipo_postazione, Edificio edificio ) {
        this.codice_univoco = codice_univoco;
        this.max_partecipanti = max_partecipanti;
        this.tipo_postazione = tipo_postazione;
        this.edificio = edificio;
        this.descrizione = descrizione;

    }
}
