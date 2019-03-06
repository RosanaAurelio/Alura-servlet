<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Empresas</title>
	</head>
	<body>
		<h2>Empresas</h2>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}"/>
					<a href="/gerenciador/controller?acao=ObtemEmpresaPorId&id=${empresa.id}">Editar</a>|
					<a href="/gerenciador/controller?acao=ExcluiEmpresa&id=${empresa.id}">Excluir</a>
				</li>
			</c:forEach>
		</ul>				
	</body>
</html>