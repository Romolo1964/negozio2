package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProdottiNelCarrello;

public class ProdottiNelCarrelloDao {
    private Connection connection;

    // Costruttore
    public ProdottiNelCarrelloDao(Connection connection) {
        this.connection = connection;
    }

    // Metodo per aggiungere un prodotto nel carrello
    public void aggiungiProdottoNelCarrello(ProdottiNelCarrello prodottoNelCarrello) {
        try {
            String query = "INSERT INTO ProdottiNelCarrello (idCarrello, idProdotto, quantita, subtotale) " +
                           "VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, prodottoNelCarrello.getIdCarrello());
                statement.setInt(2, prodottoNelCarrello.getIdProdotto());
                statement.setInt(3, prodottoNelCarrello.getQuantita());
                statement.setDouble(4, prodottoNelCarrello.getSubtotale());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
    }

    // Metodo per ottenere tutti i prodotti nel carrello associati a un carrello specifico
    public List<ProdottiNelCarrello> getProdottiNelCarrello(int idCarrello) {
        List<ProdottiNelCarrello> prodottiNelCarrelloList = new ArrayList<>();

        try {
            String query = "SELECT * FROM ProdottiNelCarrello WHERE idCarrello = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, idCarrello);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        ProdottiNelCarrello prodottoNelCarrello = mapResultSetToProdottiNelCarrello(resultSet);
                        prodottiNelCarrelloList.add(prodottoNelCarrello);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }

        return prodottiNelCarrelloList;
    }

	// Metodo privato per mappare il risultato di una query a un oggetto
	// ProdottiNelCarrello
	private ProdottiNelCarrello mapResultSetToProdottiNelCarrello(ResultSet resultSet) throws SQLException {
		ProdottiNelCarrello prodottoNelCarrello = new ProdottiNelCarrello();
		prodottoNelCarrello.setIdProdottoNelCarrello(resultSet.getInt("idProdottoNelCarrello"));
		prodottoNelCarrello.setIdCarrello(resultSet.getInt("idCarrello"));
		prodottoNelCarrello.setIdProdotto(resultSet.getInt("idProdotto"));
		prodottoNelCarrello.setQuantita(resultSet.getInt("quantita"));
		prodottoNelCarrello.setSubtotale(resultSet.getDouble("subtotale"));
		return prodottoNelCarrello;
	}

	// Metodo per eliminare un prodotto dal carrello
	public void eliminaProdottoNelCarrello(int idProdottoNelCarrello) {
	    try {
	        String query = "DELETE FROM ProdottiNelCarrello WHERE idProdottoNelCarrello = ?";
	        
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, idProdottoNelCarrello);
	            statement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Gestire l'eccezione in modo appropriato
	    }
	}

}
