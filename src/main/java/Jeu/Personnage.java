package Jeu;

public abstract class Personnage {

    /**
     * position du personnage
     */
    protected static int PositionY = 5;
    protected static int PositionX = 1;
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

    public int getNbdiplome() {
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
    protected int nbdiplome;

    public Personnage(String pseudo, int vie, int satiete, int soif, int moral)
    {
        this.pseudo = pseudo;
        this.vie = vie;
        this.satiete = satiete;
        this.soif = soif;
        this.moral = moral;
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

    private void checkMort()
    {
        if(satiete == 0 || soif == 0 || vie == 0 || moral == 0)
            Plateau.inGame = false;
    }

    public void seDeplacer(Plateau plateau, String direction) {
                checkMort();
                System.out.println(vie);
                switch(direction)
                {
                    case "Gauche":
                        if(plateau.checkIsValid(PositionX-1, PositionY)) {
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                            PositionX -= 1;
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                        }
                        break;
                    case "Droite":
                        if(plateau.checkIsValid(PositionX+1, PositionY)) {
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                            PositionX += 1;
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                        }
                        break;
                    case "Haut":
                        if(plateau.checkIsValid(PositionX, PositionY-1)) {
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                            PositionY -= 1;
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                        }
                        break;
                    case "Bas":
                        if(plateau.checkIsValid(PositionX, PositionY+1)) {
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, false);
                            PositionY += 1;
                            Plateau.getInstance().updateContainPlayer(PositionX, PositionY, true);
                        }
                        break;
                }
                Plateau.getInstance().repaint();
            }

}