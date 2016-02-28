//not working since beginning

package example.java.xml.parser.jaxb.binding.xmltojson;

import java.util.*;
import javax.ws.rs.core.Application;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

public class CustomerXMLToJSONBindJAXRSApplication  extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>(1);
        //create CustomerService class 
        //set.add(CustomerService.class);
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        MOXyJsonProvider moxyJsonProvider = new MOXyJsonProvider();
        moxyJsonProvider.setWrapperAsArrayName(true);
        HashSet<Object> set = new HashSet<Object>(1);
        set.add(moxyJsonProvider);
        return set;
    }
}
