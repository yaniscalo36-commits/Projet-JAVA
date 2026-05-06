public class ISS extends Mission {

    public ISS() {
        super("ISS", true, 400, 1.2);
    }

    @Override
    public double calculerCarburant(double masse) {
        return (masse * distance * coefficient) / 1000;
    }
}