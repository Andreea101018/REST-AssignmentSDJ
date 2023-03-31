package com.example.restassignmentsdj.persistance;

import com.example.restassignmentsdj.api.model.Animal;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private List<Animal> animals;

    public AnimalService() {
        this.animals = new ArrayList<>();

        animals.add(new Animal(LocalDate.of(2023, 11, 23), 12.5, 1234, "FarmVille1"));
        animals.add(new Animal(LocalDate.of(2023, 10,29), 188.5, 1235, "FarmVille2"));
        animals.add(new Animal(LocalDate.of(2023, 11,21), 12.5, 1236, "FarmVille3"));
        animals.add(new Animal(LocalDate.of(2023, 5,22), 12.5, 1237, "FarmVille4"));
    }

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public Optional getAnimalByRegNumber(long regNumber) {
        Optional<Animal> existing = Optional.empty();
        for (Animal animal : animals) {
            if (animal.getRegNumber() == regNumber) existing = Optional.of(animal);
        }
        return existing;
    }

    public boolean addAnimal(Animal animal) {
        Optional<Animal> existing = getAnimalByRegNumber(animal.getRegNumber());
        if (existing.isPresent()) {
            return false;
        } else {
            animals.add(animal);
            return true;
        }
    }

    public boolean changeAnimal(Animal animal) {
        System.out.println(animal.getRegNumber());
        Optional<Animal> existing = getAnimalByRegNumber(animal.getRegNumber());
        if (existing.isPresent()) {
            animals.remove(existing.get());
            animals.add(animal);
            return true;
        } else {
//            animals.add(animal);
            return false;
        }
    }

    public void removeAnimalByRegNumber(long regNumber) {
        Optional<Animal> existing = getAnimalByRegNumber(regNumber);
        if (existing.isPresent()) {
            animals.remove(existing.get());
        }

    }

    public List<Animal> getAllAnimalsFromDate(LocalDate arrivingDate)
    {
        List<Animal> animals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getArrivingDate().equals(arrivingDate)) animals.add(animal);
        }
        return animals;
    }

    public List<Animal> getAllAnimalsFromOrigin(String origin)
    {
        List<Animal> animals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getOrigin().equals(origin)) animals.add(animal);
        }
        return animals;
    }
}
