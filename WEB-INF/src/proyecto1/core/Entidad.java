package proyecto1.core;

public class Entidad {
    private int idEntidad;
    private String nbEntidad;
    
    public int getIdEntidad() {
        return this.idEntidad;
    }
    
    private void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }
    
    public String getNbEntidad() {
        return this.nbEntidad;
    }
    
    private void setNbEntidad(String nbEntidad) {
        this.nbEntidad = nbEntidad;
    }
    
    public Entidad(int    idEntidad,
                   String nbEntidad) {
        setIdEntidad(idEntidad);
        setNbEntidad(nbEntidad);
    }
}
