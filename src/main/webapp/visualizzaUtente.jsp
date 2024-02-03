<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.UtenteDao" %>
<%@ page import="model.Utenti" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Visualizzazione Utente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            margin-bottom: 20px;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        p {
            margin-top: 20px;
        }

        a.btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mt-4">Dettagli Utente</h2>

    <%
        String idUtenteStr = request.getParameter("idUtente");

        if (idUtenteStr != null && !idUtenteStr.isEmpty()) {
            int idUtente = Integer.parseInt(idUtenteStr);
            UtenteDao utenteDao = new UtenteDao();
            Utenti utente = utenteDao.trovaUtentePerId(idUtente);

            if (utente != null) {
    %>
                <table class="table">
                    <tr>
                        <th>ID Utente</th>
                        <th>Email</th>
                        <th>Indirizzo</th>
                        <th>Username</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                    </tr>
                    <tr>
                        <td><%= utente.getIdUtente() %></td>
                        <td><%= utente.getEmail() %></td>
                        <td><%= utente.getIndirizzo() %></td>
                        <td><%= utente.getUsername() %></td>
                        <td><%= utente.getNome() %></td>
                        <td><%= utente.getCognome() %></td>
                    </tr>
                </table>
    <%
            } else {
    %>
                <p>Utente non trovato.</p>
    <%
            }
        } else {
    %>
        <p>Per favore, inserisci un ID Utente valido.</p>
    <%
        }
    %>

    <a href="index.jsp" class="btn btn-secondary">Torna alla Pagina Principale</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
