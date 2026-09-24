package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva {
    // Atributos de la clase Reserva
    private String codigoReserva;
    private Date fechaRealizacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String estado;
    private String metodoPago;
    private double valorTotal;

    // Relaciones de la clase Reserva
    private Huesped huesped;
    private List<Habitacion> listReservaHabitaciones;
    private List<ServicioAdicional> listReservaServicios;

    /**
     * Metodo constructor de la clase Reserva
     */
    public Reserva(String codigoReserva,
                   Date fechaRealizacion,
                   Date fechaEntrada,
                   Date fechaSalida,
                   String estado,
                   String metodoPago,
                   Huesped huesped) {

        this.codigoReserva = codigoReserva;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        this.valorTotal = 0;
}
