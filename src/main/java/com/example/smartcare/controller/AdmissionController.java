package com.example.smartcare.controller;

import com.example.smartcare.dto.AdmissionDTO;
import com.example.smartcare.entity.Admission;
import com.example.smartcare.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;


    @PostMapping
    public ResponseEntity<AdmissionDTO> createAdmission(@RequestBody AdmissionDTO admissionDTO) {
        return ResponseEntity.ok(admissionService.createAdmission(admissionDTO));
    }

    @GetMapping
    public ResponseEntity<List<AdmissionDTO>> getAllAdmissions() {
        return ResponseEntity.ok(admissionService.getAllAdmissionDTOs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdmissionDTO> getAdmissionById(@PathVariable Long id) {
        return ResponseEntity.ok(admissionService.getAdmissionDTOById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdmissionDTO> updateAdmission(@PathVariable Long id,
                                                        @RequestBody AdmissionDTO admissionDTO) {
        return ResponseEntity.ok(admissionService.updateAdmission(id, admissionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmission(@PathVariable Long id) {
        admissionService.deleteAdmission(id);
        return ResponseEntity.ok("Admission record deleted successfully.");
    }

    @GetMapping("/entity")
    public ResponseEntity<List<Admission>> getAllAdmissionEntities() {
        return ResponseEntity.ok(admissionService.getAllAdmissions());
    }
}
