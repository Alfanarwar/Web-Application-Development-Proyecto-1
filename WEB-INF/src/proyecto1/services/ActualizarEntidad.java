package proyecto1.services;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto1.database.Connector;

@SuppressWarnings("serial")
public class ActualizarEntidad extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest  request,
                       HttpServletResponse response)
    throws ServletException, IOException {
        Connector connector = null;
        int       idEntidad = 0;
        String    nbEntidad = null;
        
        try {
            connector = new Connector();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        idEntidad = Integer.parseInt(request.getParameter("id_entidad"));
        nbEntidad = request.getParameter("nb_entidad");
    
        try {
            connector.alterEntidad(idEntidad,
                                   nbEntidad);
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
    }
}
