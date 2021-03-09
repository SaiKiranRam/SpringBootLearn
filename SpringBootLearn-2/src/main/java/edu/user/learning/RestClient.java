package edu.user.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.user.learning.entity.Programmer;
import edu.user.learning.entity.Technology;

public class RestClient {

	private static final String Get_Programmer_Details_API = "http://localhost:8080/";
	private static final String DELETE_All_Programmer_Details_API = "http://localhost:8080/";
	private static final String Get_Single_Programmer_Details_API = "http://localhost:8080/{id}";
	private static final String Update_Single_Programmer_Details_API = "http://localhost:8080/{id}";
	private static final String DELETE_Single_Programmer_Details_API = "http://localhost:8080/{id}";

	private static RestTemplate template = new RestTemplate() ;
	
	public static void main(String args[]) {
		
		getAllProgrammersAPI();
		getProgrammerByIdAPI();
		updateProgrammerByIdAPI();
		deleteProgrammerByIdAPI();
	}
	
	public static void getAllProgrammersAPI() {
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", header);
		
		ResponseEntity<String> result
				= template.exchange(Get_Programmer_Details_API, HttpMethod.GET, entity, String.class);
		
		System.out.println(result);
	}
	
	public static void getProgrammerByIdAPI() {
		
		Map<String, Long> param = new HashMap<String, Long>();
		
		param.put("id", (long) 1);
		
		Programmer programmer
			= template.getForObject(Get_Single_Programmer_Details_API, Programmer.class, param);
		
		System.out.println("\n\n" + programmer.getId() + " " + programmer.getFirstName() + "\t" + programmer.getLastName());
	}
	
	public static void updateProgrammerByIdAPI() {
		
		System.out.println("\n\n Update Method");
		
		Map<String, Long> param = new HashMap<String, Long>();
		
		param.put("id", (long) 2);
		
		List<Technology> tech = Arrays.asList(new Technology("TechA", "Role A", 8),
											  new Technology("TechB", "Role B", 9),
											  new Technology("TechC", "Role C", 10));
		
		Programmer programmer
			= template.getForObject(Get_Single_Programmer_Details_API, Programmer.class, param);
		
		programmer.setFirstName("Vijay_Demo");
		programmer.setLastName("Anand_Demo");
		programmer.setTechnologies(tech);
		
		System.out.println(programmer);
		
		template.put(Update_Single_Programmer_Details_API, programmer, param);
	}
	
	public static void deleteProgrammerByIdAPI() {
		
		Map<String, Long> param = new HashMap<String, Long>();
		
		param.put("id", (long) 18);
		
		template.delete(DELETE_Single_Programmer_Details_API, param);
	}
	
}
