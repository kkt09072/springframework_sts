package com.spring1.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;

@Controller
public class WebCrawlerController {

	private static final Logger log = LoggerFactory.getLogger(WebCrawlerController.class);
	
	@GetMapping("/crawl")
	public String crawl(Model model) {
	    String url = "https://www.moel.go.kr/info/realpolicy/realPolicyMain.do";
	    Map<String, Object> data = new HashMap<>();

	    try {
	        Document doc = Jsoup.connect(url).timeout(2000).get();
	        
	        log.info("문서 : {}", doc);
	        
	        Elements titles = doc.select("#contents_title");
	        String titleText = titles.isEmpty() ? "제목을 찾을 수 없습니다." : titles.get(0).text();
	        
	        log.info("문서 제목 : {}", titleText);
	        
	        // 데이터에 제목 추가
	        data.put("title", titleText);
	        
	        Elements comment = doc.select(".title2");
	        Elements numlist = doc.select(".num_list li");

	        if (comment != null) {
	            // 각 행의 데이터를 리스트로 저장
	            List<String> rowDataList = new ArrayList<>();
	            for (Element row : comment) {
	                rowDataList.add(row.text());
	                log.info("내용 : {}", row.text());
	            }
	            // 데이터에 행 데이터 추가
	            data.put("rowData", rowDataList);
	        } else {
	            System.out.println("class가 'title2'인 요소를 찾을 수 없습니다.");
	        }
	        
	        if (numlist != null) {
	            // 각 행의 데이터를 리스트로 저장
	        	
	            List<String> rowDataList2 = new ArrayList<>();
	            for (int i=0;i<numlist.size();i++) {
	            	Element row = numlist.get(i);
	                rowDataList2.add(row.text());
	                log.info("내용 : {}", row.text());
	            }
	            // 데이터에 행 데이터 추가
	            data.put("rowData2", rowDataList2);
	        } else {
	            System.out.println("class가 'num_list'인 요소를 찾을 수 없습니다.");
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	        data.put("error", "웹 사이트 크롤링에 실패했습니다.");
	    }

	    Gson gson = new Gson();
	    String jsonData = gson.toJson(data);

	    model.addAttribute("jsonData", jsonData);

	    return "crawler/crawling";
	}
}