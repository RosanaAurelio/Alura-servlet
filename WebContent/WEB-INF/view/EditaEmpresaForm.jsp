<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="linkEditaEmpresaServlet" value= "/controller" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editar Empresa</title>
	</head>
	<body>
		<form method="post" action="${linkEditaEmpresaServlet}" >
			<label for="idNome">Nome</label><input name="nome" id="idNome" value="${empresa.nome}"/>
			<label for="idDataAbertura">Data Abertura</label><input name="dataAbertura" id="idDataAbertura" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/>"/>
			<input type="submit">
			<input type="hidden" value="EditaEmpresa" name="acao"/>
			<input type="hidden" value="${empresa.id}" name="id"/>
		</form>	
	</body>
</html>