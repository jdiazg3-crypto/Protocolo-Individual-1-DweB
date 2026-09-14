<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Usuario - Gestión Fútbol</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2>${usuarioObj != null ? "Editar" : "Nuevo"} Usuario</h2>
    <form action="UsuarioServlet" method="post">
        <input type="hidden" name="accion" value="guardar">
        <input type="hidden" name="id" value="${usuarioObj != null ? usuarioObj.id : ''}">
        
        <div class="row">
            <div class="col-md-6 mb-3">
                <label>Nombre</label>
                <input type="text" name="nombre" class="form-control" value="${usuarioObj.nombre}" required>
            </div>
            <div class="col-md-6 mb-3">
                <label>Clave</label>
                <input type="password" name="clave" class="form-control" value="${usuarioObj.clave}" required>
            </div>
            <div class="col-md-6 mb-3">
                <label>Rol</label>
                <select name="rol" class="form-select" required>
                    <option value="ADMINISTRADOR" ${usuarioObj != null && usuarioObj.rol == 'ADMINISTRADOR' ? 'selected' : ''}>Administrador</option>
                    <option value="USUARIO" ${usuarioObj != null && usuarioObj.rol == 'USUARIO' ? 'selected' : ''}>Usuario</option>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
        <a href="UsuarioServlet?accion=listar" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
