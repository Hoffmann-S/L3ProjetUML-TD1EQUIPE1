package Jeu;

public class HommePresse extends Personnage{
    public HommePresse(String s)
    {
        super(s, 100, 75, 75, 50);
    }

    public void seDeplacer(Plateau plateau) {
        this.moral -= 2;
    }
}
