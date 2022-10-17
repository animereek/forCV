package com.example.demo;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serviceClass {

	public static Map<String,Object> solve(String str,int caseNo) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(str,Map.class);
		int t=(int)jsonMap.get("No. of Test Cases");
		Map<String,Object> ans=new LinkedHashMap<String,Object>();
		ans.put("email", "ganimesh1104@gmail.com");
		ans.put("password", "HIHIHI");
		ans.put("testCase",caseNo);
		Map<String,String> map=new LinkedHashMap<String,String>();
		for(int i=1;i<=t;i++) {
			String str1="Test"+(i);
			HashMap<String, Object> map1=(HashMap)jsonMap.get(str1);
			ArrayList<Integer> desired=(ArrayList)map1.get("Desired State");
			ArrayList<Integer> current=(ArrayList)map1.get("Current State");
			long ans1=solve(desired,current);
			String ans2=Long.toString(ans1);
			map.put(str1, ans2);

		}
		ans.put("answerStr", map);
		return ans;
	}
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
}
