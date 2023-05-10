package com.scripter.javajackson.objmapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scripter.javajackson.model.Car;

public class JacksonObjMapper {

	private static final Logger log = LoggerFactory.getLogger(JacksonObjMapper.class);

	private static String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
	
	public static void ob_mapper_json_string_to_obj() {

		ObjectMapper mapper = new ObjectMapper();
		try {
			Car car = mapper.readValue(carJson, Car.class);
			log.info("Car Details : " + car.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ob_mapper_json_string_to_map() {

		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> jsonMap = mapper.
					readValue(carJson, new TypeReference<Map<String, Object>>() {});
			
			log.info("" + jsonMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void ob_mapper_obj_to_Json_String() {

		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		mapper.setDateFormat(dateFormat);
		// We can set date format with Jackson , if we don't it will consider the date as long
		
		try {

			Car car = new Car();
			car.setBrand("BMW");
			car.setDoors(4);
			car.setDate(new Date());

			String json = mapper.writeValueAsString(car);
			log.info("" + json); // {"brand":"BMW","doors":4,"date":"2023-05-10"}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
