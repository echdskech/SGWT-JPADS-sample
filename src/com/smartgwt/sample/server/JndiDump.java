package com.smartgwt.sample.server;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

@Singleton
@Startup
public class JndiDump {

	public JndiDump() {
		System.out.println("JNDI Dumping...");
		try {
			Context ctx = new InitialContext();
			
			System.out.println( "java:comp " + ctx.lookup("java:comp") );
			System.out.println( "java:comp/EJBContext " + ctx.lookup("java:comp/EJBContext") );
			//System.out.println( "bla " + ctx.lookup("bla") );
			
			NamingEnumeration<NameClassPair> en = ctx.list("");
			while (en.hasMoreElements()) {
				NameClassPair pair = en.nextElement();
				System.out.println(pair.getName());
			}
			;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

}
