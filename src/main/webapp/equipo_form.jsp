<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Equipo - Gestión Fútbol</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>${equipo != null ? "Editar" : "Nuevo"} Equipo</h2>
    <form action="EquipoServlet" method="post">
        <input type="hidden" name="accion" value="guardar">
        <input type="hidden" name="id" value="${equipo != null ? equipo.id : ''}">
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label>Nombre</label>
                <input type="text" name="nombre" class="form-control" value="${equipo.nombre}" required>
            </div>
            <div class="col-md-6 mb-3">
                <label>Eslogan</label>
                <input type="text" name="eslogan" class="form-control" value="${equipo.eslogan}">
            </div>
            <div class="col-md-6 mb-3">
                <label>Técnico</label>
                <input type="text" name="tecnico" class="form-control" value="${equipo.tecnico}">
            </div>
            <div class="col-md-6 mb-3">
                <label>País</label>
                <input type="text" name="pais" class="form-control" value="${equipo.pais}">
            </div>
            <div class="col-md-6 mb-3">
                <label>Ciudad</label>
                <input type="text" name="ciudad" class="form-control" value="${equipo.ciudad}">
            </div>
            <div class="col-md-6 mb-3">
                <label>Categoría</label>
                <input type="text" name="categoria" class="form-control" value="${equipo.categoria}">
            </div>
            <div class="col-md-4 mb-3">
                <label>Goles</label>
                <input type="number" name="numGoles" class="form-control" value="${equipo != null ? equipo.numGoles : 0}">
            </div>
            <div class="col-md-4 mb-3">
                <label>Partidos Jugados</label>
                <input type="number" name="numPartidosJugados" class="form-control" value="${equipo != null ? equipo.numPartidosJugados : 0}">
            </div>
            <div class="col-md-4 mb-3">
                <label>Partidos Ganados</label>
                <input type="number" name="numPartidosGanados" class="form-control" value="${equipo != null ? equipo.numPartidosGanados : 0}">
            </div>
            <div class="col-md-4 mb-3">
                <label>Campeonatos</label>
                <input type="number" name="numCampeonatos" class="form-control" value="${equipo != null ? equipo.numCampeonatos : 0}">
            </div>
            <div class="col-md-4 mb-3">
                <label>Expulsiones</label>
                <input type="number" name="numExpulsiones" class="form-control" value="${equipo != null ? equipo.numExpulsiones : 0}">
            </div>
            <div class="col-md-4 mb-3">
                <label>Empates</label>
                <input type="number" name="numEmpates" class="form-control" value="${equipo != null ? equipo.numEmpates : 0}">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
        <a href="EquipoServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
