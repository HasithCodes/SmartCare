package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Department;
import com.example.smartcare.entity.Doctor;
import com.example.smartcare.exception.ResourceNotFoundException;
import com.example.smartcare.repository.DepartmentRepository;
import com.example.smartcare.repository.DoctorRepository;
import com.example.smartcare.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Department createDepartment(Department department) {
        if (department.getHeadDoctor() != null && department.getHeadDoctor().getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(department.getHeadDoctor().getDoctorId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Doctor not found with ID: " + department.getHeadDoctor().getDoctorId()));
            department.setHeadDoctor(doctor);
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department createDepartmentWithHeadDoctor(Department department, Long headDoctorId) {
        Doctor doctor = doctorRepository.findById(headDoctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + headDoctorId));
        department.setHeadDoctor(doctor);
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department record not found with id: " + id));
    }

    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department existingDepartment = getDepartmentById(id);

        existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
        existingDepartment.setLocation(updatedDepartment.getLocation());

        if (updatedDepartment.getHeadDoctor() != null && updatedDepartment.getHeadDoctor().getDoctorId() != null) {
            Doctor doctor = doctorRepository.findById(updatedDepartment.getHeadDoctor().getDoctorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " +
                            updatedDepartment.getHeadDoctor().getDoctorId()));
            existingDepartment.setHeadDoctor(doctor);
        }

        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department existingDepartment = getDepartmentById(id);
        departmentRepository.delete(existingDepartment);
    }
}
