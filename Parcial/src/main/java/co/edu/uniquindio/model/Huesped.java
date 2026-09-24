package co.edu.uniquindio.model;

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

}
