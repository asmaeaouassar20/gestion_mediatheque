package mediatheque;

import java.util.List;
import java.util.Scanner;

public class Media {
    private String titre;
    private int nbrExemplairesDispo;


    public Media(){}
    public Media(String titre,int nbrExemplairesDispo){
        this.titre=titre;
        this.nbrExemplairesDispo=nbrExemplairesDispo;
    }


    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getNbrExemplairesDispo() {
        return nbrExemplairesDispo;
    }
    public void setNbrExemplairesDispo(int nbrExemplairesDispo) {
        this.nbrExemplairesDispo = nbrExemplairesDispo;
    }




    public void afficher(){
        System.out.println("- Titre : "+titre);
        System.out.println("- Nombre d'exemplaires disponibles : "+nbrExemplairesDispo);
    }
    public void modifier(){
        Scanner sc=new Scanner(System.in);
        String titre;
        int nbrExemplairesDispo;
        System.out.println("donnez le titre du media: ");
        titre=sc.nextLine();
        System.out.println("donnez le nombre d'exemplaires du media disponibles dans la mediatheque: ");
        nbrExemplairesDispo=sc.nextInt();
        this.titre=titre;
        this.nbrExemplairesDispo=nbrExemplairesDispo;
    }



    public static void afficherListMedias(List<Media> listMedias){
        for(int i=0;i<listMedias.size();i++){
            System.out.println("- - - - - Media N° "+(i+1)+" - - - - -");
            listMedias.get(i).afficher();
        }
    }
}
