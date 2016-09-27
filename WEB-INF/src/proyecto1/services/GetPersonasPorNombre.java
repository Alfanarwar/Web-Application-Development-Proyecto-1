package proyecto1.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto1.core.Persona;
import proyecto1.database.Connector;

@SuppressWarnings("serial")
public class GetPersonasPorNombre extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {
        Connector          connector = null;
        ArrayList<Persona> personas = null;
        PrintWriter        writer = null;
        String             nbPersona = null;
        
        try {
            connector = new Connector();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        nbPersona = request.getParameter("nb_persona");
        
        try {
            personas = connector.queryPersonasByName(nbPersona);
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
        
        for(Persona persona: personas) {
            writer.println("<option value=\"" +
                           persona.getIdPersona() +
                           "\" onclick=\"loadPersona(this.value)\">" +
                           persona.getNbPersona() + 
                           " " + persona.getTxPrimerAp() +
                           " " + persona.getTxSegundoAp() +
                           "</option>");
        }
        
        writer.close();
    }
}
