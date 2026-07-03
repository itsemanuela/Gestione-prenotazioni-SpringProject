package entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "edificio")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;

   public Edificio(String nome, String indirizzo,String citta) {
       this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta= citta;
   }

    //un edificio ha molte postazioni
    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

}
