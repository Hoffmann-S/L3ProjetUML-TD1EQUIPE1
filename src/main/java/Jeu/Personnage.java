package Jeu;

public abstract class Personnage {

    /**
     * position du personnage
     */
    protected static int PositionY = 22;
    protected static int PositionX = 21;
    private String pseudo;

    public String getPseudo() {
        return pseudo;
    }

    public int getVie() {
        return vie;
    }

    public int getSatiete() {
        return satiete;
    }

    public int getSoif() {
        return soif;
    }

    public int getMoral() {
        return moral;
    }

    public static int getNbdiplome() {
        return nbdiplome;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setSatiete(int satiete) {
        this.satiete = satiete;
    }

    public void setSoif(int soif) {
        this.soif = soif;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public void setNbdiplome(int nbdiplome) {
        this.nbdiplome = nbdiplome;
    }

    protected int vie;
    protected int satiete;
    protected int soif;
    protected int moral;
    protected static int nbdiplome;
    protected boolean haveSwimsuit;
    protected boolean havePermis;
    protected double pourcentageDiplome;

    public Personnage(String pseudo, int vie, int satiete, int soif, int moral)
    {
        this.pseudo = pseudo;
        this.vie = vie;
        this.satiete = satiete;
        this.soif = soif;
        this.moral = moral;
        this.haveSwimsuit = false;
        this.havePermis = false;
        this.pourcentageDiplome = 30;
    }

    private static int getPositionX()
    {
        return PositionX;
    }

    private static int getPositionY()
    {
        return PositionY;
    }

    private static void setPositionX(int x)
    {
        PositionX = x;
    }

    private static void setPositionY(int y)
    {
        PositionX = y;
    }

    void checkMort()
    {
        if(satiete <= 0 || soif <= 0 || vie <= 0 || moral <= 0)
            Plateau.inGame = false;

    }

    public abstract void checkBarre();

    public void checkCase(Case c)
    {
        if(c instanceof Foret)
            Foret.tomberMalade(this);
        else if(c instanceof Maison)
            Maison.ressourcerPersonnage(this);
        else if(c instanceof Bibliotheque)
            Bibliotheque.trouverLivre(this);
        else if(c instanceof FastFood)
            FastFood.Manger(this);
        else if(c instanceof Universite)
            Universite.obtenirDiplome(this);
        else if(c instanceof Bar)
            Bar.Boire(this);
        else if(c instanceof Trottoir)
        {
            if(Math.random()<0.05)
            {
                double random = Math.random();
                if(random<0.33)
                {
                    vie -= 3;
                    System.out.println("Peau de banane!");
                }
                else if(random>0.33 && random <0.66)
                {
                    moral -= 2;
                    System.out.println("Poussette!");
                }
                else
                {
                    satiete -= 1;
                    System.out.println("Déjection canine!");
                }
            }
        }
        else if(c instanceof Route)
        {
            if(Math.random()<0.05)
            {
                double random = Math.random();
                if(random<0.33)
                {
                    vie -= 1;
                    System.out.println("Feu Rouge!");
                }
                else if(random>0.33 && random <0.66)
                {
                    moral -= 1;
                    System.out.println("Police!");
                }
                else
                {
                    satiete -= 2;
                    soif -= 2;
                    System.out.println("Nid de poule!");
                }
            }
        }
    }

    public boolean Deplacement(Plateau plateau, String direction)
    {
        boolean b = false;

        switch(direction)
        {
            case "Gauche":
                if(Plateau.getInstance().casePlateau[PositionY][PositionX-1] instanceof EtendueEau && haveSwimsuit == false)
                    b = false;

                else if(plateau.checkIsValid(PositionX-1, PositionY)) {
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                    PositionX -= 1;
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                    b = true;
                }
                break;
            case "Droite":
                if(Plateau.getInstance().casePlateau[PositionY][PositionX+1] instanceof EtendueEau && haveSwimsuit == false)
                    b = false;
                else if(plateau.checkIsValid(PositionX+1, PositionY)) {
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                    PositionX += 1;
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                    b = true;
                }
                break;

            case "Haut":
                if(Plateau.getInstance().casePlateau[PositionY-1][PositionX] instanceof EtendueEau && haveSwimsuit == false)
                    b = false;
                else if(plateau.checkIsValid(PositionX, PositionY-1)) {
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                    PositionY -= 1;
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                    b = true;
                }
                break;
            case "Bas":
                if(Plateau.getInstance().casePlateau[PositionY+1][PositionX] instanceof EtendueEau && haveSwimsuit == false)
                    b = false;
                else if(plateau.checkIsValid(PositionX, PositionY+1)) {
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                    PositionY += 1;
                    Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                    b = true;
                }
                break;
        }
        checkCase(Plateau.getInstance().casePlateau[PositionY][PositionX]);
        return b;
    }

    public abstract void seDeplacer(Plateau plateau, String direction);

}