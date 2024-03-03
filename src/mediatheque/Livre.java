package mediatheque;

public class Livre extends Media{
    private String auteur;
    private int nbrPages;



    public Livre(String titre,int nbrExemplairesDispo,String auteur,int nbrPages){
        super(titre,nbrExemplairesDispo);
        this.auteur=auteur;
        this.nbrPages=nbrPages;
    }



    public boolean equals(Livre livre){
        if(this.getTitre().equals(livre.getTitre()) && this.getNbrExemplairesDispo()==livre.getNbrExemplairesDispo() && this.auteur.equals(livre.auteur) && this.nbrPages==livre.nbrPages){
            return true;
        }
        return false;
    }



    public void afficher(){
        System.out.println("- Titre du livre : "+this.getTitre());
        System.out.println("- Nombre d'exemplaires disponibles : "+this.getNbrExemplairesDispo());
        System.out.println("- Nom d'auteur : "+this.auteur);
        System.out.println("- Nombre de pages du livre : "+this.nbrPages);
    }


}
