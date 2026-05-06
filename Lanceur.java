public abstract class Lanceur {

    String nom;
    boolean habite;
    int boostersMax;
    double carburantMax;
    double chargeUtile;
    double prix;

    public Lanceur(String nom, boolean habite, int boostersMax, double carburantMax, double chargeUtile, double prix) {
        this.nom = nom;
        this.habite = habite;
        this.boostersMax = boostersMax;
        this.carburantMax = carburantMax;
        this.chargeUtile = chargeUtile;
        this.prix = prix;
    }

    public abstract double calculerCapacite();
}