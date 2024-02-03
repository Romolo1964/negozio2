<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="prodotti.Prodotti" %>
<%@ page import="prodotti.ProdottiDAO" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrazione Utente</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            width: 300px;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
            color: #333;
        }

        input {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <!-- Titolo della pagina -->
    <h1>Registrazione Utente</h1>

    <!-- Form per la registrazione dell'utente -->
    <form action="RegistrazioneUtenteServelet" method="post">
        <!-- Campo Email -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <!-- Campo Indirizzo -->
        <label for="indirizzo">Indirizzo:</label>
        <input type="text" id="indirizzo" name="indirizzo" required>

        <!-- Campo Password -->
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <!-- Campo Username -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <!-- Campo Nome -->
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <!-- Campo Cognome -->
        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" required>

        <!-- Pulsante di registrazione -->
        <input type="submit" value="Registrati">
    </form>

</body>
</html>
