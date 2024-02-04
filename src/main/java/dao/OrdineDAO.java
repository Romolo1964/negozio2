package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.MyConnection;
import model.Utenti;

public class OrdineDAO {

    private Connection connection;

    public OrdineDAO() {
        // Ottenere la connessione dal tuo sistema di gestione delle connessioni (MyConnection)
        this.connection = MyConnection.getConnetion();
    }

    public void insertOrdine(Ordine ordine) {
        try {
            String sql = "INSERT INTO Ordini (idUtente) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, ordine.getIdUtente());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
    }

    public Ordine getOrdineById(int idOrdine) {
        Ordine ordine = null;
        try {
            String sql = "SELECT * FROM Ordini WHERE idOrdine=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idOrdine);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        ordine = mapResultSetToOrdine(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
        return ordine;
    }

    public List<Ordine> getAllOrdini() {
        List<Ordine> ordini = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Ordini";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ordine ordine = mapResultSetToOrdine(resultSet);
                    ordini.add(ordine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
        return ordini;
    }

    private Ordine mapResultSetToOrdine(ResultSet resultSet) throws SQLException {
        Ordine ordine = new Ordine();
        ordine.setIdOrdine(resultSet.getInt("idOrdine"));
        ordine.setIdUtente(resultSet.getInt("idUtente"));
        ordine.setDataOrdine(resultSet.getTimestamp("dataOrdine"));
        return ordine;
    }

    public void deleteOrdine(int idOrdine) {
        try {
            String sql = "DELETE FROM Ordini WHERE idOrdine=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idOrdine);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
    }

    public void updateOrdine(Ordine ordine) {
        try {
            String sql = "UPDATE Ordini SET idUtente=?, dataOrdine=? WHERE idOrdine=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, ordine.getIdUtente());
                statement.setTimestamp(2, new Timestamp(System.currentTimeMillis())); // Aggiorna la data dell'ordine
                statement.setInt(3, ordine.getIdOrdine());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
    }
    /**
     * Ottiene una rappresentazione String dell'utente associato a un ordine.
     *
     * @param idOrdine ID dell'ordine per cui ottenere l'utente associato.
     * @return Rappresentazione String dell'utente associato all'ordine o null se non trovato.
     */
    public String getUtenteStringByOrdineId(int idOrdine) {
        try {
            // Query SQL per selezionare l'utente associato all'ordine dato l'ID dell'ordine
            String sql = "SELECT u.* FROM Utenti u JOIN Ordini o ON u.idUtente = o.idUtente WHERE o.idOrdine=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idOrdine);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Se esiste un risultato, mappa il ResultSet a un oggetto Utenti
                        UtenteDao utenteDao = new UtenteDao();
                        Utenti utente = UtenteDao.mapResultSetToUtente(resultSet);
                        
                        // Restituisce la rappresentazione String dell'utente
                        return utente.toString();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestire l'eccezione in modo appropriato
        }
        
        // Se non viene trovato alcun utente, restituisce null
        return null;
    }
}


