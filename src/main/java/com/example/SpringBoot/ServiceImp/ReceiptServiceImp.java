package com.example.SpringBoot.ServiceImp;

import com.example.SpringBoot.Entity.Appointment;
import com.example.SpringBoot.Entity.Receipt;
import com.example.SpringBoot.Repository.AppointmentRepository;
import com.example.SpringBoot.Repository.ReceiptRepository;
import com.example.SpringBoot.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
public class ReceiptServiceImp  implements ReceiptService {

    @Autowired
    private EmailService emailService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ReceiptRepository receiptRepository;

    public void generateReceipt(Long id) {

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(Math.toIntExact(id));
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            String to = appointment.getUser().getEmail();
            String subject = "Appointment Receipt";
            StringBuilder message = new StringBuilder();
            message.append("Dear " + appointment.getUser().getFirstName() + " " + appointment.getUser().getLastName() + ",\n\n");
            message.append("Thank you for your appointment with us. Please find the details of your appointment and receipt below:\n\n");
            message.append("Appointment Details:\n");
            message.append("Date: " + appointment.getDate() + "\n");
            message.append("Time: " + appointment.getStartTime() + "\n");
            message.append("Total Charge: " + appointment.calculateTotalCharge() + "\n\n");
            message.append("Receipt:\n");
            message.append("User Name: " + appointment.getUser().getFirstName() + " " + appointment.getUser().getLastName() + "\n");
            message.append("Email: " + appointment.getUser().getEmail() + "\n");
            message.append("Total Charge: " + appointment.calculateTotalCharge() + "\n\n");
            message.append("Thank you for choosing us. We look forward to seeing you again.\n\n");
            message.append("Best regards,\n");
            message.append("Medicare Healthcare");

            emailService.sendSimpleMessage(to, subject, message.toString());
        } else {
            // handle the case where the Appointment with the given id is not found
        }
    }
}
