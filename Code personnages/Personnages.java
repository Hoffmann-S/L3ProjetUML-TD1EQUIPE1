package Jeu;



public abstract class Personnage{

    /** position du personnage */
    protected abstract int PositionX();
    protected abstract int PositionY();

    protected abstract void SeDeplacer(Plateau plateau);
