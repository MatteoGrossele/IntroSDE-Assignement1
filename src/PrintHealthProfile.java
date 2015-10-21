
/**
 * Based on code made by Muhammad Imran
 */
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PrintHealthProfile {

    Document doc;
    XPath xpath;
    //name of the xml file
    String fileName = "HealthProfile.xml";

    public void loadXML() throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse(fileName);

        //creating xpath object
        getXPathObj();
    }

    public XPath getXPathObj() {

        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();
        return xpath;
    }

    //returns the person in the xml file with the id specified
    public Node getPersonById(String id) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[@id=" + id + "]");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return node;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        PrintHealthProfile people = new PrintHealthProfile();
        String id = "5";

        //check if the user specified an id to search for in the xml file 
        if(args.length > 0)
            id = args[0];
        //check if the user specified a name for the xml file different from the default one
        if(args.length > 1)
            people.fileName = args[1];

        people.loadXML();


        //getting all the persons
        Node person = people.getPersonById(id);
        System.out.println("Person with id '" + id + "' in the XML file '" + people.fileName + "'");
        if(person != null)
            System.out.println(person.getTextContent());
        else
            System.out.println("No person with id '" + id + "' in the XML file '" + people.fileName + "'");

        System.out.println();
       
    }
}
