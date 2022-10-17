package com.example.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Mercedes2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mercedes2Application.class, args);
		RestTemplate rtemplate=new RestTemplate();
		String url1="https://s3-ap-southeast-1.amazonaws.com/he-public-data/output10e2c2e2.json";
		HttpEntity<String> entity1 = new HttpEntity<>(url1);
		String url2="http://localhost:8082/";
		String str=rtemplate.postForObject(url2,entity1, String.class);
		System.out.println(str);
		url1="https://s3-ap-southeast-1.amazonaws.com/he-public-data/output10d65bf01.json";
		entity1 = new HttpEntity<>(url1);
		str=rtemplate.postForObject(url2,entity1, String.class);
		System.out.println(str);
	}

}
