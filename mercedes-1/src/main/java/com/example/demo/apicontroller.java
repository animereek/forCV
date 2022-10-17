package com.example.demo;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.*;
@RestController
public class apicontroller {
	@Autowired
	private RestTemplate rtemplate;
	int caseNo=0;
	@PostMapping
	@RequestMapping("/") 
	public Map<String,Object> solution(@RequestBody String url) throws Exception {
		//rtemplate=new RestTemplate();
		String str=rtemplate.getForObject(url,String.class);
		caseNo++;
		Map<String,Object> response=serviceClass.solve(str,caseNo);
		return response;
	}
	@RequestMapping("/get") 
	public String solution() throws Exception {
		return "Have a nice day";
	}
}

/* the url provied in body gives a json response in this format 
 * "{
		"No. of Test Cases":1,
		"Test1": 
					{
						"Size":8,
						"Current State":[0,1,-1,5,8,6,0,2],
						"Desired State":[1,0,-1,5,8,0,2,6]
					}
	}"*/
/* the problem statement roughly is that u have to convert "Current State" into
 * "Desired State" in minimum no of moves and moves have restriction */
