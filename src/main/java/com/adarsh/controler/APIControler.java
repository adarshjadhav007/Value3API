package com.adarsh.controler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.adarsh.entity.ApiInputesEntity;
import com.adarsh.service.GetIPAddressService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class APIControler {
	
	Logger logger = LoggerFactory.getLogger(APIControler.class);

	
	@Autowired
	RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/api")
	public JSONObject getResponse(ApiInputesEntity input, HttpServletRequest request) {
		
		JSONObject outputObject = new JSONObject();
		try {
			final String uri = "https://query1.finance.yahoo.com/v8/finance/chart/%5ESTI?region="+input.getRegion()
					+ "&lang="+input.getLang()
					+ "&includePrePost="+input.getIncludePrePost()
					+ "&interval="+input.getInterval()
					+ "&useYfid="+input.getUseYfid()
					+ "&range="+input.getRange()
					+ "&corsDomain="+input.getCorsDomain()
					+ "&.tsrc="+input.getTsrc();
			 String decodeURL=URLDecoder.decode( uri, "UTF-8" ); 
			
			RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(decodeURL, String.class);
		    
		    JSONParser parser = new JSONParser();  
		    JSONObject json = (JSONObject) parser.parse(result); 
		    
		    
			
		    Object currency =  ((JSONObject)((JSONObject)(((JSONArray)((JSONObject) json.get("chart")).get("result")).get(0))).get("meta")).get("currency");
		    
		    Object timestamp = (((JSONObject)(((JSONArray)((JSONObject) json.get("chart")).get("result")).get(0))).get("timestamp"));
		        
		    Object volume = ((JSONObject)((JSONArray)((JSONObject)((JSONObject)((JSONArray)((JSONObject) json.get("chart")).get("result")).get(0)).get("indicators")).get("quote")).get(0)).get("volume");
		    	    
		    Object error = ((JSONArray)((JSONObject) json.get("chart")).get("error"));
		    
		    outputObject.put("currency", currency);
		    outputObject.put("timestamp", timestamp);
		    outputObject.put("volume", volume);
		    outputObject.put("error", error);
		    
		    String IP = GetIPAddressService.getClientIpAddress(request);
		    logger.info(IP);
		    	    
		    //System.out.println(volume1);
		    
			return outputObject;

			
		} catch (HttpClientErrorException e){
			outputObject.put("error", "No data found");
			
		}catch (UnsupportedEncodingException e) {
			outputObject.put("error", "Wrong URL");
		}catch (ParseException e) {
			outputObject.put("error", "JSON Pars failed");
		}
		
		return outputObject;
	}
	
	
}
