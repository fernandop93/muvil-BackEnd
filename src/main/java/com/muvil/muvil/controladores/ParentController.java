package com.muvil.muvil.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.muvil.muvil.entidades.Parent;
import com.muvil.muvil.repositorios.ParentRepository;

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
@RequestMapping("/api/parent")
class ParentController {

    @Autowired
    ParentRepository repository;

    @GetMapping
    public ResponseEntity<List<Parent>> getAll() {
        try {
            List<Parent> items = new ArrayList<Parent>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Parent> getById(@PathVariable("id") Integer id) {
        Optional<Parent> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("login")
    public ResponseEntity<Parent> login(@RequestBody Parent item) {
        try {
            List<Parent> items = new ArrayList<Parent>();

            repository.findAll().forEach(items::add);
            // Parent admin = new Parent();
            // admin.setIdParent(-1); admin.setMail("fperez@pucp.pe"); admin.setPassword("123456");
            // items.add(admin);

            items.removeIf(tempItem -> !tempItem.getMail().equals(item.getMail()) || !tempItem.getPassword().equals(item.getPassword()));
            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(items.get(0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("foroperator/{id}")
    public ResponseEntity<List<Parent>> getByOperatorId(@PathVariable("id") Integer id) {
        try {
            List<Parent> items = new ArrayList<Parent>();

            repository.findAll().forEach(items::add);
            items.removeIf(item -> item.getOperator_idOperator() != id);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Parent> create(@RequestBody Parent item) {
        try {
            Parent savedItem = repository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Parent> update(@PathVariable("id") Integer id, @RequestBody Parent item) {
        Optional<Parent> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Parent existingItem = existingItemOptional.get();
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
