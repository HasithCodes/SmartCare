package com.example.smartcare.service;

import com.example.smartcare.entity.Bed;
import java.util.List;

public interface BedService {
    Bed createBed(Bed bed);
    List<Bed> getAllBeds();
    Bed getBedById(Long id);
    Bed updateBed(Long id, Bed bed);
    void deleteBed(Long id);
}