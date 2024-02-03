package prodotti;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InserimentoProdottoServlet2 ")
public class InserimentoProdottoServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Ottieni i parametri dalla richiesta
        String categoria = request.getParameter("categoria");
        String descrizione = request.getParameter("descrizione");
        String nome = request.getParameter("nome");
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));

        // Crea un oggetto Prodotti con i parametri ricevuti
        Prodotti prodotto = new Prodotti(0, categoria, descrizione, null, nome, prezzo);

        // Crea un oggetto ProdottiDAO e chiama il metodo insertProdotti
        ProdottiDAO prodottiDAO = new ProdottiDAO();
        prodottiDAO.insertProdotti(prodotto);

        // Puoi reindirizzare l'utente a una conferma o a una pagina di visualizzazione
        response.sendRedirect("ConfermaInserimento.jsp");
    }
}
