package proyecto1.core;

public class Direccion {
    private int    idPersona;
    private int    idEntidad;
    private String nbCalle;
    private String nbColonia;
    private String nbCiudad;
    private String txCP;
    
    public int getIdPersona() {
        return this.idPersona;
    }
    
    private void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public int getIdEntidad() {
        return this.idEntidad;
    }
    
    private void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }
    
    public String getNbCalle() {
        return this.nbCalle;
    }
    
    private void setNbCalle(String nbCalle) {
        this.nbCalle = nbCalle;
    }
    
    public String getNbColonia() {
        return this.nbColonia;
    }
    
    private void setNbColonia(String nbColonia) {
        this.nbColonia = nbColonia;
    }
    
    public String getNbCiudad() {
        return this.nbCiudad;
    }
    
    private void setNbCiudad(String nbCiudad) {
        this.nbCiudad = nbCiudad;
    }
    
    public String getTxCP() {
        return this.txCP;
    }
    
    private void setTxCP(String txCP) {
        this.txCP = txCP;
    }
    
    public Direccion(int    idPersona,
                     int    idEntidad,
                     String nbCalle,
                     String nbColonia,
                     String nbCiudad,
                     String txCP) {
        setIdPersona(idPersona);
        setIdEntidad(idEntidad);
        setNbCalle(nbCalle);
        setNbColonia(nbColonia);
        setNbCiudad(nbCiudad);
        setTxCP(txCP);
    }
}
