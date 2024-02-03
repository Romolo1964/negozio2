<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Utenti" %>

<html>
<head>
    <title>Conferma Eliminazione Utente</title>
    <!-- Aggiungi il link a Bootstrap per migliorare l'estetica -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            text-align: center;
        }

        p {
            text-align: center;
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
    <h2>Conferma Eliminazione Utente</h2>

		<!-- Mostra le informazioni dell'utente eliminato 
  Utenti utenteEliminato = (Utenti) request.getAttribute("utenteEliminato");"); %>
    <p>UtenteutenteEliminato.getNome()e() %>utenteEliminato.getCognome()e() %> con IDutenteEliminato.getIdUtente()e() %> è stato eliminato con successo.</p>
-->
		<!-- Link per tornare alla pagina principale -->
    <a href="index.jsp">Torna alla Pagina Principale</a>
</div>

</body>
</html>
