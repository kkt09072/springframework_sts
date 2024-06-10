package com.spring1.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/img")
public class ImageUploadController {

    @Autowired
    private ServletContext servletContext; 
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadForm() {
        return "img/uploadForm";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
    	
    	String UPLOAD_DIR = servletContext.getRealPath("/resources/upload/");
    	
        if (!file.isEmpty()) {
            try {
                // Save the original file
                String originalFileName = file.getOriginalFilename();
                String extension = FilenameUtils.getExtension(originalFileName);
                File originalFile = new File(UPLOAD_DIR + originalFileName);
                file.transferTo(originalFile);

                // Read the image
                BufferedImage image = ImageIO.read(originalFile);

                // Resize the image
                BufferedImage resizedImage = Scalr.resize(image, 250);

                // Save the resized image
                String resizedFileName = FilenameUtils.getBaseName(originalFileName) + "_resized." + extension;
                File resizedFile = new File(UPLOAD_DIR + resizedFileName);
                ImageIO.write(resizedImage, extension, resizedFile);

                model.addAttribute("message", "File uploaded and resized successfully!");
                model.addAttribute("originalFile", originalFileName);
                model.addAttribute("resizedFile", resizedFileName);
            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload and resize file: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "File is empty!");
        }
        return "img/uploadResult";
    }
}
