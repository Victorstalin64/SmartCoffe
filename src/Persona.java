public class Persona {
    private String nombre;
    private String correo;
    private int edad;

    public Persona(String nombre, String correo, int edad) {
        this.nombre = nombre;

        if (correo != null && !correo.trim().isEmpty() && correo.contains("@") && correo.endsWith(".com")) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Error: Correo no válido.");
        }

        if (edad >= 18 && edad <= 60) {
            this.edad = edad;
        } else {
            this.edad = 18;
        }
    }

    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Correo: " + correo + " | Edad: " + edad;
    }
}