package com.shipeng.jackson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.shipeng.data.object.RecgenAirRoute;

public class AirRouteParser {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			String jsonInString = "[\n{\n\"oName\": \"San Francisco International Airport\",\n\"oCode\": \"SFO\",\n\"oCity\": \"San Francisco\",\n\"oState\": \"CA\",\n\"dName\": \"McCarran International Airport\",\n\"dCode\": \"LAS\",\n\"dCity\": \"Las Vegas\",\n\"dState\": \"NV\",\n\"companyName\": \"Test Company 3\",\n\"companyLogoUrl\": \"http://testcompanylogourl.com/3\",\n\"url\": \"http://airrouteurl.com/1\",\n\"rate\": 59.99,\n\"strikeThroughRate\": 99.99,\n\"currencySymbol\": \"$\",\n\"rgct\": \"/recgen/roomkey/trackclick?imp_id=99105000019&udicode=1&type=click1\"\n}\n]";
			// convert json string back to object
			List<RecgenAirRoute> hotels = Arrays.asList(mapper.readValue(jsonInString, RecgenAirRoute[].class));
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
