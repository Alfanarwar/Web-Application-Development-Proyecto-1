package proyecto1.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto1.core.Entidad;
import proyecto1.database.Connector;

@SuppressWarnings("serial")
public class GetEntidadPorId extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {
        Connector   connector = null;
        Entidad     entidad = null;
        PrintWriter writer = null;
        int         idEntidad = 0;
        
        try {
            connector = new Connector();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        idEntidad = Integer.parseInt(request.getParameter("id_entidad"));
        
        try {
            entidad = connector.queryEntidadByIdEntidad(idEntidad);
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        try {
            writer = response.getWriter();
        } catch(IOException exception) {
            throw exception;
        }
        
        response.setContentType("text/plain; charset=UTF-8");
        
        writer.println("<p>");
        writer.println("    <label>Nombre</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"id_entidad\" value=\"" + entidad.getIdEntidad() + "\" style=\"display: none\">");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"nb_entidad\" value=\"" + entidad.getNbEntidad() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <input class=\"w3-btn w3-blue\" type=\"submit\" value=\"Actualizar\">");
        writer.println("</p>");
        
        writer.close();
    }
}
