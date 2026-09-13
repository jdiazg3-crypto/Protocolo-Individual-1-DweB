package com.proyecto.servlet;

import com.proyecto.dao.UsuarioDAO;
import com.proyecto.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if ("ingresar".equals(accion)) {
            String nombre = request.getParameter("nombre");
            String clave = request.getParameter("clave");
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = dao.login(nombre, clave);

            if (u != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", u);
                response.sendRedirect("EquipoServlet?accion=listar");
            } else {
                request.setAttribute("error", "Credenciales incorrectas");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if ("salir".equals(accion)) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
