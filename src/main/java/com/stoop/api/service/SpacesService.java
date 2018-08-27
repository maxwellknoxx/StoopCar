package com.stoop.api.service;

import java.util.Optional;

import com.stoop.api.entities.Spaces;

public interface SpacesService {

	public Optional<Spaces> findById(Long id);

	void saveOrUpdate(Spaces spaces);

}
