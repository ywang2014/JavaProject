package com.util;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.json.Include;

public class Jackson {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public String getJsonString(Object object){
//		mapper.setSerializationInclusion(Include.NON_NULL);
//        mapper.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
//        String result;
//        try{
//            result = mapper.writeValueAsString(object);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//        return result;
		return null;
    }
}
