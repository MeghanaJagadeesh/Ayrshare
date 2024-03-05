package com.planotech.ayrshare_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.planotech.ayrshare_demo.AyrshareConfig;
import com.planotech.ayrshare_demo.helper.UploadFile;

@Service
public class AyrshareService {

	@Value("${ayrshare.bearer.token}")
	String bearerToken;

	@Autowired
	UploadFile uploadFile;

	@Autowired
	HttpHeaders headers;

	@Autowired
	AyrshareConfig ayrshareConfig;

	@Autowired
	RestTemplate restTemplate;

	public String postToMedia(MultipartFile mediaFile, String[] mediaPlatform, String captions, ModelMap map) {
		try {
			String fileurl = uploadFile.uploadFile(mediaFile);
			String tesrUrl = "https://app.ayrshare.com/api/post";
			String jsonString = "{\"post\":\"" + captions + "\", \"platforms\":" + getMedia(mediaPlatform)
					+ ", \"mediaUrls\":\"" + fileurl + "\"}";
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(bearerToken);
			HttpEntity<String> requestEntity = ayrshareConfig.getHttpEntity(jsonString, headers);
			ResponseEntity<String> response = restTemplate.exchange(tesrUrl, HttpMethod.POST, requestEntity,
					String.class);

			System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			if (response.getStatusCode().is2xxSuccessful()) {
				map.put("pass", "Media Uploaded Successfully");
				return "index";
			} else {
				map.put("fail", "Something went wrong");
				return "index";
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
			map.put("fail", e.getMessage());
			return "index";
		}
	}

	public String getMedia(String[] platforms) {
		String output = "[";
		for (int i = 0; i < platforms.length; i++) {
			if (i > 0) {
				output += ", ";
			}
			output += "\"" + platforms[i] + "\"";
		}
		output += "]";
		return output;
	}

}
