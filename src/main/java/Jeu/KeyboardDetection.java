package Jeu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class TAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            Plateau.p.seDeplacer(Plateau.getInstance(), "Gauche");
        }

        if (key == KeyEvent.VK_RIGHT) {
            Plateau.p.seDeplacer(Plateau.getInstance(), "Droite");
        }

        if (key == KeyEvent.VK_UP){
            Plateau.p.seDeplacer(Plateau.getInstance(), "Haut");
        }

        if (key == KeyEvent.VK_DOWN) {
            Plateau.p.seDeplacer(Plateau.getInstance(), "Bas");
        }
    }
}