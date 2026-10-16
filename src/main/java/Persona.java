public abstract class Persona {
    private int documento;
    private String nombreCompleto;
    private String correo;
    private int telefono;

    public Persona(int documento, String nombreCompleto, String correo, int telefono) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona: " +
                "documento=" + documento +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono;
    }
}