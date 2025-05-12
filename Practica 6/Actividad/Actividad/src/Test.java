

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        // ------------------ ACTIVIDAD 1: PILA CON ARREGLO ------------------
        System.out.println("------------- ACTIVIDAD 1: PILA -------------");

        Stack<Integer> pila = new StackArray<>();

        System.out.println("Pila vacía: " + pila.isEmpty());

        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.push(50);

        System.out.println("Tope de la pila: " + pila.top());
        System.out.println("Tamaño: " + pila.size());

        System.out.println("Pop: " + pila.pop());
        System.out.println("Nuevo tope: " + pila.top());
        System.out.println("Tamaño actual: " + pila.size());
        System.out.println("¿Está vacía? " + pila.isEmpty());
        System.out.println("Contenido de la pila: " + pila);


        // ------------------ ACTIVIDAD 2: COLA CON LISTA ENLAZADA ------------------
        System.out.println("\n------------- ACTIVIDAD 2: COLA -------------");

        Queue<String> cola = new QueueLink<>();

        System.out.println("Cola vacía: " + cola.isEmpty());

        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        System.out.println("Frente de la cola: " + cola.front());
        System.out.println("Tamaño: " + cola.size());

        System.out.println("Dequeue: " + cola.dequeue());
        System.out.println("Nuevo frente: " + cola.front());
        System.out.println("Tamaño actual: " + cola.size());
        System.out.println("¿Está vacía? " + cola.isEmpty());

        System.out.println("\n------------- ACTIVIDAD 3: COLA DE PRIORIDAD -------------");

        PriorityQueue<String, Integer> colaPrioridad = new PriorityQueueLinkSort<>();

        colaPrioridad.insert("C", 3);
        colaPrioridad.insert("A", 1);
        colaPrioridad.insert("B", 2);

        System.out.println("Cola de prioridad actual: " + colaPrioridad);
        System.out.println("Elemento con menor prioridad: " + colaPrioridad.min());
        System.out.println("Removiendo: " + colaPrioridad.removeMin());
        System.out.println("Cola de prioridad luego de remover: " + colaPrioridad);
        System.out.println("Tamaño actual: " + colaPrioridad.size());

        System.out.println("\n------------- EJERCICIO 1: PILA CON LISTA ENLAZADA -------------");

        Stack<String> pilaEnlazada = new StackLink<>();

        System.out.println("¿Está vacía? " + pilaEnlazada.isEmpty());

        pilaEnlazada.push("A");
        pilaEnlazada.push("B");
        pilaEnlazada.push("C");

        System.out.println("Contenido actual: " + pilaEnlazada);
        System.out.println("Tope: " + pilaEnlazada.top());
        System.out.println("Tamaño: " + pilaEnlazada.size());

        System.out.println("Pop: " + pilaEnlazada.pop());
        System.out.println("Nuevo tope: " + pilaEnlazada.top());
        System.out.println("Nuevo contenido: " + pilaEnlazada);
        System.out.println("Tamaño actual: " + pilaEnlazada.size());
        System.out.println("¿Está vacía? " + pilaEnlazada.isEmpty());

        System.out.println("\n------------- EJERCICIO 2: COLA CON ARREGLO CIRCULAR -------------");

        Queue<String> colaCircular = new QueueArray<>();

        System.out.println("¿Está vacía? " + colaCircular.isEmpty());

        colaCircular.enqueue("A");
        colaCircular.enqueue("B");
        colaCircular.enqueue("C");

        System.out.println("Contenido actual: " + colaCircular);
        System.out.println("Frente: " + colaCircular.front());
        System.out.println("Final: " + colaCircular.back());
        System.out.println("Tamaño: " + colaCircular.size());

        System.out.println("Dequeue: " + colaCircular.dequeue());
        System.out.println("Nuevo frente: " + colaCircular.front());
        System.out.println("Nuevo contenido: " + colaCircular);
        System.out.println("Tamaño actual: " + colaCircular.size());
        System.out.println("¿Está vacía? " + colaCircular.isEmpty());

        System.out.println("\n------------- EJERCICIO 3: COLA DE PRIORIDAD CON VARIAS COLAS -------------");

        PriorityQueueLinked<String> multiCola = new PriorityQueueLinked<>();

        multiCola.insert("Paciente leve", 4);
        multiCola.insert("Paciente grave", 0);
        multiCola.insert("Paciente moderado", 2);
        multiCola.insert("Paciente muy leve", 4);
        multiCola.insert("Paciente urgente", 1);

        System.out.println("Estado de las colas por prioridad:");
        System.out.println(multiCola);

        System.out.println("Eliminando elementos por prioridad:");
        while (!multiCola.isEmpty()) {
            try {
                System.out.println("Atendido: " + multiCola.remove());
            } catch (ExceptionIsEmpty e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\n------------- EJERCICIO 4: BALANCEO DE SÍMBOLOS -------------");

        String[] expresiones = {
            "{[()]}", "{[(])}", "{{[[(())]]}}", "[(])", "()", "", "[{()}]", "[(])}", "[(]){"
        };
        
        for (String expr : expresiones) {
            try {
                boolean balanceado = SymbolBalancer.esBalanceado(expr);
                System.out.println("Expresión: " + expr + " → " + (balanceado ? "Balanceado" : "No balanceado"));
            } catch (ExceptionIsEmpty e) {
                System.out.println("Error al evaluar: " + expr);
            }
        }        
    }
}
