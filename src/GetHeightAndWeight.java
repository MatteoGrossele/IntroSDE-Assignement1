
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

public class GetHeightAndWeight {

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

    //returns the weight in the xml file of the person with that id
    public Node getWeight(String id) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[@id = " + id + "]/healthprofile/weight");
        Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return nodes;
    }

    //returns the height in the xml file of the person with that id
    public Node getHeight(String id) throws XPathExpressionException {

        XPathExpression expr = xpath.compile("//person[@id = " + id + "]/healthprofile/height");
        Node nodes = (Node) expr.evaluate(doc, XPathConstants.NODE);
        return nodes;
    }


    public static void main(String[] args) throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {

        GetHeightAndWeight people = new GetHeightAndWeight();
        String id = "5";

        //check if the user specified an id to search for in the xml file 
        if(args.length > 0)
            id = args[0];
        //check if the user specified a name for the xml file different from the default one
        if(args.length > 1)
            people.fileName = args[1];


        Node weight = people.getWeight(id);
         //Control to check if the person with id specified exist
        if(weight != null) {
            System.out.println("Weight of the person with id '" + id + "' in the XML file '" + people.fileName + "'");
            System.out.println(weight.getTextContent());
        }
        else
            System.out.println("No person with id '" + id + "' in the XML file '" + people.fileName + "'");

       

        System.out.println();


        Node height = people.getHeight(id);
        if(height != null) {
            System.out.println("Height of the person with id '" + id + "' in the XML file '" + people.fileName + "'");
             System.out.println(height.getTextContent());
        }
        else
            System.out.println("No person with id '" + id + "' in the XML file '" + people.fileName + "'");

        System.out.println();

    }
}
