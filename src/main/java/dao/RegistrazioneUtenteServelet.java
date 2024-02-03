package dao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utenti;

@WebServlet("/RegistrazioneUtenteServelet")
public class RegistrazioneUtenteServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera i parametri dalla richiesta
        String email = request.getParameter("email");
        String indirizzo = request.getParameter("indirizzo");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");

        // Crea un nuovo oggetto Utenti
        Utenti nuovoUtente = new Utenti(email, indirizzo, password, username, nome, cognome);
        System.out.println(nuovoUtente);
        // Salva il nuovo utente nel database utilizzando UtenteDao
        UtenteDao utenteDao = new UtenteDao();
        utenteDao.aggiungiUtente(nuovoUtente);

        // Puoi anche reindirizzare l'utente a una pagina di conferma o login
       // response.sendRedirect("vista/confermaReg.jsp");
                
        		request.getRequestDispatcher("vista/confermaReg.jsp").forward(request, response);
    }
}
