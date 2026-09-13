package com.proyecto.servlet;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
    private UsuarioDAO dao = new UsuarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        switch (accion) {
            case "nuevo":
                request.getRequestDispatcher("usuario_form.jsp").forward(request, response);
                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                Usuario usuario = dao.obtenerPorId(idEditar);
                request.setAttribute("usuarioObj", usuario);
                request.getRequestDispatcher("usuario_form.jsp").forward(request, response);
                break;
            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("UsuarioServlet?accion=listar");
                break;
            case "reportes":
                request.getRequestDispatcher("usuario_reportes.jsp").forward(request, response);
                break;
            case "reporteRol":
                String rol = request.getParameter("rol");
                List<Usuario> r1 = dao.reportePorRol(rol);
                request.setAttribute("listaUsuarios", r1);
                request.getRequestDispatcher("usuario_reportes.jsp").forward(request, response);
                break;
            case "reporteNombre":
                String nombre = request.getParameter("nombre");
                List<Usuario> r2 = dao.reportePorNombre(nombre);
                request.setAttribute("listaUsuarios", r2);
                request.getRequestDispatcher("usuario_reportes.jsp").forward(request, response);
                break;
            case "listar":
            default:
                List<Usuario> lista = dao.listarTodos();
                request.setAttribute("listaUsuarios", lista);
                request.getRequestDispatcher("usuario_list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if ("guardar".equals(accion)) {
            String idStr = request.getParameter("id");
            Usuario u = new Usuario(
                (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0,
                request.getParameter("nombre"),
                request.getParameter("clave"),
                request.getParameter("rol")
            );

            if (u.getId() == 0) {
                dao.insertar(u);
            } else {
                dao.actualizar(u);
            }
            response.sendRedirect("UsuarioServlet?accion=listar");
        }
    }
}
