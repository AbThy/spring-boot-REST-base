package hu.rf1.filmApp.controller;

import hu.rf1.filmApp.model.Film;
import hu.rf1.filmApp.service.FilmService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//Ez a controller a /film URL-n fogad http requesteket
@RequestMapping("film")
public class FilmController {

    // A Controller kezeli a HTTP kéréseket
    // Az üzleti logika a service-ben van
    // Nem kell példányosítani a filmService-t, az autowired annotációval
    // autómatikusan betöltődik az aktív létező objektum a konstruktorban
    private FilmService filmService;
    @Autowired
    public  FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    //Ez az API endpoint a /film/getById URL-n elérhető
    @GetMapping("/getById")
    //az id nevű paramétert (GET, vagy POST módon átadva) Long típusként várja
    //visszaadni egy egyedi Http Response-t fog, aminek tartalma Object
    // (bármilyen típus lehet és a Spring megold mindent)
    public ResponseEntity<Object> getById(@RequestParam("id") Long id){
        try{
            // HTTP 200 - Ok válasszal visszaadunk egy film objektumot, ami automatikusan JSON
            return ResponseEntity.ok().body(filmService.getById(id));
        } catch (Exception ex){
            // Ha nem sikerült a hiba okával visszaadunk egy badRequest választ
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/addFilm")
    public ResponseEntity<Object> addMovie(@RequestParam("title") String title){
        try {
            filmService.addFilm(title);
            return ResponseEntity.ok().body("A film mentése sikeres!");
        } catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

}
