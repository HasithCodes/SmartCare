package com.example.smartcare.controller;

import com.example.smartcare.entity.BillDetails;
import com.example.smartcare.service.BillDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bill-details")
public class BillDetailsController {

    @Autowired
    private BillDetailsService billDetailsService;

    @PostMapping
    public ResponseEntity<BillDetails> createBillDetail(@RequestBody BillDetails billDetails) {
        return ResponseEntity.ok(billDetailsService.createBillDetail(billDetails));
    }

    @GetMapping
    public ResponseEntity<List<BillDetails>> getAllBillDetails() {
        return ResponseEntity.ok(billDetailsService.getAllBillDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDetails> getBillDetailById(@PathVariable Long id) {
        return ResponseEntity.ok(billDetailsService.getBillDetailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDetails> updateBillDetail(@PathVariable Long id, @RequestBody BillDetails billDetails) {
        return ResponseEntity.ok(billDetailsService.updateBillDetail(id, billDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBillDetail(@PathVariable Long id) {
        billDetailsService.deleteBillDetail(id);
        return ResponseEntity.ok("Bill detail record deleted successfully.");
    }
}