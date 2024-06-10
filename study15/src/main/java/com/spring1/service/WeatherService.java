package com.spring1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring1.dto.Weather;

@Service
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    public String loadData(String serviceKey, String baseDate, String nx, String ny) throws IOException {
    	log.info("Service serviceKey : {}", serviceKey);
    	log.info("Service baseDate : {}", baseDate);
    	log.info("Service nx : {}", nx);
    	log.info("Service ny : {}", ny);
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"); /*초단기실황조회 URL*/
        //StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst"); /*초단기예보조회 URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /*‘24년 6월 3일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("0600", "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.info("Response code: {}", conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        log.info("Service Before Parsing {}", sb.toString());
        return sb.toString();
    }

    public JSONArray parsingData(String serviceKey, String baseDate, String nx, String ny) throws IOException, ParseException {
        String stream = this.loadData(serviceKey, baseDate, nx, ny);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(stream);

        if (jsonObject == null || !jsonObject.containsKey("response")) {
            return new JSONArray();
        }

        JSONObject response = (JSONObject) jsonObject.get("response");
        if (response == null || !response.containsKey("header")) {
            return new JSONArray();
        }

        JSONObject header = (JSONObject) response.get("header");
        String resultCode = (String) header.get("resultCode");
        if (!"00".equals(resultCode)) {
            return new JSONArray();
        }

        if (!response.containsKey("body")) {
            return new JSONArray();
        }

        JSONObject body = (JSONObject) response.get("body");
        if (body == null || !body.containsKey("items")) {
            return new JSONArray();
        }

        JSONObject items = (JSONObject) body.get("items");
        if (items == null || !items.containsKey("item")) {
            return new JSONArray();
        }
        
        JSONArray jsonArr = (JSONArray) items.get("item");
        
        log.info("Service : {}", jsonArr);
        return jsonArr;
    }

    public Weather resultData(String serviceKey, String baseDate, String nx, String ny) throws IOException, ParseException {
        JSONArray jsonArray = this.parsingData(serviceKey, baseDate, nx, ny);

        Weather dto = new Weather();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject item = (JSONObject) jsonArray.get(i);

            if (item == null) continue;

            String category = item.get("category").toString().toUpperCase();
            String obsrValue = item.get("obsrValue").toString();

            log.debug("Category: " + category + ", obsrValue: " + obsrValue);

            switch (category) {
                case "PTY":
                    dto.setPty(obsrValue);
                    break;
                case "REH":
                    dto.setReh(obsrValue);
                    break;
                case "RN1":
                    dto.setRn1(obsrValue);
                    break;
                case "T1H":
                    dto.setT1h(obsrValue);
                    break;
                case "UUU":
                    dto.setUuu(obsrValue);
                    break;
                case "VEC":
                    dto.setVec(obsrValue);
                    break;
                case "VVV":
                    dto.setVvv(obsrValue);
                    break;
                case "WSD":
                    dto.setWsd(obsrValue);
                    break;
                case "SKY":
                    dto.setSky(obsrValue);
                    break;
                default:
                    break;
            }
        }

        log.info("service: " + dto.toString());

        return dto;
    }
}