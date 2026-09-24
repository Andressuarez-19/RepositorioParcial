package model;

import java.util.ArrayList;
import java.util.List;

    public class Hotel {

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