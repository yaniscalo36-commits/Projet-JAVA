public class MissionPerso extends Mission {

    public MissionPerso() {
        super("Mission Perso", true, 10000, 0.0008);
    }

    @Override
    public double calculerCarburant(double masse) {
        return (masse * distance * coefficient) / 1000;
    }
}