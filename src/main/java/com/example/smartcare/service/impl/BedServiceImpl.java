package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Bed;
import com.example.smartcare.repository.BedRepository;
import com.example.smartcare.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedRepository bedRepository;

    @Override
    public Bed createBed(Bed bed) {
        return bedRepository.save(bed);
    }

    @Override
    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    @Override
    public Bed getBedById(Long id) {
        return bedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bed record not found with id: " + id));
    }

    @Override
    public Bed updateBed(Long id, Bed updatedBed) {
        Bed existingBed = getBedById(id);
        existingBed.setBedNumber(updatedBed.getBedNumber());
        existingBed.setBedStatus(updatedBed.getBedStatus());
        existingBed.setRoom(updatedBed.getRoom());
        return bedRepository.save(existingBed);
    }

    @Override
    public void deleteBed(Long id) {
        Bed existingBed = getBedById(id);
        bedRepository.delete(existingBed);
    }
}