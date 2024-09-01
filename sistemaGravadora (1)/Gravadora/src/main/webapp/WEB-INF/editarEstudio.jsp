<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Estúdio</title>
</head>
<body>
    <h1>Editar Estúdio</h1>
    <form action="estudioServlet?action=editar" method="post">
        <input type="hidden" name="id" value="${estudio.id}">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="${estudio.nome}" required><br><br>
        <label for="numMusicasGravadas">Número de Músicas Gravadas:</label>
        <input type="number" id="numMusicasGravadas" name="numMusicasGravadas" value="${estudio.numMusicasGravadas}" required><br><br>
        <label for="taxaHoraEstudio">Taxa por Hora de Estúdio:</label>
        <input type="number" id="taxaHoraEstudio" name="taxaHoraEstudio" value="${estudio.taxaHoraEstudio}" step="0.01" required><br><br>
        <input type="submit" value="Salvar">
    </form>
    <br>
    <a href="estudioServlet?action=listar">Cancelar e Voltar para Lista de Estúdios</a>
</body>
</html>
