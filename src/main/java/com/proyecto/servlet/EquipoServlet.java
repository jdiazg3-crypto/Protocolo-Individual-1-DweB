package com.proyecto.servlet;

import com.proyecto.dao.EquipoFutbolDAO;
import com.proyecto.modelo.EquipoFutbol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EquipoServlet")
public class EquipoServlet extends HttpServlet {
    private EquipoFutbolDAO dao = new EquipoFutbolDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        switch (accion) {
            case "nuevo":
                request.getRequestDispatcher("equipo_form.jsp").forward(request, response);
                break;
            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                EquipoFutbol equipo = dao.obtenerPorId(idEditar);
                request.setAttribute("equipo", equipo);
                request.getRequestDispatcher("equipo_form.jsp").forward(request, response);
                break;
            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("EquipoServlet?accion=listar");
                break;
            case "reportes":
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
                break;
            case "reporte1":
                String pais = request.getParameter("pais");
                String categoria = request.getParameter("categoria");
                List<EquipoFutbol> r1 = dao.reportePaisCategoria(pais, categoria);
                request.setAttribute("listaEquipos", r1);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
                break;
            case "reporte2":
                int minCampeonatos = Integer.parseInt(request.getParameter("minCampeonatos"));
                int minGanados = Integer.parseInt(request.getParameter("minGanados"));
                List<EquipoFutbol> r2 = dao.reporteMinCampeonatosPartidos(minCampeonatos, minGanados);
                request.setAttribute("listaEquipos", r2);
                request.getRequestDispatcher("reportes.jsp").forward(request, response);
                break;
            case "listar":
            default:
                List<EquipoFutbol> lista = dao.listarTodos();
                request.setAttribute("listaEquipos", lista);
                request.getRequestDispatcher("equipo_list.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if ("guardar".equals(accion)) {
            String idStr = request.getParameter("id");
            EquipoFutbol eq = new EquipoFutbol(
                (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0,
                request.getParameter("nombre"),
                request.getParameter("eslogan"),
                request.getParameter("tecnico"),
                request.getParameter("pais"),
                request.getParameter("ciudad"),
                request.getParameter("categoria"),
                Integer.parseInt(request.getParameter("numGoles")),
                Integer.parseInt(request.getParameter("numPartidosJugados")),
                Integer.parseInt(request.getParameter("numPartidosGanados")),
                Integer.parseInt(request.getParameter("numCampeonatos")),
                Integer.parseInt(request.getParameter("numExpulsiones")),
                Integer.parseInt(request.getParameter("numEmpates"))
            );

            if (eq.getId() == 0) {
                dao.insertar(eq);
            } else {
                dao.actualizar(eq);
            }
            response.sendRedirect("EquipoServlet?accion=listar");
        }
    }
}
