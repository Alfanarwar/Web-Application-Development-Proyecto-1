package proyecto1.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto1.core.Direccion;
import proyecto1.core.Persona;
import proyecto1.core.Usuario;
import proyecto1.database.Connector;

@SuppressWarnings("serial")
public class GetPersonaPorId extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
    throws ServletException, IOException {
        Connector   connector = null;
        Direccion   direccion = null;
        Persona     persona = null;
        Usuario     usuario = null;
        PrintWriter writer = null;
        int         idPersona = 0;
        
        try {
            connector = new Connector();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        idPersona = Integer.parseInt(request.getParameter("id_persona"));
        
        try {
            usuario = connector.queryUsuarioByIdUsuario(idPersona);
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        try {
            persona = connector.queryPersonaByIdPersona(idPersona);
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        try {
            writer = response.getWriter();
        } catch(IOException exception) {
            throw exception;
        }
        
        try {
            direccion = connector.queryDireccionByIdPersona(idPersona);
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        response.setContentType("text/plain; charset=UTF-8");
        
        writer.println("<p>");
        writer.println("    <label>Login</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"tx_login\" value=\"" + usuario.getTxLogin() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Password</label>");
        writer.println("    <input class=\"w3-input\" type=\"password\" name=\"tx_password\" value=\"" + usuario.getTxPassword() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Nombre</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"nb_persona\" value=\"" + persona.getNbPersona() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Primer apellido</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"tx_primer_ap\" value=\"" + persona.getTxPrimerAp() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Segundo apellido</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"tx_segundo_ap\" value=\"" + persona.getTxSegundoAp() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Fecha de nacimiento</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"fh_nacimiento\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Entidad</label>");
        writer.println("    <select id=\"select-entidades\" class=\"w3-select\" name=\"select-entidad\" form=\"form-persona\">");
        writer.println("    </select>");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Calle</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"nb_calle\" value=\"" + direccion.getNbCalle() + "\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Colonia</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"nb_colonia\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Ciudad</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"nb_ciudad\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <label>Código postal</label>");
        writer.println("    <input class=\"w3-input\" type=\"text\" name=\"tx_cp\">");
        writer.println("</p>");
        
        writer.println("<p>");
        writer.println("    <input class=\"w3-btn w3-blue\" type=\"submit\" value=\"Actualizar\">");
        writer.println("</p>");
        
        writer.close();
    }
}
