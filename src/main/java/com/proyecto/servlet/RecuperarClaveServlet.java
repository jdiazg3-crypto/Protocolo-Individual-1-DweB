package com.proyecto.servlet;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.modelo.Usuario;
import com.proyecto.util.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RecuperarClaveServlet")
public class RecuperarClaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String emailDestino = request.getParameter("email");
        
        UsuarioDAO dao = new UsuarioDAO();
        // Buscar el usuario por su nombre exacto (Usaremos el reportePorNombre pero filtrando el exacto)
        List<Usuario> usuarios = dao.reportePorNombre(nombre);
        Usuario usuarioEncontrado = null;
        
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            boolean exito = EmailUtil.enviarCorreoRecuperacion(emailDestino, usuarioEncontrado.getNombre(), usuarioEncontrado.getClave());
            if (exito) {
                request.setAttribute("mensaje", "Se ha enviado la clave al correo proporcionado.");
            } else {
                request.setAttribute("error", "Hubo un error interno al enviar el correo.");
            }
        } else {
            request.setAttribute("error", "El nombre de usuario no existe en la base de datos.");
        }
        
        request.getRequestDispatcher("recuperar.jsp").forward(request, response);
    }
}
