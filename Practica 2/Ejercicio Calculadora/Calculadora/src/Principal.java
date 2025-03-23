import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\nMenú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion == 8) {
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.print("¿Desea operar con Integer (1) o Double (2)?: ");
            int tipo = sc.nextInt();

            // Operaciones con Integer
            if (tipo == 1) {
                OperacionesMatBInteger<Integer> operaciones = new OperacionesMatBInteger<>();
                System.out.print("Ingrese el primer número entero: ");
                int num1 = sc.nextInt();
                int num2 = 0;

                if (opcion != 6 && opcion != 7) {
                    System.out.print("Ingrese el segundo número entero: ");
                    num2 = sc.nextInt();
                }

                switch (opcion) {
                    case 1 -> System.out.println("Resultado: " + operaciones.suma(num1, num2));
                    case 2 -> System.out.println("Resultado: " + operaciones.resta(num1, num2));
                    case 3 -> System.out.println("Resultado: " + operaciones.producto(num1, num2));
                    case 4 -> {
                        if (num2 == 0) System.out.println("Error: División por cero.");
                        else System.out.println("Resultado: " + operaciones.division(num1, num2));
                    }
                    case 5 -> System.out.println("Resultado: " + Math.pow(num1, num2));
                    case 6 -> System.out.println("Resultado: " + Math.sqrt(num1));
                    case 7 -> System.out.println("Resultado: " + Math.cbrt(num1));
                    default -> System.out.println("Opción no válida.");
                }

            // Operaciones con Double
            } else if (tipo == 2) {
                OperacionesMatDouble operaciones = new OperacionesMatDouble();
                System.out.print("Ingrese el primer número decimal: ");
                double num1 = sc.nextDouble();
                double num2 = 0;

                if (opcion != 6 && opcion != 7) {
                    System.out.print("Ingrese el segundo número decimal: ");
                    num2 = sc.nextDouble();
                }

                switch (opcion) {
                    case 1 -> System.out.println("Resultado: " + operaciones.suma(num1, num2));
                    case 2 -> System.out.println("Resultado: " + operaciones.resta(num1, num2));
                    case 3 -> System.out.println("Resultado: " + operaciones.producto(num1, num2));
                    case 4 -> {
                        if (num2 == 0) System.out.println("Error: División por cero.");
                        else System.out.println("Resultado: " + operaciones.division(num1, num2));
                    }
                    case 5 -> System.out.println("Resultado: " + Math.pow(num1, num2));
                    case 6 -> System.out.println("Resultado: " + Math.sqrt(num1));
                    case 7 -> System.out.println("Resultado: " + Math.cbrt(num1));
                    default -> System.out.println("Opción no válida.");
                }

            } else {
                System.out.println("Tipo inválido. Intente nuevamente.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
