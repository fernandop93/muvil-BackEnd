package com.muvil.muvil.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.*;

import com.muvil.muvil.entidades.Course;
import com.muvil.muvil.repositorios.CourseRepository;

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
@RequestMapping("/api/course")
class CourseController {

    @Autowired
    CourseRepository repository;

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        try {
            List<Course> items = new ArrayList<Course>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("foroperator/{id}")
    public ResponseEntity<List<Course>> getByOperatorId(@PathVariable("id") Integer id) {
        try {
            List<Course> items = new ArrayList<Course>();

            repository.findAll().forEach(items::add);
            items.removeIf(item -> item.getOperator_idOperator() != id);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("currentcourseforoperator/{id}")
    public ResponseEntity<Course> getCurrentCourseByOperatorId(@PathVariable("id") Integer id) {
        try {
            List<Course> items = new ArrayList<Course>();

            repository.findAll().forEach(items::add);
            items.removeIf(item -> item.getOperator_idOperator() != id);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(Collections.max(items, new Comparator<Course>() {
                @Override
                public int compare(Course a, Course b) {
                    return a.getDate().compareTo(b.getDate());
                }
            }), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getById(@PathVariable("id") Integer id) {
        Optional<Course> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course item) {
        try {
            Course savedItem = repository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Course> update(@PathVariable("id") Integer id, @RequestBody Course item) {
        Optional<Course> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Course existingItem = existingItemOptional.get();
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

    public int compare(Course a, Course b) {
        return a.getDate().compareTo(b.getDate());
    }
}
