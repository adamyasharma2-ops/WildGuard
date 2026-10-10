
package com.wildguard.wildguard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wildguard.wildguard.model.ProtectedArea;
import com.wildguard.wildguard.service.ProtectedAreaService;

@RestController
@RequestMapping("/api/protected-areas")
public class ProtectedAreaController {

    private final ProtectedAreaService protectedAreaService;

    public ProtectedAreaController(ProtectedAreaService protectedAreaService) {
        this.protectedAreaService = protectedAreaService;
    }

    // Create a protected area
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProtectedArea createProtectedArea(@RequestBody ProtectedArea area) {
        return protectedAreaService.saveProtectedArea(area);
    }

    // Get all protected areas
    @GetMapping
    public List<ProtectedArea> getAllProtectedAreas() {
        return protectedAreaService.getAllProtectedAreas();
    }

    // Get one protected area by ID
    @GetMapping("/{id}")
    public ProtectedArea getProtectedAreaById(@PathVariable Long id) {
        return protectedAreaService.getProtectedAreaById(id);
    }

    // Update a protected area
    @PutMapping("/{id}")
    public ProtectedArea updateProtectedArea(
            @PathVariable Long id,
            @RequestBody ProtectedArea area) {
        return protectedAreaService.updateProtectedArea(id, area);
    }

    // Delete a protected area
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProtectedArea(@PathVariable Long id) {
        protectedAreaService.deleteProtectedArea(id);
    }
}
