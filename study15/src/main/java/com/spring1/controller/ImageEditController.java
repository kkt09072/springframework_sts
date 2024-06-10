package com.spring1.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jhlabs.image.ContrastFilter;
import com.jhlabs.image.HSBAdjustFilter;

@Controller
@RequestMapping("/img")
public class ImageEditController {

	@Autowired
    private ServletContext servletContext; 

    @RequestMapping(value = "/upload2", method = RequestMethod.GET)
    public String showUploadForm() {
        return "img/uploadForm2";
    }

    @PostMapping("/uploadPro2")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("brightness") float brightness,
                                   @RequestParam("saturation") float saturation,
                                   @RequestParam("hue") float hue, Model model) throws IIOException {
    	
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

                if (image == null) {
                    model.addAttribute("message", "Failed to read input file!");
                    return "img/uploadResult2";
                }

                // Adjust brightness
                ContrastFilter brightnessFilter = new ContrastFilter();
                brightnessFilter.setBrightness(brightness);
                //brightnessFilter.setLights(brightness);
                BufferedImage brightImage = brightnessFilter.filter(image, null);

                // Adjust hue, saturation
                HSBAdjustFilter hsbAdjustFilter = new HSBAdjustFilter();
                hsbAdjustFilter.setHFactor(hue);
                hsbAdjustFilter.setSFactor(saturation);
                BufferedImage editedImage = hsbAdjustFilter.filter(brightImage, null);

                // Save the edited image
                String editedFileName = FilenameUtils.getBaseName(originalFileName) + "_edited." + extension;
                File editedFile = new File(UPLOAD_DIR + editedFileName);
                ImageIO.write(editedImage, extension, editedFile);

                model.addAttribute("message", "File uploaded and edited successfully!");
                model.addAttribute("originalFile", originalFileName);
                model.addAttribute("editedFile", editedFileName);
            } catch (IOException e) {
                model.addAttribute("message", "Failed to upload and edit file: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "File is empty!");
        }
        return "img/uploadResult2";
    }
}