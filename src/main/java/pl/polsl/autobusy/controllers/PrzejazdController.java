package pl.polsl.autobusy.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.autobusy.entities.Klient;
import pl.polsl.autobusy.entities.Przejazd;
import pl.polsl.autobusy.operations.DatabaseOperations;

import java.util.List;

@RestController
public class PrzejazdController {

    @GetMapping("/przejazdy")
    public List<Przejazd> getAll() {
        try (DatabaseOperations<Przejazd> db = new DatabaseOperations<>(Przejazd.class)) {
            return db.getAll();
        }
    }

    @GetMapping("/przejazdy/{id}")
    public Przejazd getById(@PathVariable int id) {
        try (DatabaseOperations<Przejazd> db = new DatabaseOperations<>(Przejazd.class)) {
            return db.get(id);
        }
    }

    @PostMapping("/przejazdy")
    public void insert(@RequestBody Przejazd przejazd) {
        try (DatabaseOperations<Przejazd> db = new DatabaseOperations<>(Przejazd.class)) {
            db.insert(przejazd);
        }
    }

    @PutMapping("/przejazdy")
    public void update(@RequestBody Przejazd przejazd) {
        try (DatabaseOperations<Przejazd> db = new DatabaseOperations<>(Przejazd.class)) {
            db.update(przejazd);
        }
    }

    @DeleteMapping("/przejazdy/{id}")
    public void delete(@PathVariable int id) {
        try (DatabaseOperations<Przejazd> db = new DatabaseOperations<>(Przejazd.class)) {
            db.delete(id);
        }
    }
}
