package com.scripter.javajackson.objmapper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonTreeMapper {

	private static final Logger log = LoggerFactory.getLogger(JacksonTreeMapper.class);
	private static String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
	private static String menu = """
						{"menu": {
			  "id": "file",
			  "value": "File",
			  "popup": {
			    "menuitem": [
			      {"value": "New", "onclick": "CreateNewDoc()"},
			      {"value": "Open", "onclick": "OpenDoc()"},
			      {"value": "Close", "onclick": "CloseDoc()"}
			    ]
			  }
			}}
						""";

	public static void json_string_to_jtree() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			JsonNode jsonNode = objectMapper.readTree(menu);
			JsonNode menuNode = jsonNode.get("menu");
			JsonNode idNode = menuNode.get("id");
			JsonNode popUpNode = menuNode.get("popup");
			JsonNode menuItemNode = popUpNode.get("menuitem");
			JsonNode menuItemNodeFirstElement = menuItemNode.get(0);
			JsonNode valueNode = menuItemNodeFirstElement.get("value");
			
			String id = idNode.asText();
			String value = valueNode.asText();
			log.info("id : "+id);
			log.info("value : "+value);
			log.info("menuitem json : " + objectMapper.writeValueAsString(menuItemNode) );
			
			
			
			JsonNode menuitemArray = jsonNode.at("/menu/popup/menuitem");
			
			if(menuitemArray.isArray()) {
				ArrayNode aNode = (ArrayNode) menuitemArray;
				 for(int i = 0; i < aNode.size(); i++) {
			            JsonNode arrayElement = aNode.get(i);
			            log.info("" + objectMapper.writeValueAsString(arrayElement) );
			        }
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void obj_node() {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode = objectMapper.createObjectNode();
		try {
			JsonNode jsonNode = objectMapper.readTree(carJson);
			objectNode.set("fastCars", jsonNode);
			objectNode.put("brand", "AMG");
			log.info(objectMapper.writeValueAsString(objectNode)); //{"fastCars":{"brand":"Mercedes","doors":5}}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}

}
