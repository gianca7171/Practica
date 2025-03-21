public class Golosina {
    private String nombre; // Nombre de la golosina
    private double peso;   // Peso en gramos

    // Constructor para asignar nombre y peso
    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // Métodos para obtener valores
    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    // Métodos para modificar valores
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
