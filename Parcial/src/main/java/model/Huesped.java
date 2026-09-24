package model;

public class Huesped {

    // Atributos de la clase Huesped
    private String nombreCompleto;
    private String documentoIdentidad;
    private String telefono;
    private String correoElectronico;
    private String paisProcedencia;

    /**
     * Constructor de la clase Huesped
     */
    public Huesped(String nombreCompleto,
                   String documentoIdentidad,
                   String telefono,
                   String correoElectronico,
                   String paisProcedencia) {

        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paisProcedencia = paisProcedencia;
    }
    /**
     * Metodo que verifica si el telefono
     * corresponde a un numero perfecto
     */
    public boolean esNumeroTelefonoPerfecto() {

        int numero = Integer.parseInt(telefono);
        int suma = 0;

        for(int i = 1; i < numero; i++) {

            if(numero % i == 0) {
                suma = suma + i;
            }
        }

        return suma == numero;
    }
    // GETTER Y SETTER

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }
    @Override
    public String toString() {
        return "Huesped{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", paisProcedencia='" + paisProcedencia + '\'' +
                '}';
    }
}