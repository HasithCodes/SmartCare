package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Doctor;
import com.example.smartcare.repository.DoctorRepository;
import com.example.smartcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor record not found with id: " + id));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Doctor existingDoctor = getDoctorById(id);

        existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
        existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
        existingDoctor.setQualification(updatedDoctor.getQualification());
        existingDoctor.setContactNumber(updatedDoctor.getContactNumber());
        existingDoctor.setConsultationFee(updatedDoctor.getConsultationFee());
        existingDoctor.setDepartment(updatedDoctor.getDepartment());

        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor existingDoctor = getDoctorById(id);
        doctorRepository.delete(existingDoctor);
    }
}