package prodotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import model.MyConnection;

public class ProdottiDAO {

	// Metodo per inserire un nuovo prodotto nel database
	public void insertProdotti(Prodotti prodotto) {
	    try (Connection connection = MyConnection.getConnetion()){
	        String sql = "INSERT INTO Prodotti (categoria, descrizione, fotoprodotto, nome, prezzo) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, prodotto.getCategoria());
	            statement.setString(2, prodotto.getDescrizione());
	            statement.setBytes(3, prodotto.getFotoprodotto());
	            statement.setString(4, prodotto.getNome());
	            statement.setDouble(5, prodotto.getPrezzo());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Altre operazioni da eseguire indipendentemente dall'eccezione
	            // Ad esempio, ulteriori chiusure, logging, ecc.
//	            try {
//	                if (connection != null) {
//	                    connection.close();
//	                }
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
	        }
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

 // Metodo per ottenere un prodotto dal database dato il suo ID
    public Prodotti getProdottoById(int idProdotto) {
        Prodotti prodotto = null;
        Connection connection = null;

        try {
            connection = MyConnection.getConnetion();
            String sql = "SELECT * FROM Prodotti WHERE idProdotto=?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idProdotto);
                
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        prodotto = mapResultSetToProdotti(resultSet);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            // Altre operazioni da eseguire indipendentemente dall'eccezione
            // Ad esempio, ulteriori chiusure, logging, ecc.
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
        
        return prodotto;
    }

    public List<Prodotti> getAllProdotti() {
        List<Prodotti> prodottiList = new ArrayList<>();
        Connection connection = null;

        try {
            // Ottieni la connessione al database
            connection = MyConnection.getConnetion();

            // Query per ottenere tutti i prodotti
            String sql = "SELECT * FROM Prodotti";

            try 
                 
            {
            	Statement statement = connection.createStatement();
            	ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                	/**
                	 * Il metodo mapResultSetToProdotti è una funzione ausiliaria che può
                	 *  essere utilizzata per mappare un singolo record (riga) del ResultSet 
                	 *  a un oggetto della classe Prodotti. 
                	 *  Questa funzione è spesso utile per rendere il codice più modulare e 
                	 *  facilitare la manutenzione.
                	 */
                    Prodotti prodotto = mapResultSetToProdotti(resultSet);
                    /**
                     * Aggiungo un prodotto alla Lista.
                     */
                    prodottiList.add(prodotto);
                }
            

        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return prodottiList;
        } finally {}
    }	

 // Metodo per aggiornare un prodotto nel database
    public void updateProdotto(Prodotti prodotto) {
        try (Connection connection = MyConnection.getConnetion()) {
            String sql = "UPDATE Prodotti SET categoria=?, descrizione=?, fotoprodotto=?, nome=?, prezzo=? WHERE idProdotto=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, prodotto.getCategoria());
                statement.setString(2, prodotto.getDescrizione());
                statement.setBytes(3, prodotto.getFotoprodotto());
                statement.setString(4, prodotto.getNome());
                statement.setDouble(5, prodotto.getPrezzo());
                statement.setInt(6, prodotto.getIdProdotto());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
			} finally {
				// Altre operazioni da eseguire indipendentemente dall'eccezione
				// Ad esempio, ulteriori chiusure, logging, ecc.
//                try {
//                    if (connection != null) {
//                        connection.close();
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

 // Metodo per eliminare un prodotto dal database dato il suo ID
    public void deleteProdotto(int idProdotto) {
        try (Connection connection = MyConnection.getConnetion()) {
            String sql = "DELETE FROM Prodotti WHERE idProdotto=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idProdotto);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Altre operazioni da eseguire indipendentemente dall'eccezione
                // Ad esempio, ulteriori chiusure, logging, ecc.
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }


    // Metodo per mappare i risultati della query a un oggetto Prodotti
    private Prodotti mapResultSetToProdotti(ResultSet resultSet) throws SQLException {
        Prodotti prodotto = new Prodotti();
        prodotto.setIdProdotto(resultSet.getInt("idProdotto"));
        prodotto.setCategoria(resultSet.getString("categoria"));
        prodotto.setDescrizione(resultSet.getString("descrizione"));
        prodotto.setFotoprodotto(resultSet.getBytes("fotoprodotto"));
        prodotto.setNome(resultSet.getString("nome"));
        prodotto.setPrezzo(resultSet.getDouble("prezzo"));
        return prodotto;
    }
}
