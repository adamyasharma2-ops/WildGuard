
package com.wildguard.wildguard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildguard.wildguard.model.ProtectedArea;

public interface ProtectedAreaRepository
        extends JpaRepository<ProtectedArea, Long> {
}
