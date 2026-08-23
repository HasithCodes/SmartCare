package com.example.smartcare.controller;

import com.example.smartcare.entity.Bed;
import com.example.smartcare.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    @Autowired
    private BedService bedService;

    // CREATE
    @PostMapping
    public ResponseEntity<Bed> createBed(@RequestBody Bed bed) {
        return ResponseEntity.ok(bedService.createBed(bed));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Bed>> getAllBeds() {
        return ResponseEntity.ok(bedService.getAllBeds());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBedById(@PathVariable Long id) {
        return ResponseEntity.ok(bedService.getBedById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Bed> updateBed(@PathVariable Long id, @RequestBody Bed bed) {
        return ResponseEntity.ok(bedService.updateBed(id, bed));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBed(@PathVariable Long id) {
        bedService.deleteBed(id);
        return ResponseEntity.ok("Bed record deleted successfully.");
    }
}