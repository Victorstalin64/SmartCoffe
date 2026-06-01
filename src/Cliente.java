import java.util.Objects;

public class Cliente extends Persona {
    private String codigoCliente;
    private String tipoMembresia;

    public Cliente(String nombre, String correo, int edad, String codigoCliente, String tipoMembresia) {
        super(nombre, correo, edad);
        this.codigoCliente = codigoCliente;

        if (tipoMembresia.equalsIgnoreCase("Gold") ||
                tipoMembresia.equalsIgnoreCase("Silver") ||
                tipoMembresia.equalsIgnoreCase("Premium")) {
            this.tipoMembresia = tipoMembresia;
        } else {
            this.tipoMembresia = "Silver";
        }
    }

    public String getCodigoCliente() { return codigoCliente; }
    public String getTipoMembresia() { return tipoMembresia; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return Objects.equals(codigoCliente, cliente.codigoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCliente);
    }

    @Override
    public String toString() {
        return super.toString() + " | Código: " + codigoCliente + " | Membresía: " + tipoMembresia;
    }
}