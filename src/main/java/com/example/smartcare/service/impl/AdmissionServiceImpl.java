package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Admission;
import com.example.smartcare.entity.Patient;
import com.example.smartcare.entity.Bed;
import com.example.smartcare.dto.AdmissionDTO;
import com.example.smartcare.repository.AdmissionRepository;
import com.example.smartcare.repository.PatientRepository;
import com.example.smartcare.repository.BedRepository;
import com.example.smartcare.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private BedRepository bedRepository;

    @Override
    public Admission createAdmission(Admission admission) {
        return admissionRepository.save(admission);
    }

    @Override
    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    @Override
    public Admission getAdmissionById(Long id) {
        return admissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admission record not found with id: " + id));
    }

    @Override
    public Admission updateAdmission(Long id, Admission updatedAdmission) {
        Admission existingAdmission = getAdmissionById(id);

        existingAdmission.setAdmissionDate(updatedAdmission.getAdmissionDate());
        existingAdmission.setDischargeDate(updatedAdmission.getDischargeDate());
        existingAdmission.setAdmissionStatus(updatedAdmission.getAdmissionStatus());
        existingAdmission.setPatient(updatedAdmission.getPatient());
        existingAdmission.setBed(updatedAdmission.getBed());

        return admissionRepository.save(existingAdmission);
    }

    @Override
    public void deleteAdmission(Long id) {
        Admission existingAdmission = getAdmissionById(id);
        admissionRepository.delete(existingAdmission);
    }

    @Override
    public AdmissionDTO createAdmission(AdmissionDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + dto.getPatientId()));
        Bed bed = bedRepository.findById(dto.getBedId())
                .orElseThrow(() -> new RuntimeException("Bed not found with ID: " + dto.getBedId()));

        Admission admission = new Admission();
        admission.setAdmissionDate(java.time.LocalDateTime.parse(dto.getAdmissionDate()));
        admission.setDischargeDate(java.time.LocalDateTime.parse(dto.getDischargeDate()));
        admission.setAdmissionStatus(dto.getAdmissionStatus());
        admission.setPatient(patient);
        admission.setBed(bed);

        Admission saved = admissionRepository.save(admission);
        return convertToDTO(saved);
    }

    @Override
    public List<AdmissionDTO> getAllAdmissionDTOs() {
        return admissionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public AdmissionDTO getAdmissionDTOById(Long id) {
        Admission admission = getAdmissionById(id);
        return convertToDTO(admission);
    }

    @Override
    public AdmissionDTO updateAdmission(Long id, AdmissionDTO dto) {
        Admission existingAdmission = getAdmissionById(id);

        existingAdmission.setAdmissionDate(java.time.LocalDateTime.parse(dto.getAdmissionDate()));
        existingAdmission.setDischargeDate(java.time.LocalDateTime.parse(dto.getDischargeDate()));
        existingAdmission.setAdmissionStatus(dto.getAdmissionStatus());

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + dto.getPatientId()));
        Bed bed = bedRepository.findById(dto.getBedId())
                .orElseThrow(() -> new RuntimeException("Bed not found with ID: " + dto.getBedId()));

        existingAdmission.setPatient(patient);
        existingAdmission.setBed(bed);

        Admission updated = admissionRepository.save(existingAdmission);
        return convertToDTO(updated);
    }

    private AdmissionDTO convertToDTO(Admission admission) {
        AdmissionDTO dto = new AdmissionDTO();
        dto.setAdmissionId(admission.getAdmissionId());
        dto.setAdmissionDate(admission.getAdmissionDate().toString());
        dto.setDischargeDate(admission.getDischargeDate().toString());
        dto.setAdmissionStatus(admission.getAdmissionStatus());
        dto.setPatientId(admission.getPatient().getPatientId());
        dto.setBedId(admission.getBed().getBedId());
        return dto;
    }
}
