
package com.wildguard.wildguard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wildguard.wildguard.model.ProtectedArea;
import com.wildguard.wildguard.repository.ProtectedAreaRepository;

@Service
public class ProtectedAreaService {

    private final ProtectedAreaRepository protectedAreaRepository;

    public ProtectedAreaService(ProtectedAreaRepository protectedAreaRepository) {
        this.protectedAreaRepository = protectedAreaRepository;
    }

    // Create a protected area
    public ProtectedArea saveProtectedArea(ProtectedArea area) {
        return protectedAreaRepository.save(area);
    }

    // Get all protected areas
    public List<ProtectedArea> getAllProtectedAreas() {
        return protectedAreaRepository.findAll();
    }

    // Get one protected area by ID
    public ProtectedArea getProtectedAreaById(Long id) {
        return protectedAreaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Protected area not found with ID: " + id));
    }

    // Update a protected area
    public ProtectedArea updateProtectedArea(Long id, ProtectedArea updatedArea) {
        ProtectedArea existingArea = getProtectedAreaById(id);

        existingArea.setAreaName(updatedArea.getAreaName());
        existingArea.setAreaType(updatedArea.getAreaType());
        existingArea.setState(updatedArea.getState());
        existingArea.setAreaSize(updatedArea.getAreaSize());
        existingArea.setDescription(updatedArea.getDescription());

        return protectedAreaRepository.save(existingArea);
    }

    // Delete a protected area
    public void deleteProtectedArea(Long id) {
        ProtectedArea existingArea = getProtectedAreaById(id);
        protectedAreaRepository.delete(existingArea);
    }
}
