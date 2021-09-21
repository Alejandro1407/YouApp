package sv.com.udb.youapplogic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.com.udb.youapplogic.entities.Genre;
import sv.com.udb.youapplogic.repository.GenreRepository;

import java.util.List;

@RestController
@RequestMapping("/genre")
@CrossOrigin
public class GenteController {

    private final GenreRepository repository;

    @Autowired
    public GenteController(GenreRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Genre> getGenre(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable("id") int id ){
        return repository.getById(id);
    }

    @PostMapping()
    public Genre addGenre(@RequestBody Genre genre){
        return repository.save(genre);
    }

    @PutMapping("")
    public Genre actGenre(@RequestBody Genre genre){
        if (genre.getId() != null){
            if(repository.existsById(genre.getId()))
                return repository.save(genre);
            else
                return null;
        } else
            return null;
    }

    @DeleteMapping("/{id}")
    public void delGenre(@PathVariable("id") int id){
        repository.deleteById(id);
    }

}
