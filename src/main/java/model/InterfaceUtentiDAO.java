package model;

import java.util.List;

public interface InterfaceUtentiDAO {
    // Metodo per aggiungere un utente al database
    void addUser(Utenti utente);

    // Metodo per ottenere un utente dal database dato un ID
    Utenti getUserById(int userId);

    // Metodo per ottenere tutti gli utenti dal database
    List<Utenti> getAllUsers();

    // Metodo per aggiornare un utente nel database
    void updateUser(Utenti utente);

    // Metodo per eliminare un utente dal database dato un ID
    void deleteUser(int userId);
}

