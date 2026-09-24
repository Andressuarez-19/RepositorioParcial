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

        this.listReservaHabitaciones = new ArrayList<>();
        this.listReservaServicios = new ArrayList<>();
    }
    /**
     * Metodo que permite calcular la cantidad de noches de la reserva.
     */
    public long calcularCantidadNoches() {

        long diferencia =
                fechaSalida.getTime() - fechaEntrada.getTime();

        long noches =
                diferencia / (1000 * 60 * 60 * 24);

        return noches;
    }
    /**
     * Metodo que permite calcular el valor total de la reserva.
     */
    public double calcularValorTotal() {

        long noches = calcularCantidadNoches();

        double valorHabitaciones = 0;

        // Calcular valor de todas las habitaciones
        for(int i = 0;
            i < listReservaHabitaciones.size();
            i++) {

            Habitacion habitacion =
                    listReservaHabitaciones.get(i);

            double valorHabitacion =
                    habitacion.getPrecioPorNoche() * noches;

            valorHabitaciones =
                    valorHabitaciones + valorHabitacion;
        }

        double valorServicios = 0;

        // Calcular valor de todos los servicios
        for(int i = 0;
            i < listReservaServicios.size();
            i++) {

            ServicioAdicional servicio =
                    listReservaServicios.get(i);

            valorServicios =
                    valorServicios + servicio.getPrecio();
        }

        valorTotal =
                valorHabitaciones + valorServicios;

        return valorTotal;
    }


    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public List<Habitacion> getListReservaHabitaciones() {
        return listReservaHabitaciones;
    }

    public void setListReservaHabitaciones(
            List<Habitacion> listReservaHabitaciones) {

        this.listReservaHabitaciones =
                listReservaHabitaciones;
    }

    public List<ServicioAdicional> getListReservaServicios() {
        return listReservaServicios;
    }

    public void setListReservaServicios(
            List<ServicioAdicional> listReservaServicios) {

        this.listReservaServicios =
                listReservaServicios;
    }

    @Override
    public String toString() {

        return "Reserva{" +
                "codigoReserva='" + codigoReserva + '\'' +
                ", fechaRealizacion=" + fechaRealizacion +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", estado='" + estado + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }

}
