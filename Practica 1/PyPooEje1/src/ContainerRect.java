public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;  // Número máximo de rectángulos
    private int numRec; // Cantidad actual de rectángulos almacenados

    // Constructor
    public ContainerRect(int n) {
        this.n = n;
        this.numRec = 0;
        this.rectangulos = new Rectangulo[n];
        this.distancias = new double[n];
        this.areas = new double[n];
    }

    // Método para agregar un rectángulo al contenedor
    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            distancias[numRec] = r.distanciaEuclidiana();
            areas[numRec] = r.calculoArea();
            numRec++;
        } else {
            System.out.println("No se puede agregar más rectángulos. Capacidad máxima alcanzada.");
        }
    }

    // Representación en String del contenedor
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s %-25s %-10s %-10s\n", "Rectángulo", "Coordenadas", "Distancia", "Área"));
        for (int i = 0; i < numRec; i++) {
            sb.append(String.format("%-12d %-25s %-10.3f %-10.3f\n", 
                (i + 1), rectangulos[i], distancias[i], areas[i]));
        }
        return sb.toString();
    }
}
