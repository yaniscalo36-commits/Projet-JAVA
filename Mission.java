public abstract class Mission {

    String nom;
    boolean habitee;
    int distance;
    double coefficient;

    public Mission(String nom, boolean habitee, int distance, double coefficient) {
        this.nom = nom;
        this.habitee = habitee;
        this.distance = distance;
        this.coefficient = coefficient;
    }

    public abstract double calculerCarburant(double masse);
}