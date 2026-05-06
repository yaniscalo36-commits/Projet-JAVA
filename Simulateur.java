import java.io.*;
import java.util.Scanner;

public class Simulateur {

    Scanner scanner = new Scanner(System.in);

    Lanceur lanceur;
    Capsule capsule;
    Booster booster;
    Mission mission;

    // Probabilité d'échec aléatoire
    public static final double PROBA_ECHEC = 0.05;

    public void demarrer() {
        int choix = 0;

        // Affichage de l'historique au démarrage
        System.out.println("Historique existant :");
        afficherHistorique();

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Choisir lanceur");
            System.out.println("2. Choisir capsule");
            System.out.println("3. Choisir booster");
            System.out.println("4. Choisir mission");
            System.out.println("5. Lancer simulation");
            System.out.println("6. Quitter");
            System.out.println("7. Historique");

            // on peut pas mettre de abc etc dans les choix
            if (!scanner.hasNextInt()) {
                System.out.println("Entree invalide");
                scanner.next();
                continue;
            }

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    choisirLanceur();
                    break;
                case 2:
                    choisirCapsule();
                    break;
                case 3:
                    choisirBooster();
                    break;
                case 4:
                    choisirMission();
                    break;
                case 5:
                    lancerSimulation();
                    break;
                case 6:
                    System.out.println("Au revoir");
                    break;
                case 7:
                    afficherHistorique();
                    break;
                default:
                    System.out.println("Mauvais choix");
            }

        } while (choix != 6);
    }

    void choisirLanceur() {
        System.out.println("\nChoisis un lanceur :");
        System.out.println("1. Saturne V");
        System.out.println("2. Ariane 5");
        System.out.println("3. Falcon 9");
        System.out.println("4. SLS");

        if (!scanner.hasNextInt()) {   //verifie que l'entrée est un entier
            System.out.println("Entree invalide");
            scanner.next();
            return;
        }

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                lanceur = new SaturneV();
                break;
            case 2:
                lanceur = new Ariane5();
                break;
            case 3:
                lanceur = new Falcon9();
                break;
            case 4:
                lanceur = new SLS();
                break;
            default:
                System.out.println("Mauvais choix");
                return;
        }

        System.out.println("Lanceur choisi : " + lanceur.nom);
    }

    void choisirCapsule() {
        System.out.println("\nChoisis une capsule :");
        System.out.println("1. Orion");
        System.out.println("2. Crew Dragon");
        System.out.println("3. Apollo");
        System.out.println("4. Cargo Dragon");

        if (!scanner.hasNextInt()) {
            System.out.println("Entree invalide");
            scanner.next();
            return;
        }

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                capsule = new Orion();
                break;
            case 2:
                capsule = new CrewDragon();
                break;
            case 3:
                capsule = new Apollo();
                break;
            case 4:
                capsule = new CargoDragon();
                break;
            default:
                System.out.println("Mauvais choix");
                return;
        }

        System.out.println("Capsule choisie : " + capsule.nom);
    }

    void choisirBooster() {

        // Vérifie qu’un lanceur est choisi
        if (lanceur == null) {
            System.out.println("Choisis d'abord un lanceur");
            return;
        }

        // Vérifie si le lanceur accepte des boosters
        if (lanceur.boostersMax == 0) {
            System.out.println("Ce lanceur ne peut pas utiliser de booster");
            booster = null;
            return;
        }

        System.out.println("\nChoisis un booster :");
        System.out.println("1. EAP");
        System.out.println("2. SRB");
        System.out.println("3. BE-3");

        if (!scanner.hasNextInt()) {
            System.out.println("Entree invalide");
            scanner.next();
            return;
        }

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                booster = new EAP();
                break;
            case 2:
                booster = new SRB();
                break;
            case 3:
                booster = new BE3();
                break;
            default:
                System.out.println("Mauvais choix");
                return;
        }

        System.out.println("Booster ajoute : " + booster.nom);
    }

    void choisirMission() {
        System.out.println("\nChoisis une mission :");
        System.out.println("1. Lune");
        System.out.println("2. Mars");
        System.out.println("3. ISS");
        System.out.println("4. Mission Perso");

        if (!scanner.hasNextInt()) {
            System.out.println("Entree invalide");
            scanner.next();
            return;
        }

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                mission = new Lune();
                break;
            case 2:
                mission = new Mars();
                break;
            case 3:
                mission = new ISS();
                break;
            case 4:
                mission = new MissionPerso();
                break;
            default:
                System.out.println("Mauvais choix");
                return;
        }

        System.out.println("Mission choisie : " + mission.nom);
    }

    public void lancerSimulation() {

        // Vérifie si on a tous les éléments nécessaires pour lancer la simulation
        if (lanceur == null || mission == null || capsule == null) {
            System.out.println("Configuration incomplete");
            return;
        }

        // Calcul masse totale (capsule + booster)
        double masseBooster = (booster != null) ? booster.masse : 0;
        double masseTotale = capsule.masse + masseBooster;
        // Polymorphisme 
        double carburantNecessaire = mission.calculerCarburant(masseTotale);

        // Vérification carburant
        if (carburantNecessaire > lanceur.carburantMax) {
            System.out.println("Carburant insuffisant");
            return;
        }
        // Polymorphisme 
        if (masseTotale > lanceur.calculerCapacite()) {
            System.out.println("Surcharge depassee");
            return;
        }

        // Compatibilité mission habitée
        if (mission.habitee && !capsule.habitee) {
            System.out.println("Capsule incompatible avec une mission habitee");
            return;
        }

        // Aléa
        double alea = Math.random();
        String resultat;

        if (alea < PROBA_ECHEC) {
            resultat = "ECHEC";
            System.out.println("Anomalie technique imprevue");
        } else {
            resultat = "SUCCES";
            System.out.println("Succes vers " + mission.nom);
        }

        // Calcul coût
        double prixBooster = (booster != null) ? booster.prix : 0;
        double coutTotal = lanceur.prix + capsule.prix + prixBooster;

        System.out.println("Cout total : " + coutTotal + " M€");

        // Sauvegarde historique
        sauvegarder(resultat, coutTotal);
    }

    // Sauvegarde dans fichier
    void sauvegarder(String resultat, double cout) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("historique.txt", true));

            bw.write(lanceur.nom + " | " + mission.nom + " | " + resultat + " | " + cout);
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde");
        }
    }

    // Lecture historique
    void afficherHistorique() {
        try {
            File file = new File("historique.txt");

            if (!file.exists()) {
                System.out.println("Aucun historique");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Erreur lecture historique");
        }
    }
}