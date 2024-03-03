package mediatheque;

public class Music extends Media{
    private String chanteur;



    public Music(String titre,int nbrExemplairesDispo,String chanteur){
        super(titre,nbrExemplairesDispo);
        this.chanteur=chanteur;
    }


    public boolean equals(Music music){
        if(this.getTitre().equals(music.getTitre()) && this.getNbrExemplairesDispo()==music.getNbrExemplairesDispo() && this.chanteur.equals(music.chanteur)){
            return true;
        }
        return false;
    }

    public void afficher(){
        System.out.println("- Titre de la music: "+this.getTitre());
        System.out.println("- Nombre d'exemplaires diponibles : "+this.getNbrExemplairesDispo());
        System.out.println(" - Nom du chanteur : "+this.chanteur);
    }

}
