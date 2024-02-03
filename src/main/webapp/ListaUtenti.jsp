<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Utenti" %>
<%@ page import="dao.UtenteDao" %>

<html>
<head>
    <title>Lista Utenti</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f571;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 30px;
        }

        .container {
            width: 600px;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #333;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Lista Utenti</h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Nome</th>
                <th>Cognome</th>
            </tr>
        </thead>
        <tbody>
            <% List<Utenti> utenti = new UtenteDao().trovaTuttiUtenti();
               for (Utenti utente : utenti) { %>
                <tr>
                    <td><%= utente.getIdUtente() %></td>
                    <td><%= utente.getEmail() %></td>
                    <td><%= utente.getNome() %></td>
                    <td><%= utente.getCognome() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <a href="index.jsp">Torna alla Index</a>
</div>

</body>
</html>
