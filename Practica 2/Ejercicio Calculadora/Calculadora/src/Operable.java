// Interfaz genérica para operaciones matemáticas
public interface Operable<N extends Number> {

    // Método para sumar dos valores del mismo tipo
    N suma(N operando1, N operando2);

    // Método para restar dos valores del mismo tipo
    N resta(N operando1, N operando2);

    // Método para multiplicar dos valores del mismo tipo
    N producto(N operando1, N operando2);

    // Método para dividir dos valores del mismo tipo
    N division(N operando1, N operando2);
}


