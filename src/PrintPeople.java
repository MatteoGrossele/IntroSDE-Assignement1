
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

public class PrintPeople {

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

    //returns all the persons in the xml file
    public NodeList getAllPersons() throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return nodes;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        PrintPeople people = new PrintPeople();

        //check if the user specified a name for the xml file different from the default one
        if(args.length > 0)
            people.fileName = args[0];

        people.loadXML();


        //getting all the persons
        NodeList persons = people.getAllPersons();
        System.out.println("People in the XML file '" + people.fileName + "'");

        for (int i = 0; i < persons.getLength(); i++) {
            System.out.println((i + 1) + ") " + persons.item(i).getTextContent());
        }

        System.out.println();
       
    }
}
