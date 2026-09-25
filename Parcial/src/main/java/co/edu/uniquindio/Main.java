package co.edu.uniquindio;

import model.Habitacion;
import model.Huesped;
import model.Hotel;
import model.Reserva;
import model.ServicioAdicional;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    static void main(String [] args) {

                Hotel hotel = new Hotel(
                        "StayPlus",
                        "900123456",
                        "Armenia",
                        "3111234567",
                        "www.stayplus.com"
                );

                // ==========================================
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
                // TODOS COMIENZAN CON 5 DISPONIBLES
                // ==========================================

                hotel.registrarServicio(
                        "S1",
                        "Restaurante",
                        "Servicio de restaurante",
                        30000,
                        5
                );

                hotel.registrarServicio(
                        "S2",
                        "Lavanderia",
                        "Servicio de lavanderia",
                        15000,
                        5
                );

                hotel.registrarServicio(
                        "S3",
                        "Transporte",
                        "Servicio de transporte",
                        20000,
                        5
                );

                hotel.registrarServicio(
                        "S4",
                        "Servicio a la habitacion",
                        "Servicio a la habitacion",
                        25000,
                        5
                );

                int opcion = 0;

                while(opcion != 9) {

                    opcion =
                            Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            null,
                                            """
                                            MENÚ
                                            
                                            1. Registrar huesped
                                            2. Buscar huesped
                                            3. Registrar reserva
                                            4. Agregar servicios a una reserva
                                            5. Mostrar servicios adicionales
                                            6. Consultar valor total de reserva
                                            7. Mostrar habitaciones
                                            8. Consultar ingresos por fecha
                                            9. Salir
                                            
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
                        }

                        // ==========================================
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

                            String numeroPerfecto;

                            if(huesped.esNumeroTelefonoPerfecto()) {

                                numeroPerfecto =
                                        "El numero de telefono SI es un numero perfecto.";

                            } else {

                                numeroPerfecto =
                                        "El numero de telefono NO es un numero perfecto.";
                            }

                            JOptionPane.showMessageDialog(
                                    null,
                                    huesped.toString()
                                            + "\n\n"
                                            + numeroPerfecto
                            );

                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "El huesped no existe."
                            );
                        }

                        // ==========================================
                        // 3. REGISTRAR RESERVA
                        // ==========================================

                    } else if(opcion == 3) {

                        try {

                            SimpleDateFormat formato =
                                    new SimpleDateFormat(
                                            "dd/MM/yyyy"
                                    );

                            String codigo =
                                    JOptionPane.showInputDialog(
                                            "Ingrese el codigo de la reserva:"
                                    );

                            String telefono =
                                    JOptionPane.showInputDialog(
                                            "Ingrese el telefono del huesped:"
                                    );

                            Huesped huesped =
                                    hotel.consultarHuespedPorTelefono(
                                            telefono
                                    );

                            if(huesped != null) {

                                String fechaRealizacionTexto =
                                        JOptionPane.showInputDialog(
                                                "Ingrese la fecha de realizacion (dd/MM/yyyy):"
                                        );

                                Date fechaRealizacion =
                                        formato.parse(
                                                fechaRealizacionTexto
                                        );

                                String fechaEntradaTexto =
                                        JOptionPane.showInputDialog(
                                                "Ingrese la fecha de entrada (dd/MM/yyyy):"
                                        );

                                Date fechaEntrada =
                                        formato.parse(
                                                fechaEntradaTexto
                                        );

                                String fechaSalidaTexto =
                                        JOptionPane.showInputDialog(
                                                "Ingrese la fecha de salida (dd/MM/yyyy):"
                                        );

                                Date fechaSalida =
                                        formato.parse(
                                                fechaSalidaTexto
                                        );

                                String metodoPago =
                                        JOptionPane.showInputDialog(
                                                """
                                                METODO DE PAGO
                                                
                                                Tarjeta de credito
                                                Transferencia bancaria
                                                Efectivo
                                                
                                                Escriba el metodo:
                                                """
                                        );

                                Reserva reserva =
                                        new Reserva(
                                                codigo,
                                                fechaRealizacion,
                                                fechaEntrada,
                                                fechaSalida,
                                                "Confirmada",
                                                metodoPago,
                                                huesped
                                        );

                                // ==================================
                                // AGREGAR HABITACIONES
                                // ==================================

                                int agregarHabitacion =
                                        JOptionPane.showConfirmDialog(
                                                null,
                                                "¿Desea agregar una habitacion?",
                                                "Habitaciones",
                                                JOptionPane.YES_NO_OPTION
                                        );

                                while(agregarHabitacion ==
                                        JOptionPane.YES_OPTION) {

                                    int numeroHabitacion =
                                            Integer.parseInt(
                                                    JOptionPane.showInputDialog(
                                                            """
                                                            HABITACIONES
                                                            
                                                            101 - Individual - $80.000
                                                            102 - Individual - $80.000
                                                            201 - Doble - $120.000
                                                            202 - Doble - $120.000
                                                            301 - Suite - $200.000
                                                            
                                                            Ingrese el numero de habitacion:
                                                            """
                                                    )
                                            );

                                    Habitacion habitacion =
                                            hotel.buscarHabitacion(
                                                    numeroHabitacion
                                            );

                                    if(habitacion != null) {

                                        boolean disponible =
                                                hotel.verificarDisponibilidadHabitacion(
                                                        habitacion,
                                                        fechaEntrada,
                                                        fechaSalida
                                                );

                                        if(disponible) {

                                            reserva
                                                    .getListReservaHabitaciones()
                                                    .add(habitacion);

                                            JOptionPane.showMessageDialog(
                                                    null,
                                                    "Habitacion agregada correctamente."
                                            );

                                        } else {

                                            JOptionPane.showMessageDialog(
                                                    null,
                                                    "La habitacion no esta disponible " +
                                                            "para las fechas seleccionadas."
                                            );
                                        }

                                    } else {

                                        JOptionPane.showMessageDialog(
                                                null,
                                                "La habitacion no existe."
                                        );
                                    }

                                    agregarHabitacion =
                                            JOptionPane.showConfirmDialog(
                                                    null,
                                                    "¿Desea agregar otra habitacion?",
                                                    "Habitaciones",
                                                    JOptionPane.YES_NO_OPTION
                                            );
                                }

                                // ==================================
                                // REGISTRAR RESERVA
                                // ==================================

                                if(reserva
                                        .getListReservaHabitaciones()
                                        .size() > 0) {

                                    hotel.registrarReserva(reserva);

                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Reserva registrada correctamente."
                                    );

                                } else {

                                    JOptionPane.showMessageDialog(
                                            null,
                                            "La reserva debe tener " +
                                                    "por lo menos una habitacion."
                                    );
                                }

                            } else {

                                JOptionPane.showMessageDialog(
                                        null,
                                        "El huesped no existe."
                                );
                            }

                        } catch(ParseException e) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Formato de fecha incorrecto.\n" +
                                            "Use el formato: dd/MM/yyyy"
                            );
                        }

                        // ==========================================
                        // 4. AGREGAR SERVICIOS A UNA RESERVA
                        // ==========================================

                    } else if(opcion == 4) {

                        String codigoReserva =
                                JOptionPane.showInputDialog(
                                        "Ingrese el codigo de la reserva:"
                                );

                        Reserva reserva =
                                hotel.buscarReserva(
                                        codigoReserva
                                );

                        if(reserva != null) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Noches de la reserva: "
                                            + reserva.calcularCantidadNoches()
                                            + "\n\n"
                                            + hotel.mostrarServiciosAdicionales()
                            );

                            int agregarServicio =
                                    JOptionPane.showConfirmDialog(
                                            null,
                                            "¿Desea agregar un servicio?",
                                            "Servicios adicionales",
                                            JOptionPane.YES_NO_OPTION
                                    );

                            while(agregarServicio ==
                                    JOptionPane.YES_OPTION) {

                                String codigoServicio =
                                        JOptionPane.showInputDialog(
                                                """
                                                SERVICIOS
                                                
                                                Escriba el codigo del servicio:
                                                
                                                S1 - Restaurante
                                                S2 - Lavanderia
                                                S3 - Transporte
                                                S4 - Servicio a la habitacion
                                                """
                                        );

                                ServicioAdicional servicio =
                                        hotel.buscarServicio(
                                                codigoServicio
                                        );

                                if(servicio != null) {

                                    if(servicio.estaDisponible()) {

                                        boolean agregado =
                                                hotel.agregarServicioAReserva(
                                                        codigoReserva,
                                                        codigoServicio
                                                );

                                        if(agregado) {

                                            JOptionPane.showMessageDialog(
                                                    null,
                                                    "Servicio agregado correctamente.\n\n"
                                                            +
                                                            "Servicio: "
                                                            + servicio.getNombre()
                                                            +
                                                            "\nPrecio por noche: $"
                                                            + servicio.getPrecio()
                                                            +
                                                            "\nDisponibilidad restante: "
                                                            + servicio.getDisponibilidad()
                                            );

                                        }

                                    } else {

                                        JOptionPane.showMessageDialog(
                                                null,
                                                "El servicio no esta disponible."
                                        );
                                    }

                                } else {

                                    JOptionPane.showMessageDialog(
                                            null,
                                            "El servicio no existe."
                                    );
                                }

                                agregarServicio =
                                        JOptionPane.showConfirmDialog(
                                                null,
                                                "¿Desea agregar otro servicio?",
                                                "Servicios",
                                                JOptionPane.YES_NO_OPTION
                                        );
                            }

                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "La reserva no existe."
                            );
                        }

                        // ==========================================
                        // 5. MOSTRAR SERVICIOS
                        // ==========================================

                    } else if(opcion == 5) {

                        String servicios =
                                hotel.mostrarServiciosAdicionales();

                        JOptionPane.showMessageDialog(
                                null,
                                "SERVICIOS ADICIONALES\n\n"
                                        + servicios
                        );

                        // ==========================================
                        // 6. CONSULTAR VALOR TOTAL
                        // ==========================================

                    } else if(opcion == 6) {

                        String codigo =
                                JOptionPane.showInputDialog(
                                        "Ingrese el codigo de la reserva:"
                                );

                        Reserva reserva =
                                hotel.buscarReserva(codigo);

                        if(reserva != null) {

                            double total =
                                    hotel.consultarValorTotalReserva(
                                            codigo
                                    );

                            long noches =
                                    reserva.calcularCantidadNoches();

                            // ==================================
                            // HABITACIONES
                            // ==================================

                            String habitaciones = "";

                            for(int i = 0;
                                i < reserva
                                        .getListReservaHabitaciones()
                                        .size();
                                i++) {

                                Habitacion habitacion =
                                        reserva
                                                .getListReservaHabitaciones()
                                                .get(i);

                                habitaciones =
                                        habitaciones
                                                + "Habitacion: "
                                                + habitacion
                                                .getNumeroHabitacion()
                                                + "\nTipo: "
                                                + habitacion.getTipo()
                                                + "\nPrecio por noche: $"
                                                + habitacion
                                                .getPrecioPorNoche()
                                                + "\n\n";
                            }

                            // ==================================
                            // SERVICIOS
                            // ==================================

                            String servicios = "";

                            if(reserva
                                    .getListReservaServicios()
                                    .size() == 0) {

                                servicios =
                                        "No se tomaron servicios adicionales.\n";

                            } else {

                                for(int i = 0;
                                    i < reserva
                                            .getListReservaServicios()
                                            .size();
                                    i++) {

                                    ServicioAdicional servicio =
                                            reserva
                                                    .getListReservaServicios()
                                                    .get(i);

                                    servicios =
                                            servicios
                                                    + "Codigo: "
                                                    + servicio.getCodigo()
                                                    + "\nNombre: "
                                                    + servicio.getNombre()
                                                    + "\nPrecio por noche: $"
                                                    + servicio.getPrecio()
                                                    + "\nValor por "
                                                    + noches
                                                    + " noches: $"
                                                    + (servicio.getPrecio()
                                                    * noches)
                                                    + "\n\n";
                                }
                            }

                            // ==================================
                            // INFORMACION
                            // ==================================

                            JOptionPane.showMessageDialog(
                                    null,
                                    "RESERVA\n\n"
                                            +
                                            "Codigo: "
                                            + reserva.getCodigoReserva()
                                            +
                                            "\nHuesped: "
                                            + reserva.getHuesped()
                                            .getNombreCompleto()
                                            +
                                            "\n\nHABITACIONES\n"
                                            + habitaciones
                                            +
                                            "SERVICIOS ADICIONALES\n"
                                            + servicios
                                            +
                                            "Fecha de entrada: "
                                            + reserva.getFechaEntrada()
                                            +
                                            "\nFecha de salida: "
                                            + reserva.getFechaSalida()
                                            +
                                            "\nNoches: "
                                            + noches
                                            +
                                            "\nMetodo de pago: "
                                            + reserva.getMetodoPago()
                                            +
                                            "\n\nVALOR TOTAL: $"
                                            + total
                            );

                        } else {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "La reserva no existe."
                            );
                        }

                        // ==========================================
                        // 7. MOSTRAR HABITACIONES
                        // ==========================================

                    } else if(opcion == 7) {

                        String mensaje = "";

                        SimpleDateFormat formato =
                                new SimpleDateFormat(
                                        "dd/MM/yyyy"
                                );

                        for(int i = 0;
                            i < hotel
                                    .getListHotelHabitaciones()
                                    .size();
                            i++) {

                            Habitacion habitacion =
                                    hotel
                                            .getListHotelHabitaciones()
                                            .get(i);

                            mensaje =
                                    mensaje
                                            + "Habitacion: "
                                            + habitacion
                                            .getNumeroHabitacion()
                                            + "\nTipo: "
                                            + habitacion.getTipo()
                                            + "\nPrecio por noche: $"
                                            + habitacion
                                            .getPrecioPorNoche();

                            boolean tieneReserva = false;

                            for(int j = 0;
                                j < hotel
                                        .getListHotelReservas()
                                        .size();
                                j++) {

                                Reserva reserva =
                                        hotel
                                                .getListHotelReservas()
                                                .get(j);

                                for(int k = 0;
                                    k < reserva
                                            .getListReservaHabitaciones()
                                            .size();
                                    k++) {

                                    Habitacion habitacionReserva =
                                            reserva
                                                    .getListReservaHabitaciones()
                                                    .get(k);

                                    if(habitacionReserva
                                            .getNumeroHabitacion()
                                            ==
                                            habitacion
                                                    .getNumeroHabitacion()) {

                                        tieneReserva = true;

                                        mensaje =
                                                mensaje
                                                        + "\nReservada desde: "
                                                        + formato.format(
                                                        reserva
                                                                .getFechaEntrada()
                                                )
                                                        + "\nHasta: "
                                                        + formato.format(
                                                        reserva
                                                                .getFechaSalida()
                                                );
                                    }
                                }
                            }

                            if(!tieneReserva) {

                                mensaje =
                                        mensaje
                                                + "\nEstado: Disponible";
                            }

                            mensaje =
                                    mensaje + "\n\n";
                        }

                        JOptionPane.showMessageDialog(
                                null,
                                mensaje
                        );

                        // ==========================================
                        // 8. INGRESOS POR FECHA
                        // ==========================================

                    } else if(opcion == 8) {

                        try {

                            SimpleDateFormat formato =
                                    new SimpleDateFormat(
                                            "dd/MM/yyyy"
                                    );

                            String fechaTexto =
                                    JOptionPane.showInputDialog(
                                            "Ingrese la fecha de realizacion (dd/MM/yyyy):"
                                    );

                            Date fecha =
                                    formato.parse(
                                            fechaTexto
                                    );

                            double ingresos =
                                    hotel.consultarIngresosPorFecha(
                                            fecha
                                    );

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Los ingresos de esa fecha son: $"
                                            + ingresos
                            );

                        } catch(ParseException e) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Formato de fecha incorrecto.\n"
                                            +
                                            "Use el formato: dd/MM/yyyy"
                            );
                        }

                        // ==========================================
                        // 9. SALIR
                        // ==========================================

                    } else if(opcion == 9) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Fin del servicio"
                        );
                    }
                }
            }
        }