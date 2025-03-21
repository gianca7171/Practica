public class Principal {
    public static void main(String[] args) {
        // Crear una bolsa de Chocolatinas con un límite de 3 elementos
        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);
        
        // Crear objetos de tipo Chocolatina
        Chocolatina c = new Chocolatina("Milky");
        Chocolatina c1 = new Chocolatina("Sublime");
        Chocolatina c2 = new Chocolatina("Princesa");

        // Agregar Chocolatinas a la bolsa
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        // Imprimir contenido de la bolsa de Chocolatinas
        System.out.println("Contenido de la bolsa de Chocolatinas:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // Crear una bolsa de Golosinas con un límite de 3 elementos
        Bolsa<Golosina> bolsaGol = new Bolsa<>(3);

        // Crear objetos de tipo Golosina con nombre y peso
        Golosina g1 = new Golosina("Gomitas", 50);
        Golosina g2 = new Golosina("Chicle", 20);
        Golosina g3 = new Golosina("Chupetin", 30);

        // Agregar Golosinas a la bolsa
        bolsaGol.add(g1);
        bolsaGol.add(g2);
        bolsaGol.add(g3);

        // Imprimir contenido de la bolsa de Golosinas
        System.out.println("\nContenido de la bolsa de Golosinas:");
        for (Golosina golosina : bolsaGol) {
            System.out.println(golosina.getNombre() + " - " + golosina.getPeso() + "g");
        }
    }
}
