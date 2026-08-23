package com.example.smartcare.service;

import com.example.smartcare.entity.Treatment;
import java.util.List;

public interface TreatmentService {
    Treatment createTreatment(Treatment treatment);
    List<Treatment> getAllTreatments();
    Treatment getTreatmentById(Long id);
    Treatment updateTreatment(Long id, Treatment treatment);
    void deleteTreatment(Long id);
}