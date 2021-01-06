package Jeu;

public class Standard extends Personnage{

    public Standard(String s){
        super(s, 300, 150, 150, 150);
    }

    @Override
    public void checkBarre() { //cette verification permet d'établir une limite sur les statistiques
        if(satiete > 150)
            satiete = 150;
        if(soif > 150)
            soif = 150;
        if(vie > 300)
            vie = 300;
        if(moral > 150)
            moral = 150;
        if(pourcentageDiplome > 100)
            pourcentageDiplome = 100;
    }

    public void seDeplacer(Plateau plateau, String direction) {
        if(Deplacement(plateau, direction)) {  //si le déplacement s'est bien éffectué alors retrait des points
            this.vie -= 1;
            this.moral -= 1;
            this.satiete -= 1;
            this.soif -= 1;
        }
        this.checkMort();
        this.checkBarre();
        Plateau.getInstance().repaint(); //permet de mettre à jour l'affichage
    }
}
