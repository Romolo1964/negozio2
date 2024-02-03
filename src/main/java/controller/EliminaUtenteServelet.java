package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.UtenteDao;

@WebServlet("/EliminaUtenteServlet")
public class EliminaUtenteServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ottieni l'id dell'utente da eliminare dalla richiesta
        int idUtente = Integer.parseInt(request.getParameter("idUtente"));

        // Crea un'istanza di UtenteDao e chiama il metodo eliminaUtente
        UtenteDao utenteDao = new UtenteDao();
        utenteDao.eliminaUtente(idUtente);
		// Reindirizza alla pagina di conferma
		response.sendRedirect("confermaEliminazione.jsp");
    }
}
