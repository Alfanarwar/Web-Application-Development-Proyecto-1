package proyecto1.core;

public class Persona {
    private int    idPersona;
    private String nbPersona;
    private String txPrimerAp;
    private String txSegundoAp;
    private String fhNacimiento;
    
    public int getIdPersona() {
        return this.idPersona;
    }
    
    private void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public String getNbPersona() {
        return this.nbPersona;
    }
    
    private void setNbPersona(String nbPersona) {
        this.nbPersona = nbPersona;
    }
    
    public String getTxPrimerAp() {
        return this.txPrimerAp;
    }
    
    private void setTxPrimerAp(String txPrimerAp) {
        this.txPrimerAp = txPrimerAp;
    }
    
    public String getTxSegundoAp() {
        return this.txSegundoAp;
    }
    
    private void setTxSegundoAp(String txSegundoAp) {
        this.txSegundoAp = txSegundoAp;
    }
    
    public String getFhNacimiento() {
        return this.fhNacimiento;
    }
    
    private void setFhNacimiento(String fhNacimiento) {
        this.fhNacimiento = fhNacimiento;
    }
    
    public Persona(int    idPersona,
                   String nbPersona,
                   String txPrimerAp,
                   String txSegundoAp,
                   String fhNacimiento) {
        setIdPersona(idPersona);
        setNbPersona(nbPersona);
        setTxPrimerAp(txPrimerAp);
        setTxSegundoAp(txSegundoAp);
        setFhNacimiento(fhNacimiento);
    }
}
