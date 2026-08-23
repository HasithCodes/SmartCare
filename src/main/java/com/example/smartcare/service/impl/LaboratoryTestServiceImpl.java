package com.example.smartcare.service.impl;

import com.example.smartcare.entity.LaboratoryTest;
import com.example.smartcare.repository.LaboratoryTestRepository;
import com.example.smartcare.service.LaboratoryTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaboratoryTestServiceImpl implements LaboratoryTestService {

    @Autowired
    private LaboratoryTestRepository laboratoryTestRepository;

    @Override
    public LaboratoryTest createLaboratoryTest(LaboratoryTest labTest) { return laboratoryTestRepository.save(labTest); }

    @Override
    public List<LaboratoryTest> getAllLaboratoryTests() { return laboratoryTestRepository.findAll(); }

    @Override
    public LaboratoryTest getLaboratoryTestById(Long id) {
        return laboratoryTestRepository.findById(id).orElseThrow(() -> new RuntimeException("Lab test not found with id: " + id));
    }

    @Override
    public LaboratoryTest updateLaboratoryTest(Long id, LaboratoryTest updatedTest) {
        LaboratoryTest existingTest = getLaboratoryTestById(id);
        existingTest.setTestName(updatedTest.getTestName());
        existingTest.setTestDate(updatedTest.getTestDate());
        existingTest.setTestResult(updatedTest.getTestResult());
        existingTest.setTechnicianName(updatedTest.getTechnicianName());
        existingTest.setTestStatus(updatedTest.getTestStatus());
        existingTest.setPatient(updatedTest.getPatient());
        existingTest.setDoctor(updatedTest.getDoctor());
        return laboratoryTestRepository.save(existingTest);
    }

    @Override
    public void deleteLaboratoryTest(Long id) { laboratoryTestRepository.delete(getLaboratoryTestById(id)); }
}