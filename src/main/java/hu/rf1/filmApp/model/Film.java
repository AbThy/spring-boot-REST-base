package hu.rf1.filmApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "film") //film táblában tárolódik a film_app_db -schema-ban
@Data   //Adatbáziskezelést és getter/setter metódusokat automatizál
@NoArgsConstructor  //automatikus 0 és összes argumentumos konstruktor
@AllArgsConstructor
public class Film {
    //Mindig eggyel nöbeli az ID-t ha egy film entitást elmentünk az adatbázisba
    @Id
    @SequenceGenerator(
            name = "filmId_sequence",
            sequenceName = "filmId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "filmId_sequence"
    )
    //hagyományos osztály változók
    private Long id;
    private String cim;

    //A konstruktor amiben nem kell az ID-t megadni - ezzel fogjuk az új filmeket lementeni, ezeknek ő hoz mojd létre id-t
    public Film(String cim){
        this.cim = cim;
    }
}
