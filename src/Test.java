import java.util.Scanner;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cafeteria cafeteria = new Cafeteria("Smart Coffee");
        int opcion = 0;

        do {
            System.out.println("\n===== SMART COFFEE =========");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar pedido");
            System.out.println("4. Actualizar pedido");
            System.out.println("5. Eliminar pedido");
            System.out.println("6. Mostrar promedio de consumo");
            System.out.println("7. Mostrar mejor cliente");
            System.out.println("8. Buscar cliente por correo");
            System.out.println("9. Mostrar pedidos registrados");
            System.out.println("10. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: "); String nom = scanner.nextLine();
                    System.out.print("Correo: "); String corr = scanner.nextLine();
                    System.out.print("Edad: "); int ed = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Código: "); String cod = scanner.nextLine();
                    System.out.print("Membresía (Gold/Silver/Premium): "); String mem = scanner.nextLine();

                    try {
                        Cliente nuevo = new Cliente(nom, corr, ed, cod, mem);

                        if (cafeteria.getClientes().add(nuevo)) {
                            System.out.println("¡Cliente registrado!");
                        } else {
                            System.out.println("Error: Ese código de cliente ya existe.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    if (cafeteria.getClientes().isEmpty()) {
                        System.out.println("No hay clientes.");
                    } else {
                        for (Cliente c : cafeteria.getClientes()) System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.print("Correo del cliente: "); String cPed = scanner.nextLine();
                    System.out.print("Consumo: "); double con = scanner.nextDouble();
                    cafeteria.registrarPedido(cPed, con);
                    break;

                case 4:
                    System.out.print("Correo del cliente: "); String cAct = scanner.nextLine();
                    System.out.print("Nuevo Consumo: "); double nCon = scanner.nextDouble();
                    cafeteria.actualizarPedido(cAct, nCon);
                    break;

                case 5:
                    System.out.print("Correo del cliente: "); String cEli = scanner.nextLine();
                    cafeteria.eliminarPedido(cEli);
                    break;

                case 6:
                    if (cafeteria.getMapaPedidos().isEmpty()) {
                        System.out.println("No hay datos disponibles.");
                    } else {
                        System.out.println("Promedio general: $" + cafeteria.promedioConsumo());
                    }
                    break;

                case 7:
                    Cliente mejor = cafeteria.mejorCliente();
                    if (mejor == null) {
                        System.out.println("No hay datos disponibles.");
                    } else {
                        System.out.println("El mejor cliente es: " + mejor.getNombre());
                    }
                    break;

                case 8:
                    System.out.print("Correo a buscar: "); String cBus = scanner.nextLine();
                    Cliente encontrado = cafeteria.buscarClientePorCorreo(cBus);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 9:
                    if (cafeteria.getMapaPedidos().isEmpty()) {
                        System.out.println("No hay datos disponibles.");
                    } else {
                        for (Map.Entry<String, Double> reg : cafeteria.getMapaPedidos().entrySet()) {
                            System.out.println("Correo: " + reg.getKey() + " | Consumo: $" + reg.getValue());
                        }
                    }
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 10);

        scanner.close();
    }
}
