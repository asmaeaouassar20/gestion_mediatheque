package mediatheque;

import java.util.Scanner;

public class MainProgramme {
    public static void main(String[] args){

        System.out.println("~~~~~~~~~~~  Creation d'une mediatheque  ~~~~~~~~~~~");
        Mediatheque mediatheque=new Mediatheque();

        Scanner scanner=new Scanner(System.in);
        int choixUtilisateurMenu=100; // initialiser la variable pour pouvoi accéder à la boucle

        mediatheque.Menu();
        System.out.println("\n");

        System.out.print("donnez votre choix: ");
        choixUtilisateurMenu=scanner.nextInt();

        while(choixUtilisateurMenu!=0){
            switch (choixUtilisateurMenu){
                case 1:{
                    mediatheque.creerListAdherents();
                    break;
                }
                case 2 :{
                    mediatheque.afficherListAdherents();
                    break;
                }
                case 3:{
                    mediatheque.ajouterUnAdherent();
                    break;
                }
                case 4 :{
                    mediatheque.supprimerAdherent();
                    break;
                }
                case 5 :{
                    System.out.println("Le nombre total des adherents est: "+mediatheque.getNbrAdherents());
                    break;
                }
                case 6 :{
                    mediatheque.creerListMedias();
                    break;
                }
                case 7:{
                    mediatheque.afficherListMedias();
                    break;
                }
                case 8:{
                    mediatheque.ajouterMedia();
                    break;
                }
                case 9:{
                    mediatheque.supprimerMedia();
                    break;
                }
                case 10 :{
                    System.out.println("le nombre de tous les medias: "+mediatheque.getNbrToutesMedia());
                    break;
                }
                case 11:{
                    System.out.println("le nombre de tous les medias disponibles: "+mediatheque.getNbrMediasDisponibles());
                    break;
                }
                case 12:{
                    mediatheque.creerListEmprunts();
                    break;
                }
                case 13:{
                    mediatheque.afficherListEmprunts();
                    break;
                }
                case 14:{
                    mediatheque.ajouterEmprunt();
                    break;
                }
                case 15:{
                    mediatheque.supprimerEmprunt();
                    break;
                }
                case 16:{
                    System.out.println("Le nombre total des emprunts: "+mediatheque.getNbrEmprunts());
                    break;
                }
                default:{
                    System.out.println("Le choix saisi est inconnu");
                    break;
                }
            }
            System.out.println(" ");
            mediatheque.Menu();
            System.out.println(" ");

            System.out.print("donnez votre choix: ");
            System.out.println(" ");

            choixUtilisateurMenu=scanner.nextInt();

        }
        System.out.println("Fin programme");

    }
}


