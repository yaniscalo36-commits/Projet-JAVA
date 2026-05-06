public abstract class Capsule {

    String nom;
    boolean habitee;
    int occupantsMax;
    double masse;
    double prix;

    public Capsule(String nom, boolean habitee, int occupantsMax, double masse, double prix) {
        this.nom = nom;
        this.habitee = habitee;
        this.occupantsMax = occupantsMax;
        this.masse = masse;
        this.prix = prix;
    }
}