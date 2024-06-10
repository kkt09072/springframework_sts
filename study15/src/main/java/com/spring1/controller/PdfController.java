package com.spring1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring1.service.PdfService;

@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/")
    public String index() {
        return "pdf/pdfCreate";
    }

    @PostMapping("/generatePdf")
    public String generatePdf(@RequestParam("text") String text, Model model) {
        String pdfPath = pdfService.generatePdfFromText(text);
        model.addAttribute("pdfPath", pdfPath);
        return "pdf/pdfView";
    }

    @GetMapping("/editPdf")
    public void editPdf(HttpServletResponse response) throws IOException {
        pdfService.editPdf(response.getOutputStream());
    }
}
