package com.example.smartcare.service.impl;

import com.example.smartcare.entity.BillDetails;
import com.example.smartcare.repository.BillDetailsRepository;
import com.example.smartcare.service.BillDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BillDetailsServiceImpl implements BillDetailsService {

    @Autowired
    private BillDetailsRepository billDetailsRepository;

    @Override
    public BillDetails createBillDetail(BillDetails billDetails) { return billDetailsRepository.save(billDetails); }

    @Override
    public List<BillDetails> getAllBillDetails() { return billDetailsRepository.findAll(); }

    @Override
    public BillDetails getBillDetailById(Long id) {
        return billDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill detail item not found with id: " + id));
    }

    @Override
    public BillDetails updateBillDetail(Long id, BillDetails updatedDetail) {
        BillDetails existingDetail = getBillDetailById(id);
        existingDetail.setChargeType(updatedDetail.getChargeType());
        existingDetail.setChargeAmount(updatedDetail.getChargeAmount());
        existingDetail.setBill(updatedDetail.getBill());
        return billDetailsRepository.save(existingDetail);
    }

    @Override
    public void deleteBillDetail(Long id) { billDetailsRepository.delete(getBillDetailById(id)); }
}