// Implementación de operaciones matemáticas genéricas para números enteros
public class OperacionesMatBInteger<N extends Integer> implements Operable<N> {

    // Suma de dos enteros
    @Override
    public N suma(N operando1, N operando2) {
        return (N) Integer.valueOf(operando1 + operando2);
    }

    // Resta de dos enteros
    @Override
    public N resta(N operando1, N operando2) {
        return (N) Integer.valueOf(operando1 - operando2);
    }

    // Multiplicación de dos enteros
    @Override
    public N producto(N operando1, N operando2) {
        return (N) Integer.valueOf(operando1 * operando2);
    }

    // División de dos enteros (manejo de división entre cero)
    @Override
    public N division(N operando1, N operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("Error: División por cero.");
        }
        return (N) Integer.valueOf(operando1 / operando2);
    }
}
