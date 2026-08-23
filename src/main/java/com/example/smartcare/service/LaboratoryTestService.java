package com.example.smartcare.service;

import com.example.smartcare.entity.LaboratoryTest;
import java.util.List;

public interface LaboratoryTestService {
    LaboratoryTest createLaboratoryTest(LaboratoryTest labTest);
    List<LaboratoryTest> getAllLaboratoryTests();
    LaboratoryTest getLaboratoryTestById(Long id);
    LaboratoryTest updateLaboratoryTest(Long id, LaboratoryTest labTest);
    void deleteLaboratoryTest(Long id);
}