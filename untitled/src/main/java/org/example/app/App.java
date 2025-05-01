package org.example.app;

import org.example.daoImpl.ClienteDAOImpl;
import org.example.daoImpl.PaqueteTuristicoDAOImpl;
import org.example.daoImpl.ReservaDAOImpl;
import org.example.model.Cliente;
import org.example.model.PaqueteTuristico;
import org.example.model.Reserva;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        PaqueteTuristicoDAOImpl paqueteDAO = new PaqueteTuristicoDAOImpl();
        ReservaDAOImpl reservaDAO = new ReservaDAOImpl();

        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Consultar Clientes");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Crear Paquete Turístico");
            System.out.println("5. Consultar Paquetes Turísticos");
            System.out.println("6. Crear Reserva");
            System.out.println("7. Consultar Reservas de un Cliente");
            System.out.println("8. Ranking de Destinos Turísticos");
            System.out.println("9. Clientes con más de una Reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el email del cliente:");
                    String email = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del cliente:");
                    String telefono = scanner.nextLine();
                    clienteDAO.insertar(new Cliente(0, nombre, email, telefono));
                    System.out.println("Cliente creado exitosamente.");
                    break;

                case 2:
                    System.out.println("=== Lista de Clientes ===");
                    clienteDAO.obtenerTodos().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Ingrese el ID del cliente a eliminar:");
                    int idCliente = scanner.nextInt();
                    clienteDAO.eliminar(idCliente);
                    System.out.println("Cliente eliminado exitosamente.");
                    break;

                case 4:
                    System.out.println("Ingrese el nombre del paquete:");
                    String nombrePaquete = scanner.nextLine();
                    System.out.println("Ingrese el destino del paquete:");
                    String destino = scanner.nextLine();
                    System.out.println("Ingrese el precio del paquete:");
                    double precio = scanner.nextDouble();
                    paqueteDAO.insertar(new PaqueteTuristico(0,nombrePaquete, destino, precio, 0));
                    System.out.println("Paquete turístico creado exitosamente.");
                    break;

                case 5:
                    System.out.println("=== Lista de Paquetes Turísticos ===");
                    paqueteDAO.obtenerTodos().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Ingrese el ID del cliente:");
                    int idClienteReserva = scanner.nextInt();
                    System.out.println("Ingrese el ID del paquete turístico:");
                    int idPaquete = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese la fecha de la reserva (YYYY-MM-DD):");
                    String fechaReserva = scanner.nextLine();
                    System.out.println("Ingrese el estado de la reserva (PENDIENTE, CONFIRMADA, CANCELADA):");
                    String estado = scanner.nextLine();
                    reservaDAO.insertar(new Reserva(0, idClienteReserva, idPaquete, fechaReserva, estado));
                    System.out.println("Reserva creada exitosamente.");
                    break;

                case 7:
                    System.out.println("Ingrese el ID del cliente:");
                    int idClienteConsulta = scanner.nextInt();
                    System.out.println("=== Reservas del Cliente ===");
                    reservaDAO.obtenerReservasPorCliente(idClienteConsulta).forEach(System.out::println);
                    break;

                case 8:
                    System.out.println("=== Ranking de Destinos Turísticos ===");
                    paqueteDAO.rankingDestinos().forEach(System.out::println);
                    break;

                case 9:
                    System.out.println("=== Clientes con más de una Reserva ===");
                    clienteDAO.clientesConMasDeUnaReserva().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}