package it.example.ejb.util;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientUtil {
	

    private static Context initialContext;
 
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
            properties.put("jboss.naming.client.ejb.context", true);// MUST have.
 
            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }

}
