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
        // ==========================================
        // SERVICIOS ADICIONALES
        // ==========================================

        hotel.registrarServicio(
                "S1",
                "Restaurante",
                "Servicio de restaurante",
                30000,
                true
        );

        hotel.registrarServicio(
                "S2",
                "Lavanderia",
                "Servicio de lavanderia",
                15000,
                true
        );

        hotel.registrarServicio(
                "S3",
                "Transporte",
                "Servicio de transporte",
                20000,
                true
        );

        hotel.registrarServicio(
                "S4",
                "Servicio a la habitacion",
                "Servicio a la habitacion",
                25000,
                true
        );
        int opcion = 0;
        while(opcion != 7) {

            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            null,
                            """
                            MENÚ
                            
                            1. Registrar huesped
                            2. Buscar huesped
                            3. Registrar reserva
                            4. Consultar valor total de reserva
                            5. Mostrar habitaciones
                            6. Consultar ingresos por fecha
                            7. Salir
                            
                            Seleccione una opcion:
                            """
                    )
            );
            // ==========================================
            // 1. REGISTRAR HUESPED
            // ==========================================

            if(opcion == 1) {

                String nombre =
                        JOptionPane.showInputDialog(
                                "Ingrese el nombre completo:"
                        );

                String documento =
                        JOptionPane.showInputDialog(
                                "Ingrese el documento:"
                        );

                String telefono =
                        JOptionPane.showInputDialog(
                                "Ingrese el telefono:"
                        );

                String correo =
                        JOptionPane.showInputDialog(
                                "Ingrese el correo:"
                        );

                String pais =
                        JOptionPane.showInputDialog(
                                "Ingrese el pais de procedencia:"
                        );

                boolean registrado =
                        hotel.registrarHuesped(
                                nombre,
                                documento,
                                telefono,
                                correo,
                                pais
                        );

                if(registrado) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Huesped registrado correctamente."
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "El huesped ya existe."
                    );
                }         // ==========================================
                // 2. BUSCAR HUESPED
                // ==========================================

            } else if(opcion == 2) {

                String telefono =
                        JOptionPane.showInputDialog(
                                "Ingrese el telefono:"
                        );

                Huesped huesped =
                        hotel.consultarHuespedPorTelefono(
                                telefono
                        );

                if(huesped != null) {

                    JOptionPane.showMessageDialog(
                            null,
                            huesped.toString()
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "El huesped no existe."
                    );
                }

    }
