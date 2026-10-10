package com.wildguard.wildguard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wildguard.wildguard.model.Animal;
import com.wildguard.wildguard.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Animal not found with ID: " + id));
    }

    public void deleteAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new RuntimeException("Animal not found with ID: " + id);
        }

        animalRepository.deleteById(id);
    }

    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        Animal existingAnimal = animalRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Animal not found with id: " + id));

        existingAnimal.setAnimalName(updatedAnimal.getAnimalName());
        existingAnimal.setSpecies(updatedAnimal.getSpecies());
        existingAnimal.setAge(updatedAnimal.getAge());
        existingAnimal.setHealthStatus(updatedAnimal.getHealthStatus());
        existingAnimal.setLocation(updatedAnimal.getLocation());

        return animalRepository.save(existingAnimal);
    }

}
