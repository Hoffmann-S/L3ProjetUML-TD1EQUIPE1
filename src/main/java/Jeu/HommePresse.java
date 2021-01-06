package Jeu;

public class HommePresse extends Personnage{
    public HommePresse(String s)
    {
        super(s, 400, 150, 150, 100);
    }

    @Override
    public void checkBarre() {  //cette verification permet d'établir une limite sur les statistiques
        if(satiete > 150)
            satiete = 150;
        if(soif > 150)
            soif = 150;
        if(vie > 400)
            vie = 400;
        if(moral > 100)
            moral = 100;
        if(pourcentageDiplome > 100)
            pourcentageDiplome = 100;
    }

    public void seDeplacer(Plateau plateau, String direction) {
        if(Deplacement(plateau, direction))  //si le déplacement s'est bien éffectué alors retrait des points
            this.moral -= 2;
        this.checkMort();
        this.checkBarre();
        Plateau.getInstance().repaint(); //permet de mettre à jour l'affichage
    }
}
