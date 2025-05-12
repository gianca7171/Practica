// Clase que verifica si una expresión tiene símbolos balanceados usando pila
public class SymbolBalancer {

    // Método que verifica si una expresión está balanceada
    public static boolean esBalanceado(String expr) throws ExceptionIsEmpty {
        Stack<Character> pila = new StackLink<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // Si es símbolo de apertura, lo apilamos
            if (ch == '(' || ch == '[' || ch == '{') {
                pila.push(ch);
            }

            // Si es símbolo de cierre, comparamos con el tope
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (pila.isEmpty()) return false;

                char tope = pila.pop();
                if (!coincide(tope, ch)) return false;
            }
        }

        // Si al final la pila está vacía, está balanceado
        return pila.isEmpty();
    }

    // Verifica si el símbolo de apertura y cierre coinciden
    private static boolean coincide(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
}
