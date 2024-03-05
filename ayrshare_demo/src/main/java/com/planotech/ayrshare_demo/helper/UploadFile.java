package com.planotech.ayrshare_demo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

@Component
public class UploadFile {

	private String BUCKET_NAME = "planotech";
	private String AWS_REGION = "ap-south-1";

	public String uploadFile(MultipartFile mediafile) {
		try {
			File file = convertMultipartFileToFile(mediafile);
			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(AWS_REGION).build();

			String fileName = file.getName();
			String contentType;
			contentType = Files.probeContentType(file.toPath());
			String key = "public/" + fileName + "." + contentType; // Specify the S3 key for the uploaded file
			PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, key, file);
			PutObjectResult result = s3Client.putObject(request);

			// Generate the public URL for the uploaded file
			String publicUrl = s3Client.getUrl(BUCKET_NAME, key).toString();
			System.out.println("publicUrl : " + publicUrl);
			return publicUrl;
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}

	public File convertMultipartFileToFile(MultipartFile multipartFile) {
		File file = new File(multipartFile.getOriginalFilename());
		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}
}
