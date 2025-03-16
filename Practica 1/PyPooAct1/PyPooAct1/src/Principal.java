import java.util.Scanner;

public class Principal {

    // Determina si dos rectángulos se sobreponen
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        return !(r1.getEsquina1().getX() > r2.getEsquina2().getX() ||
                r1.getEsquina2().getX() < r2.getEsquina1().getX() ||
                r1.getEsquina1().getY() > r2.getEsquina2().getY() ||
                r1.getEsquina2().getY() < r2.getEsquina1().getY());
    }

    // Determina si dos rectángulos están juntos (tocándose en un borde)
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        return (r1.getEsquina1().getX() == r2.getEsquina2().getX() ||
                r1.getEsquina2().getX() == r2.getEsquina1().getX() ||
                r1.getEsquina1().getY() == r2.getEsquina2().getY() ||
                r1.getEsquina2().getY() == r2.getEsquina1().getY());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una esquina del 1er rectángulo: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 1er rectángulo: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        Rectangulo rectA = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));

        System.out.println("Ingrese una esquina del 2do rectángulo: ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 2do rectángulo: ");
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();
        Rectangulo rectB = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        System.out.println("Rectángulo A = " + rectA);
        System.out.println("Rectángulo B = " + rectB);

        if (esSobrePos(rectA, rectB)) {
            System.out.println("Rectángulos A y B se sobreponen.");
        } else if (esJunto(rectA, rectB)) {
            System.out.println("Rectángulos A y B están juntos.");
        } else {
            System.out.println("Rectángulos A y B son disjuntos.");
        }

        scanner.close();
    }
}
