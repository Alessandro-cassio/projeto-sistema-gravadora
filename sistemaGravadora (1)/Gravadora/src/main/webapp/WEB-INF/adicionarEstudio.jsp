<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Estúdio</title>
</head>
<body>
    <h1>Adicionar Estúdio</h1>
    <form action="estudioServlet?action=adicionar" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        <label for="numMusicasGravadas">Número de Músicas Gravadas:</label>
        <input type="number" id="numMusicasGravadas" name="numMusicasGravadas" required><br><br>
        <label for="taxaHoraEstudio">Taxa por Hora de Estúdio:</label>
        <input type="number" id="taxaHoraEstudio" name="taxaHoraEstudio" step="0.01" required><br><br>
        <input type="submit" value="Adicionar">
    </form>
    <br>
    <a href="estudioServlet?action=listar">Voltar para Lista de Estúdios</a>
</body>
</html>
