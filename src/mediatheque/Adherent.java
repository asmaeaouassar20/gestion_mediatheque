package mediatheque;

import java.time.LocalDate;
import java.util.Scanner;

import static mediatheque.Mediatheque.saisirUneDate;

public class Adherent {
    private int numeroAdherent;
    private String nom;
    private LocalDate dateNaissance;


    public Adherent(){}
    public Adherent(int numeroAdherent,String nom,LocalDate dateNaissance){
        this.numeroAdherent=numeroAdherent;
        this.nom=nom;
        this.dateNaissance=dateNaissance;
    }




    public boolean equals(Adherent adherent){
        if(this.numeroAdherent==adherent.numeroAdherent && this.nom.equals(adherent.nom) && this.dateNaissance.getYear()==adherent.getDateNaissance().getYear() && this.dateNaissance.getMonth()==adherent.dateNaissance.getMonth() && this.dateNaissance.getDayOfMonth()==adherent.getDateNaissance().getDayOfMonth()){
            return true;
        }
        return false;
    }




    public int getNumeroAdherent() {
        return numeroAdherent;
    }
    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }




    public void afficher(){
        System.out.println("- Numero : "+numeroAdherent);
        System.out.println("- Nom : "+nom);
        System.out.println("- Date de naissance : "+dateNaissance);
    }
    public void modifier(){
        Scanner sc=new Scanner(System.in);
        int numeroAdherent;
        String nom;
        LocalDate dateNaissance;
        System.out.println("donnez le numero de l'adherent: ");
        numeroAdherent=sc.nextInt();
        System.out.println("donnez le nom de l'adhrent: ");
        nom=sc.nextLine();
        System.out.println("donnez la date de naissance de l'adherent: ");
        dateNaissance=saisirUneDate();

        this.numeroAdherent=numeroAdherent;
        this.nom=nom;
        this.dateNaissance=dateNaissance;
    }

}
