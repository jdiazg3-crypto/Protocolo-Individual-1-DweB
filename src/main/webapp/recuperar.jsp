<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recuperar Contraseña</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow">
                <div class="card-header text-center bg-warning">
                    <h4>Recuperar Contraseña</h4>
                </div>
                <div class="card-body">
                    <% if(request.getAttribute("mensaje") != null) { %>
                        <div class="alert alert-success"><%= request.getAttribute("mensaje") %></div>
                    <% } %>
                    <% if(request.getAttribute("error") != null) { %>
                        <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
                    <% } %>
                    <form action="RecuperarClaveServlet" method="post">
                        <div class="mb-3">
                            <label class="form-label">Nombre de Usuario a Recuperar</label>
                            <input type="text" name="nombre" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Correo Electrónico de Destino</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-warning w-100">Enviar Clave</button>
                    </form>
                    <div class="mt-3 text-center">
                        <a href="login.jsp">Volver al Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
