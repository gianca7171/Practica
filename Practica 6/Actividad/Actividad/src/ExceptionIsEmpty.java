// Excepción lanzada al hacer pop o top en una pila vacía
public class ExceptionIsEmpty extends Exception {
    public ExceptionIsEmpty(String mensaje) {
        super(mensaje);
    }
}
