package com.example.smartcare.controller;

import com.example.smartcare.entity.Treatment;
import com.example.smartcare.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @PostMapping
    public ResponseEntity<Treatment> createTreatment(@RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentService.createTreatment(treatment));
    }

    @GetMapping
    public ResponseEntity<List<Treatment>> getAllTreatments() {
        return ResponseEntity.ok(treatmentService.getAllTreatments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable Long id) {
        return ResponseEntity.ok(treatmentService.getTreatmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treatment> updateTreatment(@PathVariable Long id, @RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentService.updateTreatment(id, treatment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteTreatment(id);
        return ResponseEntity.ok("Treatment record deleted successfully.");
    }
}