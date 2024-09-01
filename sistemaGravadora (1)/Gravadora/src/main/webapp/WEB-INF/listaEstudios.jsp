<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Estúdios</title>
</head>
<body>
    <h1>Lista de Estúdios</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Número de Músicas Gravadas</th>
            <th>Taxa por Hora de Estúdio</th>
            <th>Ações</th>
        </tr>
        <c:forEach items="${listaEstudios}" var="estudio">
            <tr>
                <td>${estudio.id}</td>
                <td>${estudio.nome}</td>
                <td>${estudio.numMusicasGravadas}</td>
                <td>${estudio.taxaHoraEstudio}</td>
                <td>
                    <a href="estudioServlet?action=formularioEditar&id=${estudio.id}">Editar</a>
                    <a href="estudioServlet?action=excluir&id=${estudio.id}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="estudioServlet?action=formularioAdicionar">Adicionar Estúdio</a>
</body>
</html>
