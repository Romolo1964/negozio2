<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="prodotti.Prodotti" %>

<html>
<head>
    <title>Inserimento Prodotto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 30px;
        }

        .container {
            width: 400px;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form {
            text-align: center;
        }

        input[type="text"] {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
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

<div class="container">
    <h2 class="mb-4">Inserimento Prodotto</h2>

    <!-- Form per l'inserimento del prodotto -->
    <form action="InserimentoProdottoServlet2" method="post">
        <!-- Campo Categoria -->
        <div class="form-group">
            <label for="categoria">Categoria:</label>
            <input type="text" class="form-control" id="categoria" name="categoria" required>
        </div>
        <!-- Campo Descrizione -->
        <div class="form-group">
            <label for="descrizione">Descrizione:</label>
            <input type="text" class="form-control" id="descrizione" name="descrizione" required>
        </div>
        <!-- Campo Nome -->
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>
        <!-- Campo Prezzo -->
        <div class="form-group">
            <label for="prezzo">Prezzo:</label>
            <input type="text" class="form-control" id="prezzo" name="prezzo" required>
        </div>
        <!-- Pulsante di invio -->
        <button type="submit" class="btn btn-success">Inserisci Prodotto</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
