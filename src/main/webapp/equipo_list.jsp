<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Equipos - Gestión Fútbol</title>
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
                <li class="nav-item"><a class="nav-link" href="UsuarioServlet?accion=reportes">Reportes Usuarios</a></li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <span class="nav-link text-white">Hola, ${sessionScope.usuario.nombre}</span>
                </li>
                <li class="nav-item"><a class="nav-link" href="LoginServlet?accion=salir">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h2>Lista de Equipos</h2>
    <a href="EquipoServlet?accion=nuevo" class="btn btn-success mb-3">Nuevo Equipo</a>
    
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th><th>Nombre</th><th>País</th><th>Categoría</th><th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="equipo" items="${listaEquipos}">
                <tr>
                    <td>${equipo.id}</td>
                    <td>${equipo.nombre}</td>
                    <td>${equipo.pais}</td>
                    <td>${equipo.categoria}</td>
                    <td>
                        <a href="EquipoServlet?accion=editar&id=${equipo.id}" class="btn btn-warning btn-sm">Editar</a>
                        <a href="EquipoServlet?accion=eliminar&id=${equipo.id}" class="btn btn-danger btn-sm" onclick="return confirm('¿Seguro que desea eliminar?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
