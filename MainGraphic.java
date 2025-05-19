import java.awt.Font;

import MG2D.Couleur;
import MG2D.Fenetre;
import MG2D.geometrie.Point;
import MG2D.geometrie.Rectangle;
import MG2D.geometrie.Texte;
import MG2D.geometrie.Texture;

public class MainGraphic {

    private static Font calibri = new Font("Calibri", Font.TYPE1_FONT, 40);
    
    public MainGraphic(Fenetre window, Board board, Button b, int sizeTile, int width, int height, Theme theme) {
        window.effacer();
        window.ajouter(new Texture("./assets/classic/Minesweeper_background.png", new Point(0, 0), width, height));
        // window.ajouter(new Texture(theme.getBackground(), new Point(0, 0), width, height));
        int x = board.getWidth();
        int y = board.getHeight();
        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                for (Tile c : board.getTiles()) {
                    if (c.getX() == i && c.getY() == j) {
                        window.ajouter(c.displayGraphic(theme, sizeTile));
                    }
                }
            }
        }
        // Buttons
        window.ajouter(new Texture(theme.getDig(), new Point(2*sizeTile, height-2*sizeTile), sizeTile, sizeTile));
        window.ajouter(new Texture(theme.getFlag(), new Point(width - 3*sizeTile,height-2*sizeTile), sizeTile, sizeTile));
        window.ajouter(b.selection(sizeTile, width, height, theme));
        
        // Quit
        window.ajouter(new Texture(theme.getQuit(), new Point(0,height-sizeTile), sizeTile, sizeTile));
        // Restart
        window.ajouter(new Texture(theme.getRestart(), new Point(width-sizeTile,height-sizeTile), sizeTile, sizeTile));
        
        // Display the number of bombs
        window.ajouter(new Texture(theme.getBomb(), new Point(width/2-sizeTile,height-sizeTile), sizeTile, sizeTile));
        window.ajouter (new Texte (Couleur.ROUGE, new String (""+board.getNbBombs()), calibri, new Point(width/2+sizeTile, height-sizeTile+sizeTile/2)));
    }

    public void endOfTheGameMine(Fenetre window, Theme theme, int sizeTile, int width, int height) {
        window.ajouter(new Texture(theme.getLose(), new Point(width/2 - 2*sizeTile, height-2*sizeTile), 4*sizeTile, sizeTile));
    }

    public void endOfTheGameWin(Fenetre window, Theme theme, int sizeTile, int width, int height) {
        window.ajouter(new Texture(theme.getWin(), new Point(width/2 - 2*sizeTile, height-2*sizeTile), 4*sizeTile, sizeTile));    
    }

    public void menuLevel(Fenetre window, Theme theme, int sizeTile, int width, int height) {
        window.ajouter(new Rectangle(Couleur.BLEU, new Point(width-3*sizeTile, 0), 3*sizeTile, height, true));
        window.ajouter(new Texture(theme.getLevelEasy(), new Point(width-3*sizeTile+sizeTile, height-2*sizeTile), sizeTile, sizeTile));
        window.ajouter(new Texture(theme.getLevelMedium(), new Point(width-3*sizeTile+sizeTile, height-5*sizeTile), sizeTile, sizeTile));
        window.ajouter(new Texture(theme.getLevelHard(), new Point(width-3*sizeTile+sizeTile, height-8*sizeTile), sizeTile, sizeTile));   
    }

    public Minesweeper menuOnClick(int x, int y, Minesweeper m) {
        Minesweeper ms = m;
        // Easy Button
        if (x>m.level.getWidthWindow()-2*m.level.getSizeTile() && x<m.level.getWidthWindow()-m.level.getSizeTile() &&
            y>m.level.getHeightWindow()-2*m.level.getSizeTile() &&
            y<m.level.getHeightWindow()-m.level.getSizeTile()) {
                m.window.fermer();
                ms = new Easy().onClick();
        }
        // Medium Button
        if (x>m.level.getWidthWindow()-2*m.level.getSizeTile() && x<m.level.getWidthWindow()-m.level.getSizeTile() &&
            y>m.level.getHeightWindow()-5*m.level.getSizeTile() &&
            y<m.level.getHeightWindow()-4*m.level.getSizeTile()) {
                m.window.fermer();
                ms = new Medium().onClick();
        }
        // Hard Button
        if (x>m.level.getWidthWindow()-2*m.level.getSizeTile() && x<m.level.getWidthWindow()-m.level.getSizeTile() &&
            y>m.level.getHeightWindow()-8*m.level.getSizeTile() &&
            y<m.level.getHeightWindow()-7*m.level.getSizeTile()) {
                m.window.fermer();
                ms = new Hard().onClick();
        }
        return ms;
    }
}
