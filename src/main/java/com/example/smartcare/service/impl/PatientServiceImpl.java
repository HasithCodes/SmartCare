package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Patient;
import com.example.smartcare.repository.PatientRepository;
import com.example.smartcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient record not found with id: " + id));
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existingPatient = getPatientById(id);

        existingPatient.setFullName(updatedPatient.getFullName());
        existingPatient.setDob(updatedPatient.getDob());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setContactDetails(updatedPatient.getContactDetails());
        existingPatient.setBloodGroup(updatedPatient.getBloodGroup());
        existingPatient.setEmergencyContact(updatedPatient.getEmergencyContact());

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient existingPatient = getPatientById(id);
        patientRepository.delete(existingPatient);
    }
}