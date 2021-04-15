<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci dei dati</title>
</head>
<body>
	<h1>Inserisci un obiettivo:</h1>
	<div>
		<form action="/EsercitazioneSession/ThisSessionItemsManager">
			<input type="text" placeholder="Nuovo obiettivo" name="ogg">
			<input type="submit" value="aggiungi">
		</form>
		<p>${errorMessage}</p>
	</div>
	<table>
		<c:forEach items="${objects}" var="object">
			<tr>
				<td>${object.name}</td>
				<td>${object.isDone ? 'Fatto' : 'Da fare'}</td>
				<td><a href="/EsercitazioneSession/ThisSessionItemUpdate?id=${object.id}"><input type="button" value="Spunta"></a></td>
				<td><a href="/EsercitazioneSession/ThisSessionItemRemove?id=${object.id}"><input type="button" value="rimuovi"></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>