package com.example.smartcare.service.impl;

import com.example.smartcare.entity.Bill;
import com.example.smartcare.repository.BillRepository;
import com.example.smartcare.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill createBill(Bill bill) { return billRepository.save(bill); }

    @Override
    public List<Bill> getAllBills() { return billRepository.findAll(); }

    @Override
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill record not found with id: " + id));
    }

    @Override
    public Bill updateBill(Long id, Bill updatedBill) {
        Bill existingBill = getBillById(id);
        existingBill.setBillDate(updatedBill.getBillDate());
        existingBill.setTotalAmount(updatedBill.getTotalAmount());
        existingBill.setPaymentStatus(updatedBill.getPaymentStatus());
        existingBill.setPaymentMethod(updatedBill.getPaymentMethod());
        existingBill.setPatient(updatedBill.getPatient());
        existingBill.setAppointment(updatedBill.getAppointment());
        existingBill.setAdmission(updatedBill.getAdmission());
        return billRepository.save(existingBill);
    }

    @Override
    public void deleteBill(Long id) { billRepository.delete(getBillById(id)); }
}