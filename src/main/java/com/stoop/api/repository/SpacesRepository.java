package com.stoop.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stoop.api.entities.Spaces;

public interface SpacesRepository extends JpaRepository<Spaces, Long> {
	
	Optional<Spaces> findById(Long id);

}
