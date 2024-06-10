package com.spring1.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring1.dto.Weather;
import com.spring1.service.WeatherService;

@Controller
public class WeatherController {

	private static final Logger log = LoggerFactory.getLogger(WeatherController.class);
	
    @Autowired
    private WeatherService wService;

    @GetMapping("/weather/home")
    public String weatherHome(Model model) {
        return "weather/home";
    }

    @PostMapping("/weather/result")
    public String resultData(@RequestParam("baseDate") String baseDate, @RequestParam("nx") String nx, @RequestParam("ny") String ny, Model model) {
    	
    	log.info("baseDate : {}", baseDate);
    	log.info("nx : {}", nx);
    	log.info("ny : {}", ny);
    	
        try {
            if (baseDate == null || baseDate.isEmpty() || nx == null || nx.isEmpty() || ny == null || ny.isEmpty()) {
                model.addAttribute("error", "Invalid input data");
                return "error";
            }

            Weather w = wService.resultData(Weather.serviceKey, baseDate, nx, ny);
            
            log.info("controller : "+w.toString());
            
            model.addAttribute("weather", w);
            return "weather/result";
        } catch (IOException | ParseException e) {
            model.addAttribute("error", "Error processing request: " + e.getMessage());
            return "weather/home";
        }
    }
}