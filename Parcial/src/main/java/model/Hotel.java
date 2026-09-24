package model;

import java.util.ArrayList;
import java.util.List;

    public class Hotel {

        // Atributos de la clase Hotel
        private String nombreComercial;
        private String NIT;
        private String direccion;
        private String telefono;
        private String paginaWeb;

        // Relaciones de la clase Hotel
        private List<Huesped> listHotelHuespedes;
        private List<Habitacion> listHotelHabitaciones;
        private List<Reserva> listHotelReservas;
        private List<ServicioAdicional> listHotelServicios;

        /**
         * Metodo constructor de la clase Hotel
         */
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

        /**
         * Metodo que permite registrar un huesped
         */
        public boolean registrarHuesped(String nombreCompleto, String documentoIdentidad, String telefono, String correoElectronico, String paisProcedencia) {

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

        /**
         * Metodo que permite buscar un huesped
         * por medio de su telefono
         */
        public Huesped consultarHuespedPorTelefono(String telefono) {

            Huesped encontrado = null;

            for(int i = 0;
                i < listHotelHuespedes.size();
                i++) {

                Huesped huesped =
                        listHotelHuespedes.get(i);

                if(huesped.getTelefono().equals(telefono)) {

                    encontrado = huesped;
                    break;
                }
            }

            return encontrado;
        }

        /**
         * Metodo que permite registrar una habitacion
         */
        public boolean registrarHabitacion(int numeroHabitacion, int piso, String tipo, int capacidadMaxima, double precioPorNoche, String estado) {

            Habitacion habitacion =
                    buscarHabitacion(numeroHabitacion);

            if(habitacion == null) {

                Habitacion nuevaHabitacion =
                        new Habitacion(numeroHabitacion, piso, tipo, capacidadMaxima, precioPorNoche, estado);

                listHotelHabitaciones.add(nuevaHabitacion);

                return true;
            }

            return false;
        }

        /**
         * Metodo que permite buscar una habitacion
         */
        public Habitacion buscarHabitacion(int numero) {

            Habitacion encontrada = null;

            for(int i = 0;
                i < listHotelHabitaciones.size();
                i++) {

                Habitacion habitacion =
                        listHotelHabitaciones.get(i);

                if(habitacion.getNumeroHabitacion() == numero) {

                    encontrada = habitacion;
                    break;
                }
            }

            return encontrada;
        }

        /**
         * Metodo que permite verificar si una habitacion
         * esta disponible para unas fechas determinadas.
         */
        public boolean verificarDisponibilidadHabitacion(
                Habitacion habitacion,
                Date fechaEntrada,
                Date fechaSalida) {

            boolean disponible = true;

            for(int i = 0;
                i < listHotelReservas.size();
                i++) {

                Reserva reserva =
                        listHotelReservas.get(i);

                for(int j = 0;
                    j < reserva
                            .getListReservaHabitaciones()
                            .size();
                    j++) {

                    Habitacion habitacionReservada =
                            reserva
                                    .getListReservaHabitaciones()
                                    .get(j);

                    if(habitacionReservada.getNumeroHabitacion()
                            == habitacion.getNumeroHabitacion()) {

                        Date entradaReserva =
                                reserva.getFechaEntrada();

                        Date salidaReserva =
                                reserva.getFechaSalida();

                        boolean seCruzanFechas =
                                fechaEntrada.before(salidaReserva)
                                        &&
                                        fechaSalida.after(entradaReserva);

                        if(seCruzanFechas) {

                            disponible = false;
                        }
                    }
                }
            }

            return disponible;
        }

        /**
         * Metodo que permite obtener el estado real
         * de una habitacion dependiendo de sus reservas.
         *
         * Si la habitacion no tiene reservas:
         * Disponible.
         *
         * Si tiene una o varias reservas:
         * muestra las fechas de cada reserva.
         */
        public String obtenerEstadoHabitacion(
                Habitacion habitacion) {

            SimpleDateFormat formato =
                    new SimpleDateFormat("dd/MM/yyyy");

            String estado = "Disponible";

            for(int i = 0;
                i < listHotelReservas.size();
                i++) {

                Reserva reserva =
                        listHotelReservas.get(i);

                for(int j = 0;
                    j < reserva
                            .getListReservaHabitaciones()
                            .size();
                    j++) {

                    Habitacion habitacionReservada =
                            reserva
                                    .getListReservaHabitaciones()
                                    .get(j);

                    if(habitacionReservada
                            .getNumeroHabitacion()
                            ==
                            habitacion
                                    .getNumeroHabitacion()) {

                        String fechaEntrada =
                                formato.format(
                                        reserva.getFechaEntrada()
                                );

                        String fechaSalida =
                                formato.format(
                                        reserva.getFechaSalida()
                                );

                        if(estado.equals("Disponible")) {

                            estado =
                                    "Reservada para: " +
                                            fechaEntrada +
                                            " al " +
                                            fechaSalida;

                        } else {

                            estado =
                                    estado +
                                            "\nReservada para: " +
                                            fechaEntrada +
                                            " al " +
                                            fechaSalida;
                        }
                    }
                }
            }

            return estado;
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

            this.listHotelHuespedes =
                    listHotelHuespedes;
        }

        public List<Habitacion> getListHotelHabitaciones() {
            return listHotelHabitaciones;
        }

        public void setListHotelHabitaciones(
                List<Habitacion> listHotelHabitaciones) {

            this.listHotelHabitaciones =
                    listHotelHabitaciones;
        }

        public List<Reserva> getListHotelReservas() {
            return listHotelReservas;
        }

        public void setListHotelReservas(
                List<Reserva> listHotelReservas) {

            this.listHotelReservas =
                    listHotelReservas;
        }

        public List<ServicioAdicional> getListHotelServicios() {
            return listHotelServicios;
        }

        public void setListHotelServicios(
                List<ServicioAdicional> listHotelServicios) {

            this.listHotelServicios =
                    listHotelServicios;
        }
    }