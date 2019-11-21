package com.roy.anurag;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class JsonToMongoApp {

	public static void main(String[] args) {
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new BufferedReader(new FileReader("C:\\Users\\anurag\\Desktop\\json\\originalDump.json")));
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject responseMap = (JSONObject) jsonObj.get("response_map");
			JSONArray entries = (JSONArray) responseMap.get("entries");
			long total = (Long) responseMap.get("total");
			
			System.out.println("Number of iterations needed: " + Math.ceil(total/1000.00));
			
			MongoClient mongoClient = new MongoClient();
		    MongoDatabase db = mongoClient.getDatabase("json-test");
		    MongoCollection<Document> collection = db.getCollection("pipelinesUpdated");
		    List<Document> jsonList = new ArrayList<Document>();
		   
		    for (Object object : entries) {
		        JSONObject jsonStr = (JSONObject) object;
//		        String createTime = (String) jsonStr.get("create_time");
//		        String stateTimestamp = (String) jsonStr.get("state_timestamp");
//		        jsonStr.put("createTimeInMilli", TimestampConverter.convert(createTime));
//		        jsonStr.put("stateTimestampInMilli", TimestampConverter.convert(stateTimestamp));
		        Document jsnObject = Document.parse(jsonStr.toString());
		        jsonList.add(jsnObject);

		    }
		    collection.insertMany(jsonList);
		    mongoClient.close();
            
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

}
