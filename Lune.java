public class Lune extends Mission {

    public Lune() {
        super("Lune", true, 400000, 0.005);
    }

    @Override
    public double calculerCarburant(double masse) {
        return (masse * distance * coefficient) / 1000;
    }
}