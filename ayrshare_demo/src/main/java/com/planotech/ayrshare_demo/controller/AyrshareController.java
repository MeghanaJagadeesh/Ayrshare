package com.planotech.ayrshare_demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.planotech.ayrshare_demo.service.AyrshareService;

@Controller
@RequestMapping("/quantum-ayrshare")
public class AyrshareController {

	@Autowired
	AyrshareService ayrshareService;

	@PostMapping("/post-file")
	public String postToMedia(MultipartFile mediaFile, @RequestParam String[] mediaPlatform,
			@RequestParam(required = false) String captions, ModelMap map) {
		System.out.println(Arrays.toString(mediaPlatform) + " \n" + mediaFile.getContentType() + " \n" + captions);
		return "null";
//		return ayrshareService.postToMedia(mediaFile, mediaPlatform, captions, map);
//		map.put("pass", "Uploaded Successfully");
//		System.out.println(mediaFile.getContentType() + "  " + mediaPlatform + "   " + captions);
//		return "index";
	}

	@PostMapping("/post-template")
	public String postToTemplate(@RequestParam String[] mediaPlatform, @RequestParam(required = false) String captions,
			MultipartFile templateImage) {
		System.out.println(Arrays.toString(mediaPlatform) + " \n" + templateImage.getContentType() + " \n" + captions);
		return "null";
//		return ayrshareService.postToMedia(mediaFile, mediaPlatform, captions, map);
//		map.put("pass", "Uploaded Successfully");
//		System.out.println(mediaFile.getContentType() + "  " + mediaPlatform + "   " + captions);
//		return "index";
	}

//	@GetMapping("/test")
//	public ResponseEntity<String> delayEndpoint(ModelMap map) {
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(new ResponseEntity<>("Request processed after a 10-second delay", HttpStatus.OK));
//		return new ResponseEntity<>("Request processed after a 10-second delay", HttpStatus.OK);
//	}

//	@GetMapping("/test")
//	public String delayEndpoint(ModelMap map) {
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(new ResponseEntity<>("Request processed after a 10-second delay", HttpStatus.OK));
//		map.put("", new ResponseEntity<>("Request processed after a 10-second delay", HttpStatus.OK));
//		return "index";
}
