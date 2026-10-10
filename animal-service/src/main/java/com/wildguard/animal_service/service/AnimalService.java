
package com.wildguard.animal_service.service;

import com.wildguard.animal_service.model.Animal;
import com.wildguard.animal_service.repository.AnimalRepository;

import org.springframework.stereotype.Service;
import java.util.List;

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
                .orElseThrow(() ->
                        new RuntimeException("Animal not found with ID: " + id));
    }

    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        Animal existingAnimal = getAnimalById(id);

        existingAnimal.setAnimalName(updatedAnimal.getAnimalName());
        existingAnimal.setSpecies(updatedAnimal.getSpecies());
        existingAnimal.setAge(updatedAnimal.getAge());
        existingAnimal.setHealthStatus(updatedAnimal.getHealthStatus());
        existingAnimal.setLocation(updatedAnimal.getLocation());

        return animalRepository.save(existingAnimal);
    }

    public void deleteAnimal(Long id) {
        Animal existingAnimal = getAnimalById(id);
        animalRepository.delete(existingAnimal);
    }
}
