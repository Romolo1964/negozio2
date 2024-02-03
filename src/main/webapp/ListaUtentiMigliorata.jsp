<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Utenti" %>
<%@ page import="dao.UtenteDao" %>

<html>
<head>
    <title>Lista Utenti</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy2fNK3Ziz5kAY0a9tKfcIDz9eb5IyF3x"
          crossorigin="anonymous">
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
            margin: 30px auto;
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

        .delete-btn {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 5px 10px;
            margin: 5px;
            cursor: pointer;
            border-radius: 3px;
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

    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Azioni</th>
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
                    <td>
                        <form action="EliminaUtenteServlet" method="post">
                            <input type="hidden" name="idUtente" value="<%= utente.getIdUtente() %>">
                            <button type="submit" class="btn btn-danger delete-btn">Elimina</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <a href="index.jsp" class="btn btn-primary">Torna alla Index</a>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mI5lz5d1/PPUGmFjA7cm3zBxPBnVFxR+0N3h5h/qg6KgQbF5ksa8I3LI"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy2fNK3Ziz5kAY0a9tKfcIDz9eb5IyF3x"
        crossorigin="anonymous"></script>
</body>
</html>
