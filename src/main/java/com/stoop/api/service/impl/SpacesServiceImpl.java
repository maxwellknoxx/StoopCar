package com.stoop.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoop.api.entities.Spaces;
import com.stoop.api.repository.SpacesRepository;
import com.stoop.api.service.SpacesService;

@Service
public class SpacesServiceImpl implements SpacesService {

	@Autowired
	private SpacesRepository spacesRepository;

	@Override
	public Optional<Spaces> findById(Long id) {
		Optional<Spaces> space = spacesRepository.findById(id);
		return space;
	}

	@Override
	public void saveOrUpdate(Spaces space) {
		spacesRepository.save(space);
	}

}
