package proyecto1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import proyecto1.core.Direccion;
import proyecto1.core.Entidad;
import proyecto1.core.Persona;
import proyecto1.core.Usuario;

public class Connector {
    private Connection connection;
    private Statement  statement;
    
    public Connector() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            
        }
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto1",
                                                     "root",
                                                     "root");
        } catch(SQLException exception) {
            throw exception;
        }
        
        try {
            statement = connection.createStatement();
        } catch(SQLException exception) {
            throw exception;
        }
    }
    
    public void close() {
        try {
            statement.close();
            connection.close();
        }
        catch(SQLException exception) {
            
        }
    }
    
    public ArrayList<Direccion> queryAllDirecciones() throws SQLException {
        ResultSet            resultSet = null;
        String               sqlQuery = "SELECT * " +
                                        "FROM direccion;";
        ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        while(resultSet.next()) {
            direcciones.add(new Direccion(resultSet.getInt("id_persona"),
                                          resultSet.getInt("id_entidad"),
                                          resultSet.getString("nb_calle"),
                                          resultSet.getString("nb_colonia"),
                                          resultSet.getString("nb_ciudad"),
                                          resultSet.getString("tx_cp")));
        }
        
        return direcciones;
    }
    
    public Direccion queryDireccionByIdPersona(int idPersona) throws SQLException {
        ResultSet resultSet = null;
        String    sqlQuery = "SELECT * " +
                             "FROM direccion " +
                             "WHERE id_persona = " + idPersona + ";";
        Direccion direccion = null;
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        if(resultSet.next()) {
            direccion = new Direccion(resultSet.getInt("id_persona"),
                                      resultSet.getInt("id_entidad"),
                                      resultSet.getString("nb_calle"),
                                      resultSet.getString("nb_colonia"),
                                      resultSet.getString("nb_ciudad"),
                                      resultSet.getString("tx_cp"));
        }
        
        return direccion;
    }
    
    public Direccion queryDireccionByIdEntidad(int idEntidad) throws SQLException {
        ResultSet resultSet = null;
        String    sqlQuery = "SELECT * " +
                             "FROM direccion " +
                             "WHERE id_entidad = " + idEntidad + ";";
        Direccion direccion = null;
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        if(resultSet.next()) {
            direccion = new Direccion(resultSet.getInt("id_persona"),
                                      resultSet.getInt("id_entidad"),
                                      resultSet.getString("nb_calle"),
                                      resultSet.getString("nb_colonia"),
                                      resultSet.getString("nb_ciudad"),
                                      resultSet.getString("tx_cp"));
        }
        
        return direccion;
    }
    
    public ArrayList<Entidad> queryAllEntidades() throws SQLException {
        ResultSet          resultSet = null;
        String             sqlQuery = "SELECT * " +
                                      "FROM entidad;";
        ArrayList<Entidad> entidades = new ArrayList<Entidad>();
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        while(resultSet.next()) {
            entidades.add(new Entidad(resultSet.getInt("id_entidad"),
                                      resultSet.getString("nb_entidad")));
        }
        
        return entidades;
    }
    
    public Entidad queryEntidadByIdEntidad(int idEntidad) throws SQLException {
        ResultSet resultSet = null;
        String    sqlQuery = "SELECT * " +
                             "FROM entidad " +
                             "WHERE id_entidad = " + idEntidad + ";";
        Entidad   entidad = null;
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        if(resultSet.next()) {
            entidad = new Entidad(resultSet.getInt("id_entidad"),
                                  resultSet.getString("nb_entidad"));
        }
        
        return entidad;
    }
    
    public ArrayList<Entidad> queryEntidadesByName(String nbEntidad) throws SQLException {
        ResultSet          resultSet = null;
        String             sqlQuery = "SELECT * " +
                                      "FROM entidad " +
                                      "WHERE nb_entidad REGEXP '" + nbEntidad + "';";
        ArrayList<Entidad> entidades = new ArrayList<Entidad>();
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        while(resultSet.next()) {
            entidades.add(new Entidad(resultSet.getInt("id_entidad"),
                                      resultSet.getString("nb_entidad")));
        }
        
        return entidades;
    }
    
    public ArrayList<Persona> queryAllPersonas() throws SQLException {
        ResultSet          resultSet = null;
        String             sqlQuery = "SELECT * " +
                                      "FROM persona;";
        ArrayList<Persona> personas = new ArrayList<Persona>();
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        while(resultSet.next()) {
            personas.add(new Persona(resultSet.getInt("id_persona"),
                                     resultSet.getString("nb_persona"),
                                     resultSet.getString("tx_primer_ap"),
                                     resultSet.getString("tx_segundo_ap"),
                                     resultSet.getString("fh_nacimiento")));
        }
        
        return personas;
    }
    
    public Persona queryPersonaByIdPersona(int idPersona) throws SQLException {
        ResultSet resultSet = null;
        String    sqlQuery = "SELECT * " +
                             "FROM persona " +
                             "WHERE id_persona = " + idPersona + ";";
        Persona   persona = null;
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        if(resultSet.next()) {
            persona = new Persona(resultSet.getInt("id_persona"),
                                  resultSet.getString("nb_persona"),
                                  resultSet.getString("tx_primer_ap"),
                                  resultSet.getString("tx_segundo_ap"),
                                  resultSet.getString("fh_nacimiento"));
        }
        
        return persona;
    }
    
    public ArrayList<Persona> queryPersonasByName(String nbPersona) throws SQLException {
        ResultSet          resultSet = null;
        String             sqlQuery = "SELECT * " +
                                      "FROM persona " +
                                      "WHERE nb_persona REGEXP '" + nbPersona + "';";
        ArrayList<Persona> personas = new ArrayList<Persona>();
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        while(resultSet.next()) {
            personas.add(new Persona(resultSet.getInt("id_persona"),
                                     resultSet.getString("nb_persona"),
                                     resultSet.getString("tx_primer_ap"),
                                     resultSet.getString("tx_segundo_ap"),
                                     resultSet.getString("fh_nacimiento")));
        }
        
        return personas;
    }
    
    public ArrayList<Usuario> queryAllUsuarios() throws SQLException {
        ResultSet          resultSet = null;
        String             sqlQuery = "SELECT * " +
                                      "FROM usuario;";
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        while(resultSet.next()) {
            usuarios.add(new Usuario(resultSet.getInt("id_usuario"),
                                     resultSet.getString("tx_login"),
                                     resultSet.getString("tx_password")));
        }
        
        return usuarios;
    }
    
    public Usuario queryUsuarioByIdUsuario(int idUsuario) throws SQLException {
        ResultSet resultSet = null;
        String    sqlQuery = "SELECT * " +
                             "FROM usuario " +
                             "WHERE id_usuario = " + idUsuario + ";";
        Usuario   usuario = null;
        
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        if(resultSet.next()) {
            usuario = new Usuario(resultSet.getInt("id_usuario"),
                                  resultSet.getString("tx_login"),
                                  resultSet.getString("tx_password"));
        }
        
        return usuario;
    }
    
    public void insertEntidad(String nbEntidad) throws SQLException {
        String sqlQuery = "INSERT INTO entidad(nb_entidad) " +
                          "VALUES (\"" + nbEntidad + "\");";
        
        try {
            statement.executeUpdate(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
    }
    
    public void insertUsuario(String txLogin,
                              String txPassword,
                              String nbPersona,
                              String tx_primer_ap,
                              String tx_segundo_ap,
                              String fhNacimiento,
                              int    idEntidad,
                              String nbCalle,
                              String nbColonia,
                              String nbCiudad,
                              String txCp)
    throws SQLException {
        ResultSet idPersonaResultSet = null;
        int       idPersona = 0;
        
        String sqlQuery = "INSERT INTO persona(nb_persona, tx_primer_ap, tx_segundo_ap, fh_nacimiento) " +
                          "VALUES (\"" + nbPersona + "\", \"" + tx_primer_ap + "\", \"" + tx_segundo_ap + "\", \"" + fhNacimiento + "\");";
        
        try {
            statement.executeUpdate(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        idPersonaResultSet = statement.executeQuery("SELECT MAX(id_persona) " +
                                                    "FROM persona;");
        
        idPersonaResultSet.next();
        
        idPersona = idPersonaResultSet.getInt(1);
        
        sqlQuery = "INSERT INTO usuario(id_usuario, tx_login, tx_password) " +
                   "VALUES (" + idPersona + ", \"" + txLogin + "\", \"" + txPassword + "\");";
        
        try {
            statement.executeUpdate(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
        
        sqlQuery = "INSERT INTO direccion(id_persona, id_entidad, nb_calle, nb_colonia, nb_ciudad, tx_cp) " +
                   "VALUES (" + idPersona + ", " + idEntidad + ", \"" + nbCalle + "\", \"" + nbColonia + "\", \"" + nbCiudad + "\", \"" + txCp + "\");";
        
        try {
            statement.executeUpdate(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
    }
    
    public void alterEntidad(int    idEntidad,
                             String nbEntidad)
    throws SQLException {
        String sqlQuery = "UPDATE entidad " +
                          "SET nb_entidad = \"" + nbEntidad + "\" " + 
                          "WHERE id_entidad = " + idEntidad + ";";
        
        try {
            statement.executeUpdate(sqlQuery);
        } catch(SQLException exception) {
            throw exception;
        }
    }
}
