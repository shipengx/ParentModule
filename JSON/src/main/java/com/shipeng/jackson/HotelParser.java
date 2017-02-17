package com.shipeng.jackson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.shipeng.data.object.RecgenHotel;

public class HotelParser {

public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {

			String jsonInString = "{\n\"tpctd\": \"\",\n\"routes\": \"\",\n\"cars\": \"\",\n\"tpcts\": \"\",\n\"hotels\": \"[{\\\"ei\\\":\\\"EX6\\\",\\\"name\\\":\\\"Test Hotel Property 6\\\",\\\"brandName\\\":\\\"Test Brand 2\\\",\\\"bookUrl\\\":\\\"http://testpropertyurl6.com\\\",\\\"photos\\\":[],\\\"amenities\\\":[],\\\"rgct\\\":\\\"/recgen/roomkey/trackclick?imp_id\\\\u003d99112000001\\\\u0026udicode\\\\u003d6\\\\u0026type\\\\u003dclick1\\\",\\\"tpit\\\":\\\"http://testpropertyurl6.com/imptracker\\\",\\\"tpct\\\":\\\"http://testpropertyurl6.com/clicktracker\\\"},{\\\"ei\\\":\\\"EX3\\\",\\\"name\\\":\\\"Test Hotel Property 3\\\",\\\"brandName\\\":\\\"Test Brand 1\\\",\\\"bookUrl\\\":\\\"http://testpropertyurl3.com\\\",\\\"photos\\\":[],\\\"amenities\\\":[],\\\"rgct\\\":\\\"/recgen/roomkey/trackclick?imp_id\\\\u003d99112000001\\\\u0026udicode\\\\u003d3\\\\u0026type\\\\u003dclick1\\\",\\\"tpit\\\":\\\"http://testpropertyurl3.com/imptracker\\\",\\\"tpct\\\":\\\"http://testpropertyurl3.com/clicktracker\\\"},{\\\"ei\\\":\\\"EX5\\\",\\\"name\\\":\\\"Test Hotel Property 5\\\",\\\"brandName\\\":\\\"Test Brand 1\\\",\\\"bookUrl\\\":\\\"http://testpropertyurl5.com\\\",\\\"photos\\\":[],\\\"amenities\\\":[],\\\"rgct\\\":\\\"/recgen/roomkey/trackclick?imp_id\\\\u003d99112000001\\\\u0026udicode\\\\u003d5\\\\u0026type\\\\u003dclick1\\\"}]\",\n\"orig\": \"\",\n\"agct\": \"\",\n\"tpitd\": \"\",\n\"tpits\": \"\",\n\"dest\": \"SFO\",\n\"pm\": \"{\\\"rt\\\":[\\\"0\\\"],\\\"ac\\\":[\\\"SFO\\\"],\\\"np\\\":[\\\"4\\\"],\\\"t\\\":[\\\"1\\\"],\\\"ai\\\":[\\\"9000\\\"],\\\"format\\\":[\\\"json\\\"]}\"\n}";
			
			// read json like DOM parser
			JsonNode rootNode = mapper.readTree(jsonInString);
			JsonNode hotelNode = rootNode.path("hotels");
			System.out.println("hotels=" + hotelNode.asText());
			jsonInString = hotelNode.getTextValue();
			
			// convert json string back to object
			List<RecgenHotel> hotels = Arrays.asList(mapper.readValue(jsonInString, RecgenHotel[].class));
			System.out.println(hotels);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end main
	
}
