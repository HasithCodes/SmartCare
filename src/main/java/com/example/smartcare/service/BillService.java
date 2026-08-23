package com.example.smartcare.service;

import com.example.smartcare.entity.Bill;
import java.util.List;

public interface BillService {
    Bill createBill(Bill bill);
    List<Bill> getAllBills();
    Bill getBillById(Long id);
    Bill updateBill(Long id, Bill bill);
    void deleteBill(Long id);
}