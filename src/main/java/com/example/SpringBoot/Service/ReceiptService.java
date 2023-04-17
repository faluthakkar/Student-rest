package com.example.SpringBoot.Service;

import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Entity.Receipt;

public interface ReceiptService {
   void generateReceipt(Long id);
}
