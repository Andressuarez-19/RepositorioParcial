package model;

public class Habitacion {
    // Atributos
    private int numeroHabitacion;
    private int piso;
    private String tipo;
    private int capacidadMaxima;
    private double precioPorNoche;
    private String estado;


    // GETTERS Y SETTERS
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroHabitacion=" + numeroHabitacion +
                ", piso=" + piso +
                ", tipo='" + tipo + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precioPorNoche=" + precioPorNoche +
                ", estado='" + estado + '\'' +
                '}';
    }
}