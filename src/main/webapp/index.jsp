<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="prodotti.Prodotti" %>
<%@ page import="prodotti.ProdottiDAO" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Benvenuto nel Sito</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 20px;
        }

        nav {
            background-color: #ddd;
            padding: 10px;
            text-align: center;
        }

        nav a {
            margin: 0 15px;
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            text-align: center;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            text-decoration: none;
            background-color: #333;
            color: white;
            border-radius: 5px;
        }

        .product {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<!-- Header -->
<header>
    <h1>Ciao Benvenuto nel Negozio migliore del Supermercato ......</h1>
</header>

<!-- Navigation -->
<nav>
    <a href="#">Home</a>
    <a href="ListaUtenti.jsp">Mostra ListaUtenti Registrati</a>
    <a href="InsProdotto.jsp">Inserisci un Prodotto</a>
    <a href="ListaProdotti.jsp">Mostra la lista dei prodotti .</a>
    <a href="ListaUtentiMigliorata.jsp">Mostra Lista Utenti . .</a>
    <a href="RegistrazioneUtente.jsp">RegistrazioneUtente</a>
    <a href="cercaUtentePerID.jsp">Cerca Utente per ID</a>
</nav>

<!-- Main Content -->
<div class="container">
    <p>Sei nella nostra HOME </p>
</div>
<div class="container">
    <h2 class="mb-4">Lista Prodotti</h2>

    <% 
        List<Prodotti> prodottiList = new ProdottiDAO().getAllProdotti();
        for (Prodotti prodotto : prodottiList) { 
    %>
        <div class="product">
            <p>Prodotto ID: <%= prodotto.getIdProdotto() %></p>
            <h3><%= prodotto.getNome() %></h3>
            <p>Categoria: <%= prodotto.getCategoria() %></p>
            <p>Descrizione: <%= prodotto.getDescrizione() %></p>
            <p>Prezzo: <%= prodotto.getPrezzo() %> Euro</p>
            <hr>
        </div>
    <% } %>
</div>
<div class="container">
    <a href="prodottiDaAcquistare.jsp" class="btn btn-primary">Vuoi acquistare i nostri prodotti ???</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
