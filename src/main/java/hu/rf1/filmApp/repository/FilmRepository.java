package hu.rf1.filmApp.repository;

import hu.rf1.filmApp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

//Ez az interface fog kommunikálni az adatbázissal.
//Film típusú entity-ket tud tárolni, Long típusú id -vel
public interface FilmRepository extends JpaRepository<Film, Long> {

}
