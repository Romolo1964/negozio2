<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="dao.UtenteDao"%>
<%@ page import="model.Utenti"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualizzazione Utente</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
	border-color: reed;
	border-radius: 5px;
}

table, th, td {
	border: 5px solid #ddd;
	border-radius: 5px;
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
home {
margin:auto;
border-radius: 5px;
border-color: red;
}
}

</style>
</head>
<body>
<div class="home">


<button type="button" class="btn btn-info" onclick="window.location.href='index.jsp'">Torna alla Pagina Principale</button>




</div>
	
	<div class="container">
		
				<h2 class="mt-4">Dettaglio Utente trovato ...</h2>

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
						<th>${utente.getIdUtente}</th>
						<th>Email</th>
						<th>Indirizzo</th>
						<th>Username</th>
						<th>Nome</th>
						<th>Cognome</th>
					</tr>
					<tr>
						<td><%=utente.getIdUtente()%></td>
						<td>${utente.getIdUtente()}</td>
						<td><%=utente.getEmail()%></td>
						<td><%=utente.getIndirizzo()%></td>
						<td><%=utente.getUsername()%></td>
						<td><%=utente.getNome()%></td>
						<td><%=utente.getCognome()%></td>
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
			

		


		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">${utente.getNome() }</h5>
				<h6 class="card-subtitle mb-2 text-muted"></h6>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
		</div>




		<a href="index.jsp" class="btn btn-secondary">Torna alla Pagina Principale</a>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
