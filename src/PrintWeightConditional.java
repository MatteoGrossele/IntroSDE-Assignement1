
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

public class PrintWeightConditional {

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

    //returns the persons in the xml file that match the condition
    public NodeList getPersonsByComparingWieght(String weight, String compare) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[./healthprofile/weight " + compare + " " + weight + "]");
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        return nodes;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        PrintWeightConditional people = new PrintWeightConditional();
        String weight = "90";
        String compare = ">";

        //check if the user specified a weight to search for in the xml file 
        if(args.length > 0)
            weight = args[0];
         //check if the user specified a comparator to search for in the xml file 
        if(args.length > 1)
            compare = args[1];
        //check if the user specified a name for the xml file different from the default one
        if(args.length > 2)
            people.fileName = args[2];

        people.loadXML();


        //getting all the persons
        NodeList persons = people.getPersonsByComparingWieght(weight,compare);
        System.out.println("Persons with weight " + compare + (compare.equals("=")?" to ":" than ") + weight + " in the XML file '" + people.fileName + "'");

        for (int i = 0; i < persons.getLength(); i++) {
            System.out.println((i + 1) + ") " + persons.item(i).getTextContent());
        }

        System.out.println();
       
    }
}
