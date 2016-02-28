//specify the namespace mapping
//qualify all the elements through the use of the package level annotation @XmlSchema.  To specify a package level annotation, create a class called package-info in the desired package
//set a default namespace and specify that by default all elements are namespace qualified
@XmlSchema(namespace = "http://www.example.org/customer", elementFormDefault = XmlNsForm.QUALIFIED)

// package path "example.java.xml.parser.jaxb.rootelement" should be same for both the statements 
// JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement") and 
// package example.java.xml.parser.jaxb.rootelement in package-info.java
package example.java.xml.parser.jaxb.rootelement; 

import javax.xml.bind.annotation.*;