import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cafeteria implements CrudPedido {
    private String nombreCafeteria;
    private HashSet<Cliente> clientes = new HashSet<>();
    private Map<String, Double> mapaPedidos = new HashMap<>();

    public Cafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }

    public HashSet<Cliente> getClientes() { return clientes; }
    public Map<String, Double> getMapaPedidos() { return mapaPedidos; }

    public Cliente buscarClientePorCorreo(String correo) {
        for (Cliente c : clientes) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void registrarPedido(String correo, double consumo) {
        if (buscarClientePorCorreo(correo) == null) {
            System.out.println("Error: El cliente no existe.");
            return;
        }
        if (consumo <= 0) {
            System.out.println("Error: El consumo debe ser mayor a 0.");
            return;
        }
        mapaPedidos.put(correo, consumo);
        System.out.println("Pedido registrado.");
    }

    @Override
    public void actualizarPedido(String correo, double nuevoConsumo) {
        if (!mapaPedidos.containsKey(correo)) {
            System.out.println("Error: No existe un pedido para este cliente.");
            return;
        }
        if (nuevoConsumo <= 0) {
            System.out.println("Error: El consumo debe ser mayor a 0.");
            return;
        }
        mapaPedidos.put(correo, nuevoConsumo);
        System.out.println("Pedido actualizado.");
    }

    @Override
    public void eliminarPedido(String correo) {
        if (!mapaPedidos.containsKey(correo)) {
            System.out.println("Error: El pedido no existe.");
            return;
        }
        mapaPedidos.remove(correo);
        System.out.println("Pedido eliminado.");
    }

    @Override
    public double promedioConsumo() {
        if (mapaPedidos.isEmpty()) return 0.0;

        double suma = 0;
        for (double c : mapaPedidos.values()) {
            suma += c;
        }
        return suma / mapaPedidos.size();
    }

    @Override
    public Cliente mejorCliente() {
        if (mapaPedidos.isEmpty()) return null;

        String mejorCorreo = null;
        double maxConsumo = -1;

        for (Map.Entry<String, Double> registro : mapaPedidos.entrySet()) {
            if (registro.getValue() > maxConsumo) {
                maxConsumo = registro.getValue();
                mejorCorreo = registro.getKey();
            }
        }
        return buscarClientePorCorreo(mejorCorreo);
    }
}