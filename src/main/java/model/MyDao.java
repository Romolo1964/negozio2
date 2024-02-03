package model;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


//design pattern Singleton
public class MyDao {
	
	private static Connection conn=null;
	
	private static DataSource ds=null;
	
	
	private MyDao() {
		
		
		// Look up our data source
		
		try {
			
			// Obtain our environment naming context
			//ottenimento di un oggetto Context neutro
			Context initCtx = new InitialContext();
			//ottenimento di un oggetto Context del file context dell'applicazione
			//OTTENERE DAL server toncat un ambiente (CONTEXT) comprensivo di componenti
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			System.out.println("Ho iniliziato il contesto >>>>>"+envCtx);
			//ottenimento di un oggetto Datasource dal file web.xml
			//ottenere dall ambiente envCtx facendo una ricerca (metodo lookup) in tale ambiente un datasouce 
			//verificando la stringa del nome del resouce nel file context situato nella cartella di tomcat ( Config/context.xml)
			ds = (DataSource)envCtx.lookup("jdbc/neg");
			System.out.println("Ho cercato nel contesto  il DB neg >>>>>"+ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("ERRORE non riesco  a inizializzare il contesto   ------->>>>");
			e.printStackTrace();
		}

		
	}
	
	public static Connection getConnetion() {
		
		
		if(conn==null) {
			
			new MyDao();
		// Allocate and use a connection from the pool
				try {
					conn = ds.getConnection();
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			
				System.out.println(conn);
				return conn;
		
	}
	

}
