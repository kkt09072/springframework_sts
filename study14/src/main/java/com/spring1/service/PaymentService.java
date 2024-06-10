package com.spring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring1.dao.PaymentRepository;
import com.spring1.dto.PaymentDTO;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentDTO> getPaymentsList() {
        return paymentRepository.getPaymentsList();
    }
    
    public PaymentDTO getPaymentById(String paymentId) {
        return paymentRepository.getPaymentById(paymentId);
    }

    public List<PaymentDTO> getPaymentsByUserId(String userId) {
        return paymentRepository.getPaymentsByUserId(userId);
    }

    public void insertPayment(PaymentDTO payment) {
        paymentRepository.insertPayment(payment);
    }

    public void updatePayment(PaymentDTO payment) {
        paymentRepository.updatePayment(payment);
    }

    public void deletePayment(String paymentId) {
        paymentRepository.deletePayment(paymentId);
    }
}
