
package com.wildguard.wildguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildguard.wildguard.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
