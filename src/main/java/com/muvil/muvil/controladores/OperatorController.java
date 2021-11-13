package com.muvil.muvil.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import com.muvil.muvil.entidades.Course;
import com.muvil.muvil.entidades.Operator;
import com.muvil.muvil.repositorios.CourseRepository;
import com.muvil.muvil.repositorios.NotificationRepository;
import com.muvil.muvil.repositorios.OperatorRepository;
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
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;

@CrossOrigin
@RestController
@EnableScheduling
@RequestMapping("/api/operator")
class OperatorController {

    @Autowired
    OperatorRepository repository;
    CourseRepository repositoryCourse;
    VehiculeLocationRepository repositoryLocation;
    NotificationRepository repositoryNotification;

    @GetMapping
    public ResponseEntity<List<Operator>> getAll() {
        try {
            List<Operator> items = new ArrayList<Operator>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("login")
    public ResponseEntity<Operator> login(@RequestBody Operator item) {
        try {
            List<Operator> items = new ArrayList<Operator>();

            repository.findAll().forEach(items::add);
            Operator admin = new Operator();
            admin.setIdOperator(-1); admin.setMail("fperez@pucp.pe"); admin.setPassword("123456");
            items.add(admin);

            items.removeIf(tempItem -> !tempItem.getMail().equals(item.getMail()) || !tempItem.getPassword().equals(item.getPassword()));
            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(items.get(0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Operator> getById(@PathVariable("id") Integer id) {
        Optional<Operator> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Operator> create(@RequestBody Operator item) {
        try {
            Operator savedItem = repository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Operator> update(@PathVariable("id") Integer id, @RequestBody Operator item) {
        Optional<Operator> existingItemOptional = repository.findById(id);
        
        if (existingItemOptional.isPresent()) {
            Operator existingItem = existingItemOptional.get();
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

    //@Scheduled(fixedDelay = 1500)
    public void checkApi() {
        System.out.println("Consuming from IoT device");
        // List<Operator> items = new ArrayList<Operator>();
        // repository.findAll().forEach(items::add);
        // items.removeIf(tempItem -> tempItem.getIotURL().isEmpty());
        // items.stream().forEach((operador)->{
        //     //Consuming the service
        //     //EstructuraIoT accountDetail = restTemplate.getForEntity(operador.getIotURL(), EstructuraIoT);

        //     //comprobar si ya existe course con la fecha
        //     if(1==1){
        //         //crear course
        //         Course newCourse = new Course();
        //         //asignar parámetros...
        //         repositoryCourse.save(newCourse);
                
        //     } else {
        //         //actualizar course
        //         Course newCourse = new Course();
        //         System.out.println(newCourse);
        //     }
                

        //     //grabar data en tabla de vehiculeLocation
        //         //crear vehiculeLocation
        //         //grabar alertas según reglas

        // });
    }
}
