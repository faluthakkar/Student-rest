package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Entity.Receipt;
import com.example.SpringBoot.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/appointment/{id}")
    public void generateReceipt(@PathVariable Long id) {
        receiptService.generateReceipt(id);
    }
}
