package com.shipeng.jackson;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.shipeng.data.object.Person;

public class JacksonObjMapper {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		Person person = new Person();
		person.setName("Shipeng");
		person.setAge(28);
		
		try {
			// convert object to json string
			String jsonInString = mapper.writeValueAsString(person);
			System.out.println(jsonInString);
			
			// convert json string back to object
			Person person2 = mapper.readValue(jsonInString, Person.class);
			System.out.println(person2);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end main
	
} //end class JacksonObjMapper
