package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.MyConnection;
import model.Utenti;

public class UtenteDao {
	/*
	 * La connection me la faccio dare dalla classe MyConnection che mi ritorna un
	 * oggetto Connection e lo uso nei vari metodi CRUD ecc.
	 */
	private Connection connection = MyConnection.getConnetion();

	// Costruttore della classe Utentedao vuoto .
	public UtenteDao() {
		System.out.println("STO NEL COSTRUTTORE VUOTO UTENTEDAO ");
		System.out.println("Questa è la Connection >>>>> "+connection);
	}

	/*
	 * Metodo che aggiunge un Utente. [Metodo Cread]
	 */
	public void aggiungiUtente(Utenti utente) {

		Statement statement;
		try {
			statement = connection.createStatement();
			String query = "INSERT INTO utenti (email, indirizzo, password, username, nome, cognome) " + "VALUES ('"
					+ utente.getEmail() + "', '" + utente.getIndirizzo() + "', '" + utente.getPassword() + "', '"
					+ utente.getUsername() + "', '" + utente.getNome() + "', '" + utente.getCognome() + "')";
			
			System.out.println("Sto prima dell'esecuzione della query  >>>>> "+query);
			statement.executeUpdate(query);
			//statement.close();
			
			System.out.println("Sto dopo dell'esecuzione della query  >>>>> "+query);
		} catch (SQLException e) {
			System.out.println();
			System.out.println("Sto nell'errore aggiungi utente  ");
			System.out.println("La connessione e >>>>"+connection );
			System.out.println();
			e.printStackTrace();
		}
	}

	/*
	 * Metodo per leggere un Utente [Metodo Read ]
	 */
	public Utenti trovaUtentePerId(int idUtente) {
		Utenti utente = null;

		try {
			Statement statement = connection.createStatement();

			String query = "SELECT * FROM utenti WHERE idUtente = " + idUtente;

			try (ResultSet resultSet = statement.executeQuery(query)) {
				if (resultSet.next()) {
					utente = new Utenti(resultSet.getString("email"), resultSet.getString("indirizzo"),
							resultSet.getString("password"), resultSet.getString("username"),
							resultSet.getString("nome"), resultSet.getString("cognome"));
					utente.setIdUtente(resultSet.getInt("idUtente"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Gestire l'eccezione in modo appropriato
		}
		
		return utente;
	}

	/*
	 * Metodo che mi ritorna una lista di Utenti [Metodo Read ritorna una Lista]
	 */
	public List<Utenti> trovaTuttiUtenti() {
		List<Utenti> utenti = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utenti");
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				Utenti utente = new Utenti(resultSet.getString("email"), resultSet.getString("indirizzo"),
						resultSet.getString("password"), resultSet.getString("username"), resultSet.getString("nome"),
						resultSet.getString("cognome"));
				utente.setIdUtente(resultSet.getInt("idUtente"));
				utenti.add(utente);
//				resultSet.close();
//				preparedStatement.close();
//				connection.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// Gestire l'eccezione in modo appropriato
		}

		return utenti;
	}

	/*
	 * Metodo per aggiornare un Utente [Metodo Update ]
	 */
	public void aggiornaUtente(Utenti utente) {
		try {
			Statement statement = connection.createStatement();
			String query = "UPDATE utenti SET email='" + utente.getEmail() + "', indirizzo='" + utente.getIndirizzo()
					+ "', password='" + utente.getPassword() + "', username='" + utente.getUsername() + "', nome='"
					+ utente.getNome() + "', cognome='" + utente.getCognome() + "' WHERE idUtente="
					+ utente.getIdUtente();

			statement.executeUpdate(query);
			//statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			// Gestire l'eccezione in modo appropriato
		}
	}

	/*
	 * Metodo per eliminare un Utente [Metodo Delete]
	 */
	public void eliminaUtente(int idUtente) {
		try {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM utenti WHERE idUtente=" + idUtente;

			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// Gestire l'eccezione in modo appropriato
		}
	}
}
