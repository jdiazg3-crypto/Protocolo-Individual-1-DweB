<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reportes Usuarios - Gestión Fútbol</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Gestión Fútbol</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link" href="EquipoServlet?accion=listar">Equipos</a></li>
                <li class="nav-item"><a class="nav-link" href="UsuarioServlet?accion=listar">Usuarios</a></li>
                <li class="nav-item"><a class="nav-link" href="EquipoServlet?accion=reportes">Reportes Equipos</a></li>
                <li class="nav-item"><a class="nav-link active" href="UsuarioServlet?accion=reportes">Reportes Usuarios</a></li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="LoginServlet?accion=salir">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2>Reportes de Usuarios</h2>
    
    <div class="row mt-4">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Reporte 1: Filtrar por Rol</div>
                <div class="card-body">
                    <form action="UsuarioServlet" method="get">
                        <input type="hidden" name="accion" value="reporteRol">
                        <div class="mb-2">
                            <label>Rol</label>
                            <select name="rol" class="form-select" required>
                                <option value="ADMINISTRADOR">Administrador</option>
                                <option value="USUARIO">Usuario</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Generar</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">Reporte 2: Buscar por Nombre</div>
                <div class="card-body">
                    <form action="UsuarioServlet" method="get">
                        <input type="hidden" name="accion" value="reporteNombre">
                        <div class="mb-2">
                            <label>Nombre</label>
                            <input type="text" name="nombre" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Generar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${listaUsuarios != null}">
        <h4 class="mt-4">Resultados</h4>
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr><th>ID</th><th>Nombre</th><th>Rol</th></tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${listaUsuarios}">
                    <tr>
                        <td>${u.id}</td>
                        <td>${u.nombre}</td>
                        <td>${u.rol}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty listaUsuarios}">
                    <tr><td colspan="3" class="text-center">No se encontraron resultados</td></tr>
                </c:if>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
