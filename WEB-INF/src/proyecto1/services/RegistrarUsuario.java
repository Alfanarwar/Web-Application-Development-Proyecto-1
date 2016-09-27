package proyecto1.services;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto1.database.Connector;

@SuppressWarnings("serial")
public class RegistrarUsuario extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest  request,
                       HttpServletResponse response)
    throws ServletException, IOException {
        Connector  connector = null;
        String     txLogin = null;
        String     txPassword = null;
        String     nbPersona = null;
        String     txPrimerAp = null;
        String     txSegundoAp = null;
        String     fhNacimiento = null;
        int        idEntidad = 0;
        String     nbCalle = null;
        String     nbColonia = null;
        String     nbCiudad = null;
        String     txCp = null;
        
        try {
            connector = new Connector();
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
        
        txLogin = request.getParameter("tx_login");
        txPassword = request.getParameter("tx_password");
        nbPersona = request.getParameter("nb_persona");
        txPrimerAp = request.getParameter("tx_primer_ap");
        txSegundoAp = request.getParameter("tx_segundo_ap");
        fhNacimiento = request.getParameter("fh_nacimiento");
        idEntidad = Integer.parseInt(request.getParameter("select-entidad"));
        nbCalle = request.getParameter("nb_calle");
        nbColonia = request.getParameter("nb_colonia");
        nbCiudad = request.getParameter("nb_ciudad");
        txCp = request.getParameter("tx_cp");
        
        try {
            connector.insertUsuario(txLogin,
                                    txPassword,
                                    nbPersona,
                                    txPrimerAp,
                                    txSegundoAp,
                                    fhNacimiento,
                                    idEntidad,
                                    nbCalle,
                                    nbColonia,
                                    nbCiudad,
                                    txCp);
        } catch(SQLException exception) {
            throw new ServletException(exception);
        }
    }
}
