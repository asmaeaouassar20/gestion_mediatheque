package mediatheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mediatheque {
    List<Adherent> listAdherents;
    List<Media> listMedias;
    List<Emprunt> listEmprunts;


    public Mediatheque(){
        this.listAdherents=new ArrayList<>();
        this.listMedias=new ArrayList<>();
        this.listEmprunts=new ArrayList<>();
    }


    public void Menu(){
        System.out.println("...................................................");
        System.out.println("<0> : Quitter le programme");
        System.out.println("");
        System.out.println("<1> : Creer une liste des adherents\t\t  || <2> : Afficher la liste des adherents\t\t  || <3> : Ajouter un adherent à la liste des adhrents\t\t  || <4> : Supprimer un adherent de la liste des adhrents\t\t  || <5> : Afficher le nombre des adherents");
        System.out.println("");
        System.out.println("<6> : Creer une liste de medias\t\t  || <7> : Afficher la liste des medias\t\t  || <8> : Ajouter un media à la liste des medias\t\t  || <9> : Supprimer un media de la liste des medias");
        System.out.println("<10> : Afficher le nombre de tous les medias\t\t  || <11> : Afficher le nombre de tous les medias disponibles");
        System.out.println("");
        System.out.println("<12> : Creer une liste des emptunts\t\t  || <13> : Afficher la liste des emprunts\t\t  || <14> : Ajouter un emprunt à la liste des emprunts\t\t  || <15> : Supprimer un emprunt de la liste des emprunts\t\t  || <16> : Afficher le nombre de tous les emprunts");
        System.out.println("...................................................");
    }


    public int getNbrAdherents(){
        return this.listAdherents.size();
    }
    public int getNbrToutesMedia(){
        return listMedias.size();
    }
    public int getNbrMediasDisponibles(){
        int nbrMediasDispo=0;
        for(int i=0;i<listMedias.size();i++){
            if(listMedias.get(i).getNbrExemplairesDispo()!=0) nbrMediasDispo++;
        }
        return nbrMediasDispo;
    }
    public int getNbrEmprunts(){
        return this.listEmprunts.size();
    }


    public void creerListAdherents(){
        System.out.println("\t << NB: cette operation permet d'ajouter de nouveaux adhrents aux adhénrents deja existants >>");
        Scanner sc=new Scanner(System.in);
        int nbrAdherents,numeroAdherent;
        String nom;
        LocalDate dateNaissance;
        int nbrAdherentsAjoute=0;
        System.out.print("Donnez le nombre des adherents à ajouter: ");
        nbrAdherents=sc.nextInt();

        for(int i=0;i<nbrAdherents;i++){
            System.out.println("..... Ajouter adherent numero "+(i+1)+" .....");
            System.out.print("Numero de l'adherent: ");
            numeroAdherent=sc.nextInt();
            sc.nextLine();
            System.out.print("Nom de l'adherent: ");
            nom=sc.nextLine();
            System.out.println("Date de naissance de l'adherent: ");
            dateNaissance=saisirUneDate();
            Adherent adherent=new Adherent(numeroAdherent,nom,dateNaissance);
            boolean exist=false;
            for(int j=0;j<listAdherents.size();j++){
                if(listAdherents.get(j).equals(adherent)) exist=true;
            }
            if(!exist){
                nbrAdherentsAjoute++;
                listAdherents.add(adherent);
            }
            else System.out.println("l'adherent "+adherent.getNom()+" existe deja dans la liste des adherents");
        }
        System.out.println("--> La creation de "+nbrAdherentsAjoute+" adherents est terminée avec succes");
    }
    public void afficherListAdherents(){
        if(listAdherents.size()==0) System.out.println("Aucun adherent !!");
        for(int i=0;i<this.listAdherents.size();i++){
            System.out.println("- - - - - Adhrent N° "+(i+1)+" - - - - -");
            listAdherents.get(i).afficher();
        }
    }
    public void ajouterUnAdherent(){
        Scanner sc=new Scanner(System.in);
        int numeroAdherent;
        String nom;
        LocalDate dateNaissance;
        boolean exist=false;
        System.out.println("** Saisir les informations de l'adherent à ajouter: ");
        System.out.print("Numero de l'adhrent: ");
        numeroAdherent=sc.nextInt();
        System.out.print("Nom de l'adherent: ");
        sc.nextLine();
        nom=sc.nextLine();
        System.out.println("Date de naissance de l'adherent: ");
        dateNaissance=saisirUneDate();
        Adherent adherent=new Adherent(numeroAdherent,nom,dateNaissance);
        for(Adherent adherentItem : listAdherents){
            if(adherentItem.equals(adherent)) {
                exist=true;
                break;
            }
        }
        if(!exist) listAdherents.add(adherent);
        else System.out.println("L'adherent "+adherent.getNom()+" existe deja dans la liste");
    }
    public void supprimerAdherent(){
        int choixSuppression;
        Scanner sc=new Scanner(System.in);
        System.out.println("<0> : Retour");
        System.out.println("<1> : Supprimer toute la liste des adhérents");
        System.out.println("<2> : Supprimer un adherent precis");
        do{
            System.out.print("saisir <1> ou <2>: ");
            choixSuppression=sc.nextInt();
            switch (choixSuppression){
                case 1 : {
                    this.listAdherents.clear();
                    System.out.println("Toute la liste des adherents est supprimee avec succes");
                    break;
                }
                case 2 :{
                    int numeroAdherent;
                    int supprimerEncore;
                    do{
                        Adherent adherentASupprimer=new Adherent();
                        boolean exist=false;
                        System.out.println("Voici les adherents que vous avez dans la liste: ");
                        this.afficherListAdherents();
                        System.out.print("--> Donnez le numero de l'adherent que vous voulez supprimer : ");
                        numeroAdherent=sc.nextInt();
                        for(int i=0;i<this.listAdherents.size();i++){
                            if(listAdherents.get(i).getNumeroAdherent()==numeroAdherent){
                                exist=true;
                                adherentASupprimer=listAdherents.get(i);
                                this.listAdherents.remove(listAdherents.get(i));
                                break;
                            }
                        }
                        if(!exist) System.out.println("l'adherent de numero "+numeroAdherent+" n'existe pas");
                        else{
                            System.out.println("l'adhrent qui porte les informations suivantes ");
                            adherentASupprimer.afficher();
                            System.out.println(" est supprime avec succes");
                        }
                        System.out.println("\n Taper 1 si vous voulez supprimer encore un autre adherent");
                        supprimerEncore=sc.nextInt();
                    }while(supprimerEncore==1);
                }
            }
        }while(choixSuppression!=0 && choixSuppression!=1 && choixSuppression!=2);

    }




    public void creerListMedias(){
        System.out.println("\t << NB: cette operation permet d'ajouter de nouveaux medias aux medias deja existants >>");
        String titre;
        boolean exist;
        int nbrMediaAsaisir,choixUserTypeMedia,nbrExemplairesDispo;
        Scanner sc=new Scanner(System.in);
        System.out.print("Donnez le nombre des medias à ajouter: ");
        nbrMediaAsaisir=sc.nextInt();
        for(int i=0;i<nbrMediaAsaisir;i++){
            sc.nextLine();
            System.out.println("..... Ajouter Media numero "+(i+1)+" .....");
            System.out.print("Donnez le titre du media: ");
            titre=sc.nextLine();
            System.out.print("Donnez le nombre d'exemplaires disponibles de medias: ");
            nbrExemplairesDispo=sc.nextInt();
            do{
                System.out.println("Quelle media ??");
                System.out.println("<1> : Livre");
                System.out.println("<2> : Film");
                System.out.println("<3> : Music");
                System.out.println("<4> : Quitter");
                choixUserTypeMedia=sc.nextInt();
            }while(choixUserTypeMedia!=1 && choixUserTypeMedia!=2 && choixUserTypeMedia!=3 && choixUserTypeMedia!=4);

            switch (choixUserTypeMedia){
                case 1 : {
                    sc.nextLine();
                    exist=false;
                    String auteur;
                    int nbrPages;
                    System.out.print("Donnez le nom de l'auteur: ");
                    auteur=sc.nextLine();
                    System.out.print("Donnez le nombre de page de ce livre: ");
                    nbrPages=sc.nextInt();
                    Livre livre=new Livre(titre,nbrExemplairesDispo,auteur,nbrPages);
                    for(int j=0;j<this.listMedias.size();j++){
                        if(listMedias.get(j) instanceof Livre && listMedias.get(i).equals(livre)){
                            exist=true;
                            break;
                        }
                    }
                    if(!exist) {
                        listMedias.add(livre);
                        System.out.println("Le livre qui porte les informations suivantes ");
                        livre.afficher();
                        System.out.println("est ajouté à la liste avec succes");
                    }else System.out.println("Ce livre existe deja");
                    break;
                }
                case 2 :{
                    sc.nextLine();
                    exist=false;
                    String realisateur;
                    System.out.print("Donnez le nom du realisateur: ");
                    realisateur=sc.nextLine();
                    Film film=new Film(titre,nbrExemplairesDispo,realisateur);
                    for(int j=0;j<listMedias.size();j++){
                        if(listMedias.get(j) instanceof Film && listMedias.get(j).equals(film)){
                            exist=true;
                            break;
                        }
                    }
                    if(!exist){
                        listMedias.add(film);
                        System.out.println("le film qui porte les informations suivante ");
                        film.afficher();
                        System.out.println("est ajouté à la liste avec succes");
                    }else System.out.println("Ce film existe deja dans la liste");
                    break;
                }
                case 3:{
                    sc.nextLine();
                    exist=false;
                    String chanteur;
                    System.out.print("Donnez le nom du chanteur: ");
                    chanteur=sc.nextLine();
                    Music music=new Music(titre, nbrExemplairesDispo,chanteur);
                    for(int j=0;j<listMedias.size();j++){
                        if(listMedias.get(j) instanceof Music && listMedias.get(j).equals(music)){
                            exist=true;
                            break;
                        }
                    }
                    if(!exist){
                        listMedias.add(music);
                        System.out.println("La music qui porte les informations suivantes ");
                        music.afficher();
                        System.out.println("est ajoutée avec succes");
                    }else System.out.println("Cette music existe deja dans la liste des medias");
                    break;
                }
                }

                if(choixUserTypeMedia==4) break;
            }

        }
    public void afficherListMedias(){
        if(listMedias.size()==0) System.out.println("Aucun Media !!");
        for(int i=0;i<listMedias.size();i++){
            System.out.println("- - - - - Media N° "+(i+1)+" - - - - -");
            listMedias.get(i).afficher();
        }
    }
    public void ajouterMedia(){
        Scanner sc=new Scanner(System.in);
        String titre;
        int nbrExemplairesDispo;
        System.out.println("** Saisir les informations du media à ajouter: ");
        System.out.print("Donnez le titre du media : ");
        titre=sc.nextLine();
        boolean exit=false;
        for(int j=0;j<listMedias.size();j++){
            if(listMedias.get(j).getTitre().equals(titre)) {
                exit=true;
                break;
            }
        }
        if(!exit){
            int choixTypeMedia;
            System.out.print("Donnez le nombre d'exemplaires : ");
            nbrExemplairesDispo=sc.nextInt();
            System.out.println("Quel est le type de Media: ");
            System.out.println("<1> : Livre");
            System.out.println("<2> : Film");
            System.out.println("<3> : Music");
            choixTypeMedia=sc.nextInt();
            switch (choixTypeMedia){
                case 1 :{
                    sc.nextLine();
                    String auteur;
                    int nbrPages;
                    System.out.print("Donnez le nom de l'auteur: ");
                    auteur=sc.nextLine();
                    System.out.print("Donnez le nombre de pages du livre: ");
                    nbrPages=sc.nextInt();
                    Livre livre=new Livre(titre,nbrExemplairesDispo,auteur,nbrPages);
                    this.listMedias.add(livre);
                    System.out.println("Le livre est ajouté avec succes");
                    break;
                }
                case 2 :{
                    sc.nextLine();
                    System.out.print("Donnez le nom du realisateur: ");
                    String realisateur=sc.nextLine();
                    Film film=new Film(titre,nbrExemplairesDispo,realisateur);
                    this.listMedias.add(film);
                    System.out.println("Le film est ajoute avec succes");
                    break;
                }
                case 3 :{
                    sc.nextLine();
                    String chanteur;
                    System.out.print("Donnez le nom du chanteur: ");
                    chanteur=sc.nextLine();
                    Music music=new Music(titre,nbrExemplairesDispo,chanteur);
                    this.listMedias.add(music);
                    System.out.println("La music est ajoutee avec succes");
                    break;
                }
            }
        }else System.out.println("Ce titre existe deja dans la liste des medias");
    }
    public void supprimerMedia(){
        if(listMedias.size()==0){
            System.out.println("la liste des medias est deja vide");
            return;
        }
        int choixSuppression;
        Scanner sc=new Scanner(System.in);
        System.out.println("<0> : Retour");
        System.out.println("<1> : Supprimer toute la liste des Medias");
        System.out.println("<2> : Supprimer une media precise");
        do{
            System.out.print("saisir <1> ou <2>: ");
            choixSuppression=sc.nextInt();
            switch (choixSuppression){
                case 1 : {
                    this.listMedias.clear();
                    System.out.println("Toute la liste des medias est supprimee avec succes");
                    break;
                }
                case 2 :{
                    int supprimerEncore;
                    int numeroMediaAsupprimer;
                    do{
                        Media mediaASupprimer=new Media();
                        boolean exist=false;
                        System.out.println("Voici toutes les medias que vous avez dans la liste des medias: ");
                        this.afficherListMedias();
                        System.out.print("--> Donnez le numero du media que vous voulez supprimer : ");
                        numeroMediaAsupprimer=sc.nextInt();
                        for(int i=0;i<this.listMedias.size();i++){
                            if(i==numeroMediaAsupprimer-1){
                                exist=true;
                                mediaASupprimer=listMedias.get(i);
                                this.listMedias.remove(listMedias.get(i));
                                break;
                            }
                        }
                        if(!exist) System.out.println("Un media de numero "+numeroMediaAsupprimer+" n'existe pas");
                        else{
                            System.out.println("Le media qui porte les informations suivantes ");
                            mediaASupprimer.afficher();
                            System.out.println(" est supprime avec succes");
                        }
                        System.out.println("\n Taper 1 si vous voulez supprimer encore un autre media");
                        supprimerEncore=sc.nextInt();
                    }while(supprimerEncore==1);
                    break;
                }
            }
        }while(choixSuppression!=0 && choixSuppression!=1 && choixSuppression!=2);

    }





    public void creerListEmprunts(){
        System.out.println("\t << NB: cette operation permet d'ajouter de nouveaux Emprunts aux medias deja existants >>");

        int nbrEmpruntAsaisir,numeroAdherentConcerne;
        String nomAdherentConcerne;
        boolean exist=false;
        LocalDate dateNaissance;
        LocalDate dateSortir,dateRetour;
        Scanner sc=new Scanner(System.in);

        System.out.print("Donnez le nombre d'emprunts à ajouter: ");
        nbrEmpruntAsaisir=sc.nextInt();
        for(int i=0;i<nbrEmpruntAsaisir;i++) {
            System.out.println("..... Ajouter Emprunt numero " + (i + 1) + " .....");
            System.out.println("\t\t saisir les informations sur ... l'adherent ... concerne ");
            System.out.print("donnez le numero de l'adherent: ");
            numeroAdherentConcerne=sc.nextInt();
            sc.nextLine();
            System.out.print("donnez le nom de l'adherent: ");
            nomAdherentConcerne=sc.nextLine();
            System.out.println("donnez la date de naissance de l'adherent: ");
            dateNaissance=saisirUneDate();
            Adherent adherentConcerne=new Adherent(numeroAdherentConcerne,nomAdherentConcerne,dateNaissance);
            for(Adherent adherentItem:listAdherents){
                if(adherentItem.equals(adherentConcerne)){
                    exist=true;
                    break;
                }
            }
            if(!exist){
                char choixNouveauAdherent;
                System.out.println("L'adherent que vous avez saisi, qui porte les informations suivantes: ");
                adherentConcerne.afficher();
                System.out.println("n'existe pas dans la liste des adherents\n Est ce que vous voulez ajouter cet adherent à la liste");
                System.out.println("<O> : oui");
                System.out.println("<N> : non");
                do{
                    System.out.print("Donnez une reponse 'O' ou 'N' : ");
                    choixNouveauAdherent=sc.next().charAt(0);
                }while(choixNouveauAdherent!='o' && choixNouveauAdherent!='O' && choixNouveauAdherent!='n' && choixNouveauAdherent!='N');
                if(choixNouveauAdherent=='o' || choixNouveauAdherent=='O'){
                    listAdherents.add(adherentConcerne);
                    System.out.println("L'adherent "+adherentConcerne.getNom()+" est ajoutee à la liste des adherents");
                }else return;
            }
            System.out.println("Donnez la date de sortie de cet emprunt: ");
            dateSortir=saisirUneDate();
            System.out.println("Donnez la date de retour de cet emprunt: ");
            dateRetour=saisirUneDate();
            Emprunt emprunt=new Emprunt(adherentConcerne,dateSortir,dateRetour);
            System.out.println("Creer la liste de medias empruntes par cet adherent: ");
            emprunt.remplirListeMeidiasEmpruntes(this.listMedias);
            if(emprunt.getNbrListMediasEmpruntes()==0){
                System.out.println("attention !! emprunt sans medias empruntes");
            }else{
                this.listEmprunts.add(emprunt);
                System.out.println("L'emprunt est ajoute avec succes à la liste des emprunts");
            }
        }
    }
    public void afficherListEmprunts(){
        if(listEmprunts.size()==0) System.out.println("Aucun Emprunt !!");
        for(int i=0;i<listEmprunts.size();i++){
            System.out.println("- - - - -------------- Emprunt N° "+(i+1)+" --------------- - - - -");
            listEmprunts.get(i).afficher();
        }
    }
    public void ajouterEmprunt(){
        Scanner sc=new Scanner(System.in);
        int numeroAdherentConcerne;
        boolean exist=false;


        System.out.println("** Saisir les informations de l'emprunt à ajouter: ");
        System.out.println("1) saisir les informations sur l'adherent concerne");
        System.out.println("donnez le numero de l'adherent concerne: ");
        numeroAdherentConcerne=sc.nextInt();
        for(Emprunt emprunt:listEmprunts){
            if(emprunt.getAdherent().getNumeroAdherent()==numeroAdherentConcerne){
                exist=true;
                break;
            }
        }
        if(exist){
            System.out.println("Le numero de l'adherent que vous avez saisi existe deja dans la liste des emprunts");
        }else{
            Adherent adherentConcerne=new Adherent();

            exist=false;
            for(int j=0;j<this.listAdherents.size();j++){
                if(listAdherents.get(j).getNumeroAdherent()==numeroAdherentConcerne){
                    exist=true;
                    adherentConcerne=listAdherents.get(j);
                    break;
                }
            }
            if(exist) System.out.println("cet adherent existe deja dans la liste des adherents");
            if(!exist){
                String nomAdherentConcerne;
                LocalDate dateNaissanceAdherentConcerne;
                char choixAjouterAdherent;
                System.out.println("le numero de l'adherent que vous avez saisi n'existe pas dans  la liste des adherents de la mediatheque");
                System.out.println("tapez <o> pour ajouter cet adherent à la liste des adherents");
                System.out.println("tapez <n> pour annuler");
                choixAjouterAdherent=sc.next().charAt(0);
                if(choixAjouterAdherent=='o' || choixAjouterAdherent=='O'){
                    sc.nextLine();
                    System.out.print("donnez le nom de l'adherent concerne: ");
                    nomAdherentConcerne=sc.nextLine();
                    adherentConcerne.setNom(nomAdherentConcerne);
                    System.out.println("donnez la date de naissance de cet adherent");
                    dateNaissanceAdherentConcerne=saisirUneDate();
                    adherentConcerne.setDateNaissance(dateNaissanceAdherentConcerne);
                    adherentConcerne.setNumeroAdherent(numeroAdherentConcerne);
                    this.listAdherents.add(adherentConcerne);
                    System.out.println("L'adherent "+adherentConcerne.getNom()+" est ajoutee à la liste des adherents");
                }else return;
            }
            LocalDate dateSortir,dateRetour;
            System.out.println("2) donnez la date de sortie de l'emprunt");
            dateSortir=saisirUneDate();
            System.out.println("3) donnez la date de retour de l'emprunt");
            dateRetour=saisirUneDate();
            Emprunt emprunt=new Emprunt(adherentConcerne,dateSortir,dateRetour);
            System.out.println("4) remplir la liste des medias empruntes par cet adherent");
            emprunt.remplirListeMeidiasEmpruntes(this.listMedias);
            if(emprunt.getNbrListMediasEmpruntes()==0) System.out.println("impossible d'ajouter un emprunt sans medias empruntes");
            else{
                this.listEmprunts.add(emprunt);
                System.out.println("L'emprunt est ajoutee avec succes");
            }

        }

    }
    public void supprimerEmprunt(){
        if(listEmprunts.size()==0){
            System.out.println("La liste des emprunts est deja vide");
            return;
        }
        int choixSuppression;
        Scanner sc=new Scanner(System.in);
        System.out.println("<0> : Retour");
        System.out.println("<1> : Supprimer toute la liste des Emprunts");
        System.out.println("<2> : Supprimer un emprunt precis");
        do{
            System.out.print("saisir <0> ou <1> ou <2>: ");
            choixSuppression=sc.nextInt();
        }while(choixSuppression!=0 && choixSuppression!=1 && choixSuppression!=2);
        if(choixSuppression==0) return;
        if(choixSuppression==1){
            this.listEmprunts.clear();
            System.out.println("La liste des emprunts est toute supprimee");
        }
        if(choixSuppression==2){
            int numeroEmpruntAsupprimer;
            Emprunt empruntAsupperimer=new Emprunt();
            System.out.println("voici la liste des emprunts que vous avez");
            this.afficherListEmprunts();
            System.out.print("donnez le numero de l'emprunt que vous voulez supprimer: ");
            numeroEmpruntAsupprimer=sc.nextInt();
            if(numeroEmpruntAsupprimer<1 || numeroEmpruntAsupprimer>listEmprunts.size()){
                System.out.print("le numero saisi introuvable");
                return;
            }
            for(int i=0;i<listEmprunts.size();i++){
                if(i==numeroEmpruntAsupprimer-1){
                    empruntAsupperimer=listEmprunts.get(i);
                    listEmprunts.remove(i);
                    break;
                }
            }

                System.out.println("l'emprunt qui porte les informations suivantes");
                empruntAsupperimer.afficher();
                System.out.println("est supprime avec succes");
        }

    }






    public static LocalDate saisirUneDate(){
        Scanner sc=new Scanner(System.in);
        int annee,mois,jour;
        System.out.print("annee: ");
        annee=sc.nextInt();
        System.out.print("mois: ");
        mois=sc.nextInt();
        System.out.print("jour: ");
        jour=sc.nextInt();
        LocalDate date=LocalDate.of(annee,mois,jour);
        return date;
    }
    public static List<Media> creerUneListMedia(int n){
        List<Media> listMedias=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String titre;
        int nbrExemplairesDispo;
        for(int i=0;i<n;i++){
            System.out.println("..... Ajouter Media numero "+(i+1)+" .....");
            System.out.print("Titre: ");
            titre=sc.nextLine();
            System.out.println("Le nombre d'exemplaires: ");
            nbrExemplairesDispo=sc.nextInt();
            Media media=new Media(titre,nbrExemplairesDispo);
            listMedias.add(media);
        }
        return listMedias;
    }



}
