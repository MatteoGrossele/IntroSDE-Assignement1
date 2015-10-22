# IntroSDE-Assignement1 : Matteo Grossele
First assignement for the course IntroSDE 2015

##Code Structure

##Problems Solved
The assignement had different task to complete :
* **Extend the xml example to include 20 people ** the result is the file **HealthProfile.xml**, it contains data of different athletes, footballers and myself. All the data were collected on Wikipedia.

* **Use xpath to implement methods like getWeight and getHeight of a given person** is resolved by the file **GetHeightAndWeight.java**, it prints weight and height of the person with the specified id in the specified xml file. This parameters can be specified by command line on the execution otherwise the program takes some default values(the one required from the task).

* **Make a function that prints all people in the list with detail** is resolved by the file **PrintPeople.java**, it prints all the person in the specified xml file. 

* **A function that accepts id as parameter and prints the HealthProfile of the person with that id** is resolved by the file **PrintHealthProfile.java**, it prints the healthprofile of the person with the correct id in the specified xml file.

* **A function which accepts a weight and an operator (=, > , <) as parameters and prints people that fulfill that condition** is resolved by the file **PrintWeightConditional.java**, it prints the persons on the xml file that satisfies the condition.

* **Create the XML schema XSD file for the XML document of people.**the result is the file **HealthProfile.xsd**, it contains the XML Schema of the document used in the assignement.

* **Write a java application that does the marshalling to XML using classes generated with JAXB XJC**is resolved by the file ** is resolved by the file **HealthProfileWriter.java**

* **Write a java application that does the unmarshalling from XML using classes generated with JAXB XJC**is resolved by the file ** is resolved by the file **HealthProfileReader.java**

* **Write a java application that does the marshalling  to JSON**is resolved by the file ** is resolved by the file **HealthProfileJson.java**


##Execution
To execute the code, please run in your terminal: 
	```
    	ant execute.evaluation
    ```.

This was a requirement of the assignement, so i choosed to make the execute.evaluation depend to the download of ivy, dependencies and compiling of the code; allowing to simply type the command in a terminal to make it work.

It assumes Java and Apache Ant are already installed and working on the machine.