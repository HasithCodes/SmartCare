package com.example.smartcare.service;

import com.example.smartcare.entity.Admission;
import com.example.smartcare.dto.AdmissionDTO;
import java.util.List;

public interface AdmissionService {

    // Entity-based methods
    Admission createAdmission(Admission admission);
    List<Admission> getAllAdmissions();
    Admission getAdmissionById(Long id);
    Admission updateAdmission(Long id, Admission updatedAdmission);
    void deleteAdmission(Long id);

    // DTO-based methods
    AdmissionDTO createAdmission(AdmissionDTO dto);
    List<AdmissionDTO> getAllAdmissionDTOs();
    AdmissionDTO getAdmissionDTOById(Long id);
    AdmissionDTO updateAdmission(Long id, AdmissionDTO dto);
}
