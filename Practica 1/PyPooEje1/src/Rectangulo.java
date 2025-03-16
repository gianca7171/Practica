public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        this.esquina1 = new Coordenada(c1);
        this.esquina2 = new Coordenada(c2);
    }

    // Métodos getter
    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    // Métodos setter
    public void setEsquina1(Coordenada c) {
        this.esquina1 = new Coordenada(c);
    }

    public void setEsquina2(Coordenada c) {
        this.esquina2 = new Coordenada(c);
    }

    // Cálculo del área del rectángulo
    public double calculoArea() {
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        return base * altura;
    }

    // Cálculo de la distancia euclidiana entre las esquinas
    public double distanciaEuclidiana() {
        return esquina1.distancia(esquina2);
    }

    // Representación en String del rectángulo
    @Override
    public String toString() {
        return "(" + esquina1 + ", " + esquina2 + ")";
    }
}
