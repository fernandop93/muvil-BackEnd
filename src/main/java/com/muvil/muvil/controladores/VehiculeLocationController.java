package com.muvil.muvil.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.muvil.muvil.entidades.VehiculeLocation;
import com.muvil.muvil.repositorios.VehiculeLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/vehiculelocation")
class VehiculeLocationController {

    @Autowired
    VehiculeLocationRepository repository;

    @GetMapping
    public ResponseEntity<List<VehiculeLocation>> getAll() {
        try {
            List<VehiculeLocation> items = new ArrayList<VehiculeLocation>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("forcourse/{id}")
    public ResponseEntity<List<VehiculeLocation>> getByCourseId(@PathVariable("id") Integer id) {
        try {
            List<VehiculeLocation> items = new ArrayList<VehiculeLocation>();

            repository.findAll().forEach(items::add);
            items.removeIf(item -> item.getCourse_idCourse() != id);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<VehiculeLocation> getById(@PathVariable("id") Integer id) {
        Optional<VehiculeLocation> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VehiculeLocation> create(@RequestBody VehiculeLocation item) {
        try {
            VehiculeLocation savedItem = repository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<VehiculeLocation> update(@PathVariable("id") Integer id, @RequestBody VehiculeLocation item) {
        Optional<VehiculeLocation> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            VehiculeLocation existingItem = existingItemOptional.get();
            existingItem = item;
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
