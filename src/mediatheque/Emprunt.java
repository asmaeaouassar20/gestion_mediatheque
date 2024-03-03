package mediatheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static mediatheque.Media.afficherListMedias;
import static mediatheque.Mediatheque.creerUneListMedia;
import static mediatheque.Mediatheque.saisirUneDate;

public class Emprunt {
    private Adherent adherent;
    private LocalDate dateSortir;
    private LocalDate dateRetour;
    private List<Media> listeMediaEmprunte;




    public Emprunt(){}
    public Emprunt(Adherent adherent,LocalDate dateSortir,LocalDate dateRetour){
        this.adherent=adherent;
        this.dateSortir=dateSortir;
        this.dateRetour=dateRetour;
        listeMediaEmprunte=new ArrayList<>();
    }


    public Adherent getAdherent() {
        return adherent;
    }
    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
    public LocalDate getDateSortir() {
        return dateSortir;
    }
    public void setDateSortir(LocalDate dateSortir) {
        this.dateSortir = dateSortir;
    }
    public LocalDate getDateRetour() {
        return dateRetour;
    }
    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
    public int getNbrListMediasEmpruntes(){
        return this.listeMediaEmprunte.size();
    }



    public void afficher(){
        System.out.println("L'adherent concerne: ");
        this.adherent.afficher();
        System.out.println("La date de sortie de l'emprunt: "+dateSortir);
        System.out.println("La date de retour de l'emprunt: "+dateRetour);
        System.out.println("La liste des medias empruntee: ");
        afficherListMedias(this.listeMediaEmprunte);
    }
    public void remplirListeMeidiasEmpruntes(List<Media> listMediasMediatheque){
        int nbrMediasEmpruntes;
        Media media=new Media();
        String titre;
        boolean exist=false,dispo=false;
        Scanner sc=new Scanner(System.in);
        System.out.print("Donnez le nombre de medias empruntes: ");
        nbrMediasEmpruntes=sc.nextInt();
        while(nbrMediasEmpruntes<=0){
            System.out.print("saisir un nombre convenable: ");
            nbrMediasEmpruntes=sc.nextInt();
        }
        for(int i=0;i<nbrMediasEmpruntes;i++){
            sc.nextLine();
            System.out.println("____ media emprunte N° "+(i+1)+" ____");
            System.out.print("donnez le titre du media que vous voulez emprunte: ");
            titre=sc.nextLine();
            for(int j=0;j<listMediasMediatheque.size();j++){
                if(listMediasMediatheque.get(j).getTitre().equals(titre)){
                    exist=true;
                    if(listMediasMediatheque.get(j).getNbrExemplairesDispo()>0){
                        dispo=true;
                        this.listeMediaEmprunte.add(listMediasMediatheque.get(j));
                        listMediasMediatheque.get(j).setNbrExemplairesDispo(listMediasMediatheque.get(j).getNbrExemplairesDispo()-1);
                        media=listMediasMediatheque.get(j);
                    }
                }
            }
            if(!exist){
                System.out.println("ce media n'existe pas dans la liste des medias");
                return;
            }else{
                if(dispo){
                    System.out.println("le media qui porte les informations suivantes ");
                    media.afficher();
                    System.out.println("est ajoute avec succes à la liste des medias empruntes");
                }else{
                    System.out.println("ce media est non disponible");
                }
            }
        }
    }
    public void modifier(){
        System.out.println("Modifier l'adherent: ");
        this.adherent.modifier();
        System.out.print("Modifier la date de sortie de l'emprunt: ");
        this.dateSortir=saisirUneDate();
        System.out.print("Modifier la date de retour de l'emprunt: ");
        this.dateRetour=saisirUneDate();
        System.out.println("Voici la liste des medias empruntees: ");
        afficherListMedias(this.listeMediaEmprunte);
        System.out.println("<1> : modifier toute la liste des medias empruntees");
        System.out.println("<2> : ne pas modifier la liste des medias empruntees");
        System.out.println("<3> : modifier quelques medias");
        Scanner sc=new Scanner(System.in);
        int choix;
        do{
            System.out.print("saisir un choix (1,2,3): ");
            choix=sc.nextInt();
        }while(choix!=1 && choix!=2 && choix!=3);
        switch (choix){
            case 1 :{
                int n;
                System.out.println("La liste ancienne des medias empruntes est supprimee");
                System.out.print("Donnez le nombre de medias a ajouter: ");
                n=sc.nextInt();
                this.listeMediaEmprunte.clear();
                this.listeMediaEmprunte=creerUneListMedia(n);
                break;
            }
            case 2: {
                break;
            }
            case 3 :{
                System.out.println("Voici la liste des medias deja existants: ");
                afficherListMedias(listeMediaEmprunte);
                int indexMediaAmodifier,reponse=1;

               do{
                    System.out.print("Saisir le numero du media que vous voulez supprimer: ");
                    indexMediaAmodifier=sc.nextInt();
                    while(indexMediaAmodifier<=0 || indexMediaAmodifier>listeMediaEmprunte.size()){
                        System.out.println("le numero est compris entre 1 et "+listeMediaEmprunte.size());
                        indexMediaAmodifier=sc.nextInt();
                    }

                    for(int i=0;i<listeMediaEmprunte.size();i++){
                        if(i==indexMediaAmodifier-1) listeMediaEmprunte.get(i).modifier();
                    }
                   System.out.println("Est ce que vous vouler modifier un autre media: ");
                   System.out.println("<0> : NON");
                   System.out.println("<1> : OUI");
                   reponse=sc.nextInt();

                }while(reponse==1);


            }
        }

    }


}
