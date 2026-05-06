public class Mars extends Mission {

    public Mars() {
        super("Mars", true, 225000000, 0.000015);
    }

    @Override
    public double calculerCarburant(double masse) {
        return (masse * distance * coefficient) / 1000;
    }
}