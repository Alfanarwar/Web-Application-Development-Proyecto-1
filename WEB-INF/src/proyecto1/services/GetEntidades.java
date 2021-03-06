package proyecto1.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto1.core.Entidad;
import proyecto1.database.Connector;

@SuppressWarnings("serial")
public class GetEntidades extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {
        Connector          connector = null;
        ArrayList<Entidad> entidades = null;
        PrintWriter        writer = null;
        
        try {
            connector = new Connector();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        try {
            entidades = connector.queryAllEntidades();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        try {
            writer = response.getWriter();
        } catch(IOException exception) {
            throw exception;
        }
        
        response.setContentType("text/plain; charset=UTF-8");
        
        writer.println("<option value=\"\" selected></option>");
        
        for(Entidad entidad: entidades) {
            writer.println("<option value=\"" + entidad.getIdEntidad() + "\">" + entidad.getNbEntidad() + "</option>");
        }
        
        writer.close();
    }
}
