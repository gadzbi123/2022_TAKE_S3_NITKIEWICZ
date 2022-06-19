package pl.polsl.autobusy.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.autobusy.entities.Autobus;
import pl.polsl.autobusy.operations.DatabaseOperations;

import java.util.List;

@RestController
public class AutobusyController {

    @GetMapping("/autobusy")
    public List<Autobus> getAll() {
        try (DatabaseOperations<Autobus> db = new DatabaseOperations<>(Autobus.class)) {
            return db.getAll();
        }
    }

    @GetMapping("/autobusy/{id}")
    public Autobus getById(@PathVariable int id) {
        try (DatabaseOperations<Autobus> db = new DatabaseOperations<>(Autobus.class)) {
            return db.get(id);
        }
    }

    @PostMapping("/autobusy")
    public void insert(@RequestBody Autobus autobus) {
        try (DatabaseOperations<Autobus> db = new DatabaseOperations<>(Autobus.class)) {
            db.insert(autobus);
        }
    }

    @PutMapping("/autobusy")
    public void update(@RequestBody Autobus autobus) {
        try (DatabaseOperations<Autobus> db = new DatabaseOperations<>(Autobus.class)) {
            db.update(autobus);
        }
    }

    @DeleteMapping("/autobusy/{id}")
    public void delete(@PathVariable int id) {
        try (DatabaseOperations<Autobus> db = new DatabaseOperations<>(Autobus.class)) {
            db.delete(id);
        }
    }
}
