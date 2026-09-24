package co.edu.uniquindio;
import co.edu.uniquindio.model.Habitacion;
import co.edu.uniquindio.model.Huesped;
import co.edu.uniquindio.model.Hotel;
import co.edu.uniquindio.model.Reserva;
import co.edu.uniquindio.model.ServicioAdicional;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("StayPlus", "900123456", "Armenia", "3111234567", "www.stayplus.com");
        //==========================================
        // HABITACIONES
        // ==========================================

        hotel.registrarHabitacion(
                101,
                1,
                "Individual",
                1,
                80000,
                "Disponible"
        );

        hotel.registrarHabitacion(
                102,
                1,
                "Individual",
                1,
                80000,
                "Disponible"
        );

        hotel.registrarHabitacion(
                201,
                2,
                "Doble",
                2,
                120000,
                "Disponible"
        );

        hotel.registrarHabitacion(
                202,
                2,
                "Doble",
                2,
                120000,
                "Disponible"
        );

        hotel.registrarHabitacion(
                301,
                3,
                "Suite",
                4,
                200000,
                "Disponible"
        );

    }
