public class SLS extends Lanceur {

    public SLS() {
        super("SLS", true, 2, 2600, 130, 2000);
    }

    @Override
    public double calculerCapacite() {
        return chargeUtile;
    }
}