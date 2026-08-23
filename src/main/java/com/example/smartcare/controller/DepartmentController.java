package com.example.smartcare.controller;

import com.example.smartcare.entity.Department;
import com.example.smartcare.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // CREATE with full Doctor object in JSON
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.createDepartment(department));
    }

    // CREATE with headDoctorId only
    @PostMapping("/with-head-doctor/{headDoctorId}")
    public ResponseEntity<Department> createDepartmentWithHeadDoctor(
            @RequestBody Department department,
            @PathVariable Long headDoctorId) {
        return ResponseEntity.ok(departmentService.createDepartmentWithHeadDoctor(department, headDoctorId));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department record deleted successfully.");
    }
}
