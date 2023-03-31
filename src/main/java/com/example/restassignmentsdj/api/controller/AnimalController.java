package com.example.restassignmentsdj.api.controller;

import com.example.restassignmentsdj.api.model.Animal;
import com.example.restassignmentsdj.persistance.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animal/")
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals()
    {
         return new ResponseEntity<>(animalService.getAllAnimals(), HttpStatus.OK);
    }

    @GetMapping("regNumber/{regNumber}")
    public ResponseEntity<Animal> getAnimalByRegNumber(@PathVariable long regNumber)
    {
        Optional<Animal> existing = animalService.getAnimalByRegNumber(regNumber);
        if(existing.isPresent())
            return new ResponseEntity<>(existing.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("animalsFromDate/")
    public ResponseEntity<List<Animal>> getAllAnimalsFromDate(String date)
    {
        System.out.println(animalService.getAllAnimalsFromDate(LocalDate.parse(date)));
        Optional<List<Animal>> existing = Optional.of(animalService.getAllAnimalsFromDate(LocalDate.parse(date)));
        if(existing.isPresent())
            return new ResponseEntity<>(existing.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping("animalsOfOrigin/")
    public ResponseEntity<List<Animal>> getAllAnimalsOfOrigin(@RequestParam String origin)
    {
        Optional<List<Animal>> existing = Optional.of(animalService.getAllAnimalsFromOrigin(origin));
        if(existing.isPresent())
            return new ResponseEntity<>(existing.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping()
    public ResponseEntity<Animal> addNewAnimal(@RequestBody Animal animal)
    {
        boolean success = animalService.addAnimal(animal);
        if(success) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping()
//    public ResponseEntity changeAnimal(@RequestBody long regNumber, @RequestBody Animal animal)
//    {
//        if(regNumber != animal.getRegNumber())
//        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        boolean success = animalService.changeAnimal(animal);
//        if(success) {
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @DeleteMapping
    public ResponseEntity removeAnimal(long regNumber)
    {
        animalService.removeAnimalByRegNumber(regNumber);
        return new ResponseEntity(HttpStatus.OK);
    }
}
