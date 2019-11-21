package com.roy.anurag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.roy.anurag.InterfaceScheduleRaw.Schedule.Repeat.Cron;

public class ScheduleJsonToMongoApp {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Object obj = parser.parse(new BufferedReader(new FileReader("C:\\Users\\anurag\\Desktop\\json\\listScheduleJob.json")));
			JSONArray jsonArray = (JSONArray) obj;
			
			for (Object arrayElement : jsonArray) {

				InterfaceScheduleRaw isr = mapper.readValue(arrayElement.toString(), InterfaceScheduleRaw.class);
				generateFlattenedInterface(isr, System.currentTimeMillis(), System.currentTimeMillis() + 604800000);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void generateFlattenedInterface (InterfaceScheduleRaw isr, long startTime, long endTime) {
		
		List<InterfaceScheduleFlattened> result = new ArrayList<InterfaceScheduleFlattened>();
		
		String taskId = isr.getTaskId();
		String taskName = isr.getTaskName();
		String pipelineName = isr.getPipelineName();
		String pipelineFolder = isr.getPipelineFolder();
		
		String timeZone = isr.getSchedule().getTimeZone();
		String by = isr.getSchedule().getRepeat().getBy();
		
		if (by.equals("cron")) {
			Cron cron = isr.getSchedule().getRepeat().getCron();
			//ArrayList<String> month = new ArrayList(Arrays.asList(cron.getMonth().split(",")));
			ArrayList<String> minute = new ArrayList(Arrays.asList(cron.getMinute().split(",")));
			//ArrayList<String> day = new ArrayList(Arrays.asList(cron.getDay().split(",")));
			//ArrayList<String> dayOfWeek = new ArrayList(Arrays.asList(cron.getDayOfWeek().split(",")));
			ArrayList<String> hour = new ArrayList(Arrays.asList(cron.getHour().split(",")));
			if (hour.contains("*")) {
				hour.clear();
				for (int i = 0; i < 24; i++) {
					hour.add(String.valueOf(i));
				}
			}
			
			ArrayList<String> allTimes = new ArrayList<String>();
			
			for (String hh : hour) {
				for (String mm : minute) {
					if (hh.length() == 1)
						hh = "0" + hh;
					if (mm.length() == 1)
						mm = "0" + mm;
					
					allTimes.add(hh + ":" + mm);
				}
			}
			
			System.out.println(allTimes);
			
		} else if (by.equals("minutes")) {
			
			int every = isr.getSchedule().getRepeat().getEvery();
			
		}
		
		TimeZone zone = TimeZone.getTimeZone(timeZone); 
		//System.out.println(zone);
	}

}