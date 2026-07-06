Simulateur de Lancement Spatial (Java)
Lancement : clique droit sur Main.Java et run debug 
 Description

Ce projet est un simulateur de lancement de fusée en Java réalisé dans le cadre d’un projet de programmation.

L’utilisateur peut :

Configurer une fusée (lanceur, capsule, boosters)
Choisir une mission (Orbite, ISS, Lune, Mars, mission personnalisée)
Lancer une simulation avec vérifications physiques
Observer le résultat (succès ou échec)
Consulter un historique des lancements sauvegardé dans un fichier
 Fonctionnalités
1. Configuration de la fusée
Choix du lanceur
Choix de la capsule
Ajout de boosters 
Calcul du coût total
2. Missions disponibles
Orbite terrestre
ISS
Lune
Mars
Mission personnalisée
3. Simulation

Vérifications automatiques :

Carburant suffisant
Masse ≤ charge utile
Compatibilité mission habitée

Puis :

Tirage aléatoire (5% d’échec)
Résultat affiché
4. Historique
Sauvegarde automatique dans historique.txt
Lecture au démarrage
Affichage des lancements précédents
Modélisation (UML)
Hiérarchies abstraites :
Lanceur (abstraite)
Capsule (abstraite)
Mission (abstraite)
Classes concrètes :
Lanceurs : SaturneV, Ariane5, Falcon9, SLS
Capsules : Orion, CrewDragon, Apollo, CargoDragon
Missions : Orbite, ISS, Lune, Mars, MissionPerso
Composition :
Simulateur contient :
1 Lanceur
1 Capsule
0..* Boosters
1 Mission
Polymorphisme :
Méthode calculerCarburant() redéfinie dans chaque mission
Compilation et exécution
Faire un: run java 
Exemple d’utilisation
Choisir un lanceur
Choisir une capsule
Ajouter des boosters
Choisir une mission
Lancer la simulation
Regarder l'historique
Mission personnalisée

La classe MissionPerso permet de définir :

distance
coefficient carburant
type habité

Elle permet de tester un différent scénario.
Structure du projet
Projet-JAVA/
│
├── Simulateur.java
├── Main.java
├── Lanceur.java
├── Capsule.java
├── Mission.java
├── Booster.java
│
├── SaturneV.java
├── Ariane5.java
├── Falcon9.java
├── SLS.java
│
├── Orion.java
├── CrewDragon.java
├── Apollo.java
├── CargoDragon.java
│
├── Orbite.java
├── ISS.java
├── Lune.java
├── Mars.java
├── MissionPerso.java
│
├── historique.txt
└── README.md
Historique

Chaque lancement est enregistré sous la forme :

Lanceur | Mission | Résultat | Coût

Exemple :

Falcon 9 | Lune | SUCCES | 240
Déclaration d’utilisation de l’IA

Ce projet a été réalisé avec l’aide de ChatGPT pour :

Compréhension des concepts Java
Correction de bugs
Amélioration du code que se soit plus jolie à lire, mais le code n'est pas changé

Ce projet a été réalisé dans le cadre d'un projet de B1 fin d'année.

repo github : https://github.com/yaniscalo36-commits/Projet-JAVA.git

Merci de votre attention !