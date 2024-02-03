package model;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



/**Design pattern Singleton
 che mi ritorna una connessione chiedendola al datasource 
 configurato in Tomcat 
 ottenimento di un oggetto Datasource dal file web.xml
 ottenere dall ambiente envCtx facendo una ricerca (metodo lookup) in tale ambiente un datasouce 
 verificando la stringa del nome del resouce nel file context situato nella cartella di tomcat ( Config/context.xml)
 */

public class MyConnection {
	
	private static Connection conn=null;
	
	private static DataSource ds=null;
	
	
	private MyConnection() {
		
		
		// Look up our data source
		
		try {
			
			// Obtain our environment naming context
			//ottenimento di un oggetto Context neutro
			Context initCtx = new InitialContext();
			
			System.out.println("Questo e inilizzazione del contesto >>>    "+initCtx);
			
			//ottenimento di un oggetto Context del file context dell'applicazione
			//OTTENERE DAL server toncat un ambiente (CONTEXT) comprensivo di componenti
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			System.out.println("Questo e il Contesto costruito dal lookup  >>>    "+envCtx);
			
			//ottenimento di un oggetto Datasource dal file web.xml
			//ottenere dall ambiente envCtx facendo una ricerca (metodo lookup) in tale ambiente un datasouce 
			//verificando la stringa del nome del resouce nel file context situato nella cartella di tomcat ( Config/context.xml)
			ds = (DataSource)envCtx.lookup("jdbc/neg");
			System.out.println("Questo e il DataSource dal Costesto restuito >>>    "+ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore >>>    ");
			e.printStackTrace();
		}

		
	}
	
	public static Connection getConnetion() {
		
		
		if(conn==null) {
			
			new MyConnection();
		// Allocate and use a connection from the pool
				try {
					System.out.println("Sono entrato nel try prima della richiesta dell'oggetto Connection");
					conn = ds.getConnection();
					
					
				} catch (Exception e) {
					System.out.println("Sono entrato nell eccezione il datasource non mi costruisce l'oggetto Connection");
					e.printStackTrace();
				}
		}
			
				System.out.println("Questa è la connessione restituita dal Datasource >>>>>  "+conn);
				return conn;
		
	}
	

}
