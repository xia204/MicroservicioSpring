package com.example.demo.controller;

import com.example.demo.model.StatusP;
import com.example.demo.service.StatusPService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusPController {

    private final StatusPService service;

    public StatusPController(StatusPService service) {
        this.service = service;
    }

    @GetMapping
    public List<StatusP> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusP> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StatusP create(@RequestBody StatusP status) {
        return service.create(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusP> update(@PathVariable String id, @RequestBody StatusP status) {
        return service.update(id, status)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
