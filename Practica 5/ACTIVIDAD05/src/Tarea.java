// Clase Tarea que contiene el título y la prioridad de la tarea
public class Tarea {
    private String titulo;
    private int prioridad;

    // Constructor que recibe el título y la prioridad
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Método que devuelve una representación en texto de la tarea
    @Override
    public String toString() {
        return "Tarea: " + titulo + ", Prioridad: " + prioridad;
    }

    // Dos tareas son iguales si tienen mismo título y misma prioridad
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj;
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo);
    }
}
