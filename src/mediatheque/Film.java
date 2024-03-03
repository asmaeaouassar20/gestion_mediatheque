package mediatheque;

public class Film extends Media{
    private String realisateur;


    public Film(String titre,int nbrExemplairesDispo,String realisateur){
        super(titre,nbrExemplairesDispo);
        this.realisateur=realisateur;
    }



    public boolean equals(Film film){
        if(this.getTitre().equals(film.getTitre()) && this.getNbrExemplairesDispo()==film.getNbrExemplairesDispo()  && this.realisateur.equals(realisateur) ){
            return true;
        }
        return false;
    }



    public void afficher(){
        System.out.println("- Titre du film : "+this.getTitre());
        System.out.println("- Nombre des exemplaires diponiblres : "+this.getNbrExemplairesDispo());
        System.out.println("- Nom du realisateur du film: "+this.realisateur);
    }


}
