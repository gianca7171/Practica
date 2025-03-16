public class Coordenada {
    private double x;
    private double y;

    // Constructor por defecto
    public Coordenada() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Constructor con parámetros
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor de copia
    public Coordenada(Coordenada c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    // Métodos getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Métodos setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Distancia euclidiana entre dos coordenadas
    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2));
    }

    // Representación en String de una coordenada
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
