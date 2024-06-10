package com.spring1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring1.dto.Custom;
import com.spring1.dto.IamPortClient;
import com.spring1.dto.PaymentDTO;
import com.spring1.service.PaymentService;

@Controller
@RequestMapping("/payments/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private HttpSession session; 
    
    @GetMapping("list")
    public String getPaymentsList(Model model) {
        model.addAttribute("payments", paymentService.getPaymentsList());
        return "payments/list";
    }
    
    @GetMapping("list2")
    public String getPaymentsByUserId(Model model) {
    	String userId = (String) session.getAttribute("sid");
        List<PaymentDTO> payments = paymentService.getPaymentsByUserId(userId);
        model.addAttribute("payments", payments);
        return "payments/list";
    }

    @GetMapping("detail")
    public String getPaymentById(@RequestParam("paymentId") String paymentId, Model model) {
        PaymentDTO payment = paymentService.getPaymentById(paymentId);
        model.addAttribute("payment", payment);
        return "payments/detail";
    }

    @GetMapping("create")
    public String createPaymentForm(Model model) {
    	
    	IamPortClient iam = new IamPortClient();
    	model.addAttribute("cid", (String) session.getAttribute("sid"));
    	model.addAttribute("pno", 1);
    	model.addAttribute("pname", "최고의 상품");
    	model.addAttribute("cnt", 10);
    	model.addAttribute("com", "양질의 최고의 상품입니다.");
    	model.addAttribute("oprice", 5000);
    	model.addAttribute("code", IamPortClient.CODE);
    	model.addAttribute("paymentId", iam.getRandChar());
        model.addAttribute("payment", new PaymentDTO());
        return "payments/create";
    }

    @PostMapping("create")
    public String createPayment(@ModelAttribute PaymentDTO payment) {
        paymentService.insertPayment(payment);
        return "redirect:/payments/list";
    }

    @GetMapping("edit")
    public String editPaymentForm(@RequestParam("paymentId") String paymentId, Model model) {
        PaymentDTO payment = paymentService.getPaymentById(paymentId);
        model.addAttribute("payment", payment);
        return "payments/edit";
    }

    @PostMapping("edit")
    public String editPayment(@ModelAttribute PaymentDTO payment) {
        paymentService.updatePayment(payment);
        return "redirect:/payments/list";
    }

    @GetMapping("delete")
    public String deletePayment(@RequestParam("paymentId") String paymentId) {
        paymentService.deletePayment(paymentId);
        return "redirect:/payments/list";
    }
}
