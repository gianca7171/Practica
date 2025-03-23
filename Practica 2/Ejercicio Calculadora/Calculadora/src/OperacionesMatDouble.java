// Implementación de operaciones matemáticas para números decimales
public class OperacionesMatDouble implements Operable<Double> {

    // Suma de dos números decimales
    @Override
    public Double suma(Double operando1, Double operando2) {
        return operando1 + operando2;
    }

    // Resta de dos números decimales
    @Override
    public Double resta(Double operando1, Double operando2) {
        return operando1 - operando2;
    }

    // Multiplicación de dos números decimales
    @Override
    public Double producto(Double operando1, Double operando2) {
        return operando1 * operando2;
    }

    // División de dos números decimales (manejo de división por cero)
    @Override
    public Double division(Double operando1, Double operando2) {
        if (operando2 == 0) {
            throw new ArithmeticException("Error: División por cero.");
        }
        return operando1 / operando2;
    }
}

