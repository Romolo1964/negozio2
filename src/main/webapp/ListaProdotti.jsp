<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="prodotti.Prodotti" %>
<%@ page import="prodotti.ProdottiDAO" %>

<html>
<head>
    <title>Lista Prodotti</title>
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
            width: 800px;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .product {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            background: #f9f9f9;
        }

        img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
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
    <h2>Lista Prodotti</h2>

    <% 
        List<Prodotti> prodottiList = new ProdottiDAO().getAllProdotti();
        for (Prodotti prodotto : prodottiList) { 
    %>
        <div class="product">
            <h3><%= prodotto.getNome() %></h3>
            <p>Categoria: <%= prodotto.getCategoria() %></p>
            <p>Descrizione: <%= prodotto.getDescrizione() %></p>
            <p>Prezzo: <%= prodotto.getPrezzo() %> Euro</p>
            
        </div>
    <% } %>

    <a href="index.jsp">Torna alla Index</a>
</div>

</body>
</html>
