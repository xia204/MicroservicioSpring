package com.example.demo.service;

import com.example.demo.model.StatusP;
import com.example.demo.repository.StatusPRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusPService {

    private final StatusPRepository repository;

    public StatusPService(StatusPRepository repository) {
        this.repository = repository;
    }

    public List<StatusP> getAll() {
        return repository.findAll();
    }

    public Optional<StatusP> getById(String id) {
        return repository.findById(id);
    }

    public StatusP create(StatusP status) {
        return repository.save(status);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Optional<StatusP> update(String id, StatusP newStatus) {
        return repository.findById(id)
                .map(existingStatus -> {
                    existingStatus.setNombre(newStatus.getNombre());
                    existingStatus.setFechaCreacion(newStatus.getFechaCreacion());
                    return repository.save(existingStatus);
                });
    }

}
