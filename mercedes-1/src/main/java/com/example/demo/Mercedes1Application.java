package com.example.demo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Mercedes1Application {
	public static long solve(ArrayList<Integer> des,ArrayList<Integer> cur) {
		int n=des.size();
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			int v1=des.get(i);
			if(v1>0)
				map.put(v1, i);
		}
		long ans=0;
		int prev1=-1,prev2=-1;
		int curr1=0,curr2=0;
		for(int i=0;i<n;i++) {
			int v1=cur.get(i);
			if(v1==-1) {
				if(curr1==curr2) {
					prev1=-1;
					prev2=-1;
					curr1=0;
					curr2=0;
					continue;
				}
				else {
					return -1;
				}
			}
			else {
				int v2=des.get(i);
				int z=0;
				if(v1>0)
					z=map.get(v1);
				long val=0;
				if(v1>0)
					val=Math.abs(z-i);
				ans=ans+val;
				if(v2>0) {
					prev2=curr2;
					curr2=v2;
				}
				if(v1>0) {
					prev1=curr1;
					curr1=v1;
				}
				if(prev1==prev2 && curr1!=curr2) {
					return -1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Mercedes1Application.class, args);

	}

}
