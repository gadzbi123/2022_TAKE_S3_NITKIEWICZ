package pl.polsl.autobusy.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.autobusy.entities.Klient;
import pl.polsl.autobusy.operations.DatabaseOperations;

@RestController
public class KlientController {

    @GetMapping("/klienci/{id}")
    public Klient getById(@PathVariable int id) {
        try (DatabaseOperations<Klient> db = new DatabaseOperations<>(Klient.class)) {
            return db.get(id);
        }
    }

    @PostMapping("/klienci")
    public void insert(@RequestBody Klient klient) {
        try (DatabaseOperations<Klient> db = new DatabaseOperations<>(Klient.class)) {
            db.insert(klient);
        }
    }

    @PutMapping("/klienci")
    public void update(@RequestBody Klient klient) {
        try (DatabaseOperations<Klient> db = new DatabaseOperations<>(Klient.class)) {
            db.update(klient);
        }
    }

    @DeleteMapping("/klienci/{id}")
    public void delete(@PathVariable int id) {
        try (DatabaseOperations<Klient> db = new DatabaseOperations<>(Klient.class)) {
            db.delete(id);
        }
    }
}
