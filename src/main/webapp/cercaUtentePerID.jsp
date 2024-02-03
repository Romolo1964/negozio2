<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ricerca Utente per ID</title>
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

        a.btn {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mt-4">Ricerca Utente per ID</h2>

    <form action="visualizzaUtente.jsp" method="get">
        <div class="form-group">
            <label for="idUtente">Inserisci l'ID Utente:</label>
            <input type="text" class="form-control" id="idUtente" name="idUtente" required>
        </div>
        <button type="submit" class="btn btn-primary">Cerca</button>
    </form>

    <a href="index.jsp" class="btn btn-secondary">Torna alla Pagina Principale</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

