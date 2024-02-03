<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="prodotti.Prodotti" %>
<%@ page import="prodotti.ProdottiDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Selezione Prodotti</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        h2 {
            margin-bottom: 20px;
        }

        form {
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

        button {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mt-4">Selezione Prodotti</h2>

    <form action="processaAcquisto.jsp" method="post">
        <table class="table">
            <tr>
                <th>ID Prodotto</th>
                <th>Nome Prodotto</th>
                <th>Prezzo</th>
                <th>Quantità</th>
            </tr>
            <%
                ProdottiDAO prodottiDAO = new ProdottiDAO();
                List<Prodotti> prodottiList = prodottiDAO.getAllProdotti();

                for (Prodotti prodotto : prodottiList) {
            %>
                    <tr>
                        <td><%= prodotto.getIdProdotto() %></td>
                        <td><%= prodotto.getNome() %></td>
                        <td><%= prodotto.getPrezzo() %></td>
                        <td><input type="number" name="quantita_<%= prodotto.getIdProdotto() %>" value="0" min="0"></td>
                    </tr>
            <%
                }
            %>
        </table>

        <button type="submit" class="btn btn-primary">Acquista Prodotti</button>
    </form>

    <a href="index.jsp" class="btn btn-secondary">Torna alla Pagina Principale</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
