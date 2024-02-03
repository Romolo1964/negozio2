package model;




import java.sql.Connection;
import java.sql.Statement;

import java.sql.SQLException;

import java.util.List;

public class UtentiDAOImpl implements InterfaceUtentiDAO {
    

    public UtentiDAOImpl() {
        
    }

	@Override
	public void addUser(Utenti utente) {
		// TODO Auto-generated method stub
		Connection con=MyConnection.getConnetion();
		String query = "INSERT INTO utenti (email, indirizzo, password, username) "
				+ "VALUES (?, ?, ?, ?)";
		
		try {
			Statement st=con.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		}
		
	}

	@Override
	public Utenti getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utenti> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Utenti utente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

   
}
