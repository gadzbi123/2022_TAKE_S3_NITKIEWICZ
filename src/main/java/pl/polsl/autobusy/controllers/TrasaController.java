package pl.polsl.autobusy.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.autobusy.entities.Przejazd;
import pl.polsl.autobusy.entities.Trasa;
import pl.polsl.autobusy.operations.DatabaseOperations;

import java.util.List;

@RestController
public class TrasaController {

    @GetMapping("/trasy")
    public List<Trasa> getAll() {
        try (DatabaseOperations<Trasa> db = new DatabaseOperations<>(Trasa.class)) {
            return db.getAll();
        }
    }

    @GetMapping("/trasy/{id}")
    public Trasa getById(@PathVariable int id) {
        try (DatabaseOperations<Trasa> db = new DatabaseOperations<>(Trasa.class)) {
            return db.get(id);
        }
    }

    @PostMapping("/trasy")
    public void insert(@RequestBody Trasa trasa) {
        try (DatabaseOperations<Trasa> db = new DatabaseOperations<>(Trasa.class)) {
            db.insert(trasa);
        }
    }

    @PutMapping("/trasy")
    public void update(@RequestBody Trasa trasa) {
        try (DatabaseOperations<Trasa> db = new DatabaseOperations<>(Trasa.class)) {
            db.update(trasa);
        }
    }

    @DeleteMapping("/trasy/{id}")
    public void delete(@PathVariable int id) {
        try (DatabaseOperations<Trasa> db = new DatabaseOperations<>(Trasa.class)) {
            db.delete(id);
        }
    }
}
