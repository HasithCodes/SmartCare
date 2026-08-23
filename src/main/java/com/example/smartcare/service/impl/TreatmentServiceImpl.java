package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Treatment;
import com.example.smartcare.repository.TreatmentRepository;
import com.example.smartcare.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    public Treatment createTreatment(Treatment treatment) { return treatmentRepository.save(treatment); }

    @Override
    public List<Treatment> getAllTreatments() { return treatmentRepository.findAll(); }

    @Override
    public Treatment getTreatmentById(Long id) {
        return treatmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Treatment record not found with id: " + id));
    }

    @Override
    public Treatment updateTreatment(Long id, Treatment updatedTreatment) {
        Treatment existingTreatment = getTreatmentById(id);
        existingTreatment.setDiagnosis(updatedTreatment.getDiagnosis());
        existingTreatment.setPrescriptionDetails(updatedTreatment.getPrescriptionDetails());
        existingTreatment.setTreatmentNotes(updatedTreatment.getTreatmentNotes());
        existingTreatment.setTreatmentDate(updatedTreatment.getTreatmentDate());
        existingTreatment.setPatient(updatedTreatment.getPatient());
        existingTreatment.setDoctor(updatedTreatment.getDoctor());
        return treatmentRepository.save(existingTreatment);
    }

    @Override
    public void deleteTreatment(Long id) { treatmentRepository.delete(getTreatmentById(id)); }
}