package com.spring1.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring1.dto.PaymentDTO;

@Repository
public class PaymentRepository {

    @Autowired
    private SqlSession sqlSession;

    public PaymentDTO getPaymentById(String paymentId) {
        return sqlSession.selectOne("payment.getPaymentById", paymentId);
    }

    public List<PaymentDTO> getPaymentsList() {
        return sqlSession.selectList("payment.getPaymentsList");
    }
    
    public List<PaymentDTO> getPaymentsByUserId(String userId) {
        return sqlSession.selectList("payment.getPaymentsByUserId", userId);
    }

    public void insertPayment(PaymentDTO payment) {
        sqlSession.insert("payment.insertPayment", payment);
    }

    public void updatePayment(PaymentDTO payment) {
        sqlSession.update("payment.updatePayment", payment);
    }

    public void deletePayment(String paymentId) {
        sqlSession.delete("payment.deletePayment", paymentId);
    }
}
