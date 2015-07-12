/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.polijic.ejb;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Natalia
 */
public class PagosUtil {

    public static Context getInitialContext() throws NamingException {
        Hashtable properties = new Hashtable();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        properties.put(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
        properties.put(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
        properties.put("org.omg.CORBA.ORBInitialPort", "4848");
        Context context = new InitialContext(properties);
        return context;
    }

}
