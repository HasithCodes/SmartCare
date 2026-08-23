package com.example.smartcare.controller;

import com.example.smartcare.entity.LaboratoryTest;
import com.example.smartcare.service.LaboratoryTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lab-tests")
public class LaboratoryTestController {

    @Autowired
    private LaboratoryTestService laboratoryTestService;

    @PostMapping
    public ResponseEntity<LaboratoryTest> createLaboratoryTest(@RequestBody LaboratoryTest labTest) {
        return ResponseEntity.ok(laboratoryTestService.createLaboratoryTest(labTest));
    }

    @GetMapping
    public ResponseEntity<List<LaboratoryTest>> getAllLaboratoryTests() {
        return ResponseEntity.ok(laboratoryTestService.getAllLaboratoryTests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryTest> getLaboratoryTestById(@PathVariable Long id) {
        return ResponseEntity.ok(laboratoryTestService.getLaboratoryTestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaboratoryTest> updateLaboratoryTest(@PathVariable Long id, @RequestBody LaboratoryTest labTest) {
        return ResponseEntity.ok(laboratoryTestService.updateLaboratoryTest(id, labTest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLaboratoryTest(@PathVariable Long id) {
        laboratoryTestService.deleteLaboratoryTest(id);
        return ResponseEntity.ok("Lab test record deleted successfully.");
    }
}