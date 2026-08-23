package com.example.smartcare.service;

import com.example.smartcare.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department createDepartmentWithHeadDoctor(Department department, Long headDoctorId); // ✅ new method
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
}
