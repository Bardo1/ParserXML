//qualify all the elements through the use of the package level annotation @XmlSchema.  To specify a package level annotation, create a class called package-info in the desired package
//set a default namespace and specify that by default all elements are namespace qualified
@XmlSchema(namespace = "http://www.example.org/package", elementFormDefault = XmlNsForm.QUALIFIED)

package example.java.xml.parser.jaxb.namespace;

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;