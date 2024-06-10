package com.spring1.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

	@Autowired
	private ServletContext servletContext;

    public String generatePdfFromText(String text) {
    	String path = servletContext.getRealPath("/resources/upload/");
    	File fontFile = new File(path+"MALGUN.TTF");
    	InputStream inputStream = getClass().getResourceAsStream("/fonts/MALGUN.TTF");
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
        	PDType0Font font = PDType0Font.load(document, inputStream);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(font, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText(text);
                contentStream.endText();
            }

            String filePath = path+"generated.pdf";
            document.save(filePath);
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void editPdf(ServletOutputStream servletOutputStream) throws IOException {
        // 여기에 PDF 편집 로직 추가
        // 예: 기존 PDF 파일 로드, 수정, 저장
    	String path = servletContext.getContextPath();
        // 예시 로직: 기존 PDF에 이미지 추가
        PDDocument document = PDDocument.load(new File(path+"/resources/upload/generated.pdf"));
        PDPage page = document.getPage(0);

        PDImageXObject pdImage = PDImageXObject.createFromFile(path+"/resources/upload/image.jpg", document);
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
        contentStream.drawImage(pdImage, 100, 500);
        contentStream.close();

        document.save(servletOutputStream);
        document.close();
    }
}