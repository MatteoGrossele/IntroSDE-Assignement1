# IntroSDE-Assignement1 : Matteo Grossele
First assignement for the course IntroSDE 2015

##Code Structure
The code is an evolution of the lab exercizes. Every task is resolved by a program which can be executed on his own, can accept parameter from the command line to work with different parameters from the one specified from the assignement. For example is possible to specify to the program a specific xml file where it can take the data. 

The only code shared between different programs is the definition of the data model, which are in a separate package named 'model'. These models are used by the 3 marshaller and unmarshaller.

##Problems Solved
The assignement had different task to complete :
* "Extend the xml example to include 20 people" the result is the file **HealthProfile.xml**, it contains data of different athletes, footballers and myself. All the data were collected on Wikipedia.

* "Use xpath to implement methods like getWeight and getHeight of a given person" is resolved by the file **GetHeightAndWeight.java**, it prints weight and height of the person with the specified id in the specified xml file, searched with XPath. This parameters can be specified by command line on the execution otherwise the program takes some default values(the one required from the task).

* "Make a function that prints all people in the list with detail" is resolved by the file **PrintPeople.java**, it prints all the person in the specified xml file. To resolve this problem I looked for all the person in the XML with XPath and then I printed the results with the function ```getTextContent()``` shown in the lab lessons.

* "A function that accepts id as parameter and prints the HealthProfile of the person with that id" is resolved by the file **PrintHealthProfile.java**, it prints the healthprofile of the person with the correct id in the specified xml file. Also in this case I look for the correct healtprofile with an XPath expression filtering the person with the id.

* "A function which accepts a weight and an operator (=, > , <) as parameters and prints people that fulfill that condition" is resolved by the file **PrintWeightConditional.java**, it prints the persons on the xml file that satisfies the condition.

* "Create the XML schema XSD file for the XML document of people." the result is the file **HealthProfile.xsd**, it contains the XML Schema of the document used in the assignement.

* "Write a java application that does the marshalling to XML using classes generated with JAXB XJC" is resolved by the file **HealthProfileWriter.java**. To complete this task I took the example in the lab4 and I modified the model to comply with the new XML data, then I modified the function ```initializeDB()``` to create 3 new data to marshall with the correct format. The program will create a new XML file called 'people.xml'.

* "Write a java application that does the unmarshalling from XML using classes generated with JAXB XJC" is resolved by the file **HealthProfileReader.java**, which is a modified example of the lab4 unmarshaller, only with a more complete output on console. The program will read an XML file called 'people.xml'.

* "Write a java application that does the marshalling  to JSON" is resolved by the file **HealthProfileJson.java**. This task was the same of the marshalling to XML, I just had to apply the same modification done to the XML marshaller to the JSON one. The program will create a new JSON file called 'people.json'.


##Execution
To execute the code, please run in your terminal: 
	```
    	ant execute.evaluation
    ```.

This was a requirement of the assignement, so I choosed to make the execute.evaluation depend to the download of ivy, dependencies and compiling of the code; allowing to simply type the command in a terminal to make it work.

It assumes Java and Apache Ant are already installed and working on the machine.