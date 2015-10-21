import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.HealthProfile;
import model.Person;
import model.PeopleStore;

public class HealthProfileWriter {  	
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
		String fileName = "people.xml";
		if(args.length > 0)
            fileName = args[0];
		
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        m.marshal(people,new File(fileName)); // marshalling into a file
        m.marshal(people, System.out);			  // marshalling into the system default output
    }
}
