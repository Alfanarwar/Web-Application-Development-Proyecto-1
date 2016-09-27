package proyecto1.core;

public class Usuario {
    private int    idUsuario;
    private String txLogin;
    private String txPassword;
    
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    private void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getTxLogin() {
        return this.txLogin;
    }
    
    private void setTxLogin(String txLogin) {
        this.txLogin = txLogin;
    }
    
    public String getTxPassword() {
        return this.txPassword;
    }
    
    private void setTxPassword(String txPassword) {
        this.txPassword = txPassword;
    }
    
    public Usuario(int    idUsuario,
                   String txLogin,
                   String txPassword) {
        setIdUsuario(idUsuario);
        setTxLogin(txLogin);
        setTxPassword(txPassword);
    }
}
