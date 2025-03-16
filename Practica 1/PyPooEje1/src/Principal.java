import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un contenedor con capacidad para 10 rectángulos (ajustable)
        ContainerRect contenedor = new ContainerRect(10);

        while (true) {
            System.out.println("Ingrese una esquina del rectángulo (x y), o -1 para salir:");
            double x1 = scanner.nextDouble();
            if (x1 == -1) break;  // Salir del bucle si el usuario ingresa -1
            double y1 = scanner.nextDouble();

            System.out.println("Ingrese la esquina opuesta del rectángulo (x y):");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();

            // Crear el rectángulo y almacenarlo en el contenedor
            Rectangulo nuevoRect = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
            contenedor.addRectangulo(nuevoRect);
        }

        // Mostrar la información de los rectángulos almacenados
        System.out.println("\nRectángulos almacenados:");
        System.out.println(contenedor);

        scanner.close();
    }
}
