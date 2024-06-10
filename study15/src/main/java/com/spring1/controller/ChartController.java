package com.spring1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/chart")
public class ChartController {

    @GetMapping("/chart-data")
    @ResponseBody
    public ResponseEntity<String> getChartData() {
        Map<String, Object> data = new HashMap<>();
        data.put("lineChart", new int[]{10, 20, 30, 40, 50});
        data.put("barChart", new int[]{15, 25, 35, 45, 55});
        data.put("columnChart", new int[]{20, 30, 40, 50, 60});
        data.put("pieChart", new int[]{5, 15, 25, 35, 45});
        data.put("radarChart", new int[]{12, 22, 32, 42, 52, 62});
        data.put("scatterChart", new int[][]{{5, 3}, {10, 17}, {15, 7}, {20, 12}, {25, 19}});
        data.put("mapChart", new Object[][]{{"서울", 1000000}, {"부산", 800000}, {"인천", 700000}, {"대구", 600000}, {"광주", 500000}});
        Gson gson = new Gson();
        String json = gson.toJson(data);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
        
    }

    @GetMapping("/charts")
    public String getChartsPage(Model model) {
        return "chart/charts";
    }
}
