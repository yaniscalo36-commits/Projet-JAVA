public class Orbite extends Mission {

    public Orbite() {
        super("Orbite terrestre", false, 400, 1.0);
    }

     @Override
    public double calculerCarburant(double masse) {
        return (masse * distance * coefficient) / 1000;
    }
}