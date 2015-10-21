import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import model.HealthProfile;
import model.Person;
import model.PeopleStore;

public class HealthProfileJson {  	
	public static PeopleStore people = new PeopleStore();

	public static void initializeDB() {
		HealthProfile hp1 = new HealthProfile("2015-10-20T18:00:00.000+02:00", 75.0, 1.83);
		Person person1 = new Person(new Long(1), "David", "Beckham", "1975-05-02T18:00:00.000+02:00", hp1);

		HealthProfile hp2 = new HealthProfile("2015-10-20T18:00:00.000+02:00", 85.0, 1.85);
		Person person2 = new Person(new Long(2), "Rafael", "Nadal", "1986-06-03T18:00:00.000+02:00", hp2);

		HealthProfile hp3 = new HealthProfile("2015-10-20T18:00:00.000+02:00", 103.0, 1.78);
		Person person3 = new Person(new Long(3), "Mike", "Tyson", "1966-06-30T18:00:00.000+02:00", hp3);

		people.getData().add(person1);
		people.getData().add(person2);
		people.getData().add(person3);
	}	

	public static void main(String[] args) throws Exception {
		
		initializeDB();
		
		//I look if the user specified a filename in the args
		String fileName = "people.json";
		if(args.length > 0)
            fileName = args[0];

		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        String result = mapper.writeValueAsString(people);
        System.out.println(result);
        mapper.writeValue(new File(fileName), people);
    }
}
