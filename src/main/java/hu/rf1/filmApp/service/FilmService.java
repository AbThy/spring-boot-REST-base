package hu.rf1.filmApp.service;

import hu.rf1.filmApp.model.Film;
import hu.rf1.filmApp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class FilmService {

    //az autowired működése kommentezve van a controllerben
    private final FilmRepository filmRepository;
    @Autowired
    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public Film getById(Long id) throws EntityNotFoundException{
        //Automatikusan létrehozott SQL query
        // kulcsszavak alapján -> find + By + Id (id a változó neve)
        Optional<Film> result = filmRepository.findById(id);
        //ha van ilyen id a Film repositoryban visszaadjuk
        if(result.isPresent()){
            return result.get();
        }
        //ha nincs errort dobunk
        throw new EntityNotFoundException("Nem létezik ilyen film.");
    }

    public void addFilm(String title) {
        Film f = new Film(title);
        filmRepository.save(f);
    }
}
