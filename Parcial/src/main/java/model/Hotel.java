package model;

import java.util.ArrayList;
import java.util.List;

    public class Hotel {

        // Atributos
        private String nombreComercial;
        private String NIT;
        private String direccion;
        private String telefono;
        private String paginaWeb;

        // Relaciones
        private List<Huesped> listHotelHuespedes;
        private List<Habitacion> listHotelHabitaciones;
        private List<Reserva> listHotelReservas;
        private List<ServicioAdicional> listHotelServicios;

        // Constructor
        public Hotel(String nombreComercial,
                     String NIT,
                     String direccion,
                     String telefono,
                     String paginaWeb) {

            this.nombreComercial = nombreComercial;
            this.NIT = NIT;
            this.direccion = direccion;
            this.telefono = telefono;
            this.paginaWeb = paginaWeb;

            this.listHotelHuespedes = new ArrayList<>();
            this.listHotelHabitaciones = new ArrayList<>();
            this.listHotelReservas = new ArrayList<>();
            this.listHotelServicios = new ArrayList<>();
        }

        // REGISTRAR HUESPED

        public boolean registrarHuesped(String nombreCompleto,
                                        String documentoIdentidad,
                                        String telefono,
                                        String correoElectronico,
                                        String paisProcedencia) {

            Huesped huesped =
                    consultarHuespedPorTelefono(telefono);

            if(huesped == null) {

                Huesped nuevoHuesped =
                        new Huesped(
                                nombreCompleto,
                                documentoIdentidad,
                                telefono,
                                correoElectronico,
                                paisProcedencia
                        );

                listHotelHuespedes.add(nuevoHuesped);

                return true;
            }

            return false;
        }

        // BUSCAR HUESPED

        public Huesped consultarHuespedPorTelefono(String telefono) {

            Huesped encontrado = null;

            for(int i = 0; i < listHotelHuespedes.size(); i++) {

                Huesped huesped =
                        listHotelHuespedes.get(i);

                if(huesped.getTelefono().equals(telefono)) {

                    encontrado = huesped;
                    break;
                }
            }

            return encontrado;
        }

        // REGISTRAR HABITACION

        public boolean registrarHabitacion(int numeroHabitacion,
                                           int piso,
                                           String tipo,
                                           int capacidadMaxima,
                                           double precioPorNoche,
                                           String estado) {

            Habitacion habitacion =
                    buscarHabitacion(numeroHabitacion);

            if(habitacion == null) {

                Habitacion nuevaHabitacion =
                        new Habitacion(
                                numeroHabitacion,
                                piso,
                                tipo,
                                capacidadMaxima,
                                precioPorNoche,
                                estado
                        );

                listHotelHabitaciones.add(nuevaHabitacion);

                return true;
            }

            return false;
        }

        // BUSCAR HABITACION

        public Habitacion buscarHabitacion(int numero) {

            Habitacion encontrada = null;

            for(int i = 0; i < listHotelHabitaciones.size(); i++) {

                Habitacion habitacion =
                        listHotelHabitaciones.get(i);

                if(habitacion.getNumeroHabitacion() == numero) {

                    encontrada = habitacion;
                    break;
                }
            }

            return encontrada;
        }

        // REGISTRAR SERVICIO

        public boolean registrarServicio(String codigo,
                                         String nombre,
                                         String descripcion,
                                         double precio,
                                         boolean disponible) {

            ServicioAdicional servicio =
                    buscarServicio(codigo);

            if(servicio == null) {

                ServicioAdicional nuevoServicio =
                        new ServicioAdicional(
                                codigo,
                                nombre,
                                descripcion,
                                precio,
                                disponible
                        );

                listHotelServicios.add(nuevoServicio);

                return true;
            }

            return false;
        }

        // BUSCAR SERVICIO

        public ServicioAdicional buscarServicio(String codigo) {

            ServicioAdicional encontrado = null;

            for(int i = 0; i < listHotelServicios.size(); i++) {

                ServicioAdicional servicio =
                        listHotelServicios.get(i);

                if(servicio.getCodigo().equals(codigo)) {

                    encontrado = servicio;
                    break;
                }
            }

            return encontrado;
        }

        // REGISTRAR RESERVA

        public boolean registrarReserva(Reserva reserva) {

            Reserva encontrada =
                    buscarReserva(reserva.getCodigoReserva());

            if(encontrada == null) {

                listHotelReservas.add(reserva);

                return true;
            }

            return false;
        }

        // BUSCAR RESERVA

        public Reserva buscarReserva(String codigo) {

            Reserva encontrada = null;

            for(int i = 0; i < listHotelReservas.size(); i++) {

                Reserva reserva =
                        listHotelReservas.get(i);

                if(reserva.getCodigoReserva().equals(codigo)) {

                    encontrada = reserva;
                    break;
                }
            }

            return encontrada;
        }

        // CONSULTAR VALOR TOTAL DE UNA RESERVA

        public double consultarValorTotalReserva(String codigo) {

            Reserva reserva =
                    buscarReserva(codigo);

            if(reserva != null) {

                return reserva.calcularValorTotal();
            }

            return 0;
        }

        // CONSULTAR INGRESOS DE UNA FECHA

        public double consultarIngresosPorFecha(String fecha) {

            double total = 0;

            for(int i = 0; i < listHotelReservas.size(); i++) {

                Reserva reserva =
                        listHotelReservas.get(i);

                if(reserva.getFechaRealizacion().equals(fecha)) {

                    total =
                            total + reserva.calcularValorTotal();
                }
            }

            return total;
        }

        // GETTERS Y SETTERS

        public String getNombreComercial() {
            return nombreComercial;
        }

        public void setNombreComercial(String nombreComercial) {
            this.nombreComercial = nombreComercial;
        }

        public String getNIT() {
            return NIT;
        }

        public void setNIT(String NIT) {
            this.NIT = NIT;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getPaginaWeb() {
            return paginaWeb;
        }

        public void setPaginaWeb(String paginaWeb) {
            this.paginaWeb = paginaWeb;
        }

        public List<Huesped> getListHotelHuespedes() {
            return listHotelHuespedes;
        }

        public void setListHotelHuespedes(
                List<Huesped> listHotelHuespedes) {

            this.listHotelHuespedes = listHotelHuespedes;
        }

        public List<Habitacion> getListHotelHabitaciones() {
            return listHotelHabitaciones;
        }

        public void setListHotelHabitaciones(
                List<Habitacion> listHotelHabitaciones) {

            this.listHotelHabitaciones = listHotelHabitaciones;
        }

        public List<Reserva> getListHotelReservas() {
            return listHotelReservas;
        }

        public void setListHotelReservas(
                List<Reserva> listHotelReservas) {

            this.listHotelReservas = listHotelReservas;
        }

        public List<ServicioAdicional> getListHotelServicios() {
            return listHotelServicios;
        }

        public void setListHotelServicios(
                List<ServicioAdicional> listHotelServicios) {

            this.listHotelServicios = listHotelServicios;
        }
    }
}
