package com.example.smartcare.service;

import com.example.smartcare.entity.BillDetails;
import java.util.List;

public interface BillDetailsService {
    BillDetails createBillDetail(BillDetails billDetails);
    List<BillDetails> getAllBillDetails();
    BillDetails getBillDetailById(Long id);
    BillDetails updateBillDetail(Long id, BillDetails billDetails);
    void deleteBillDetail(Long id);
}