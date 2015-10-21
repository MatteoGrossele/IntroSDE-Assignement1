import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.HealthProfile;
import model.Person;
import model.PeopleStore;

public class HealthProfileReader {  	
	public static PeopleStore people = new PeopleStore();

	public static void main(String[] args) throws Exception {
        //I look if the user specified a filename in the args
        String fileName = "people.xml";
        if(args.length > 0)
            fileName = args[0];

		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = jc.createUnmarshaller();
        PeopleStore people = (PeopleStore) um.unmarshal(new FileReader(fileName));
        List<Person> list = people.getData();
        for (Person person : list) {
          System.out.println("Person: " + person.getFirstname() + " born "
              + person.getBirthdate());
        }

    }
}
