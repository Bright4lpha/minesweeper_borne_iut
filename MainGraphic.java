import java.awt.Font;
import java.util.ArrayList;

import MG2D.Couleur;
import MG2D.Fenetre;
import MG2D.geometrie.Point;
import MG2D.geometrie.Rectangle;
import MG2D.geometrie.Texte;
import MG2D.geometrie.Texture;

public class MainGraphic {

    private static Font calibri = new Font("Calibri", Font.TYPE1_FONT, 40);
    private Texture cursorTexture = Cursor.cursorTexture();
    private Texture buttonSelect = new Texture("./img/Minesweeper_button_select.png",
            new Point(2 * Constants.sizeTile, Constants.screenHeight - 2 * Constants.sizeTile), Constants.sizeTile,
            Constants.sizeTile);

    public Menu menu = new Menu();
    public Rectangle cursorMenuTexture = new Rectangle(Couleur.BLANC, new Point(437, 550), 400, 100, false);

    public MainGraphic(Fenetre window, Board board, Button b, int sizeTile, int width, int height) {
        window.effacer();
        // Background
        window.ajouter(new Texture("./img/Minesweeper_background.png", new Point(0, 0), width, height));

        // Board Game
        int x = board.getWidth();
        int y = board.getHeight();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (Tile c : board.getTiles()) {
                    if (c.getX() == i && c.getY() == j) {
                        window.ajouter(c.displayGraphic(sizeTile));
                    }
                }
            }
        }
        // Buttons
        window.ajouter(new Texture("./img/Minesweeper_questionmark.png",
                new Point(2 * sizeTile, height - 2 * sizeTile), sizeTile, sizeTile));
        window.ajouter(new Texture("./img/Minesweeper_flag.png",
                new Point(width - 3 * sizeTile, height - 2 * sizeTile), sizeTile,
                sizeTile));
        window.ajouter(buttonSelect);

        // Cursor
        window.ajouter(cursorTexture);

        // Quit
        window.ajouter(new Texture("./img/Minesweeper_cross.png", new Point(0, height - sizeTile), sizeTile, sizeTile));
        // Restart
        window.ajouter(new Texture("./img/Minesweeper_arrow.png", new Point(width -
                sizeTile, height - sizeTile),
                sizeTile, sizeTile));

        // Display the number of bombs
        window.ajouter(new Texture("./img/Minesweeper_bomb.png", new Point(width / 2 - sizeTile, height - sizeTile),
                sizeTile, sizeTile));
        window.ajouter(new Texte(Couleur.ROUGE, new String("" + board.getNbBombs()), calibri,
                new Point(width / 2 + sizeTile, height - sizeTile + sizeTile / 2)));
    }

    public void openAfterMenu(Fenetre window, Board board, Button b, int sizeTile, int width, int height) {
        window.effacer();
        // Background
        window.ajouter(new Texture("./img/Minesweeper_background.png", new Point(0, 0), width, height));

        // Board Game
        int x = board.getWidth();
        int y = board.getHeight();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (Tile c : board.getTiles()) {
                    if (c.getX() == i && c.getY() == j) {
                        window.ajouter(c.displayGraphic(sizeTile));
                    }
                }
            }
        }
        // Buttons
        window.ajouter(new Texture("./img/Minesweeper_questionmark.png",
                new Point(2 * sizeTile, height - 2 * sizeTile), sizeTile, sizeTile));
        window.ajouter(new Texture("./img/Minesweeper_flag.png",
                new Point(width - 3 * sizeTile, height - 2 * sizeTile), sizeTile,
                sizeTile));
        window.ajouter(buttonSelect);

        // Cursor
        window.ajouter(cursorTexture);

        // Quit
        window.ajouter(new Texture("./img/Minesweeper_cross.png", new Point(0, height - sizeTile), sizeTile, sizeTile));
        // Restart
        window.ajouter(new Texture("./img/Minesweeper_arrow.png", new Point(width -
                sizeTile, height - sizeTile),
                sizeTile, sizeTile));

        // Display the number of bombs
        window.ajouter(new Texture("./img/Minesweeper_bomb.png", new Point(width / 2 - sizeTile, height - sizeTile),
                sizeTile, sizeTile));
        window.ajouter(new Texte(Couleur.ROUGE, new String("" + board.getNbBombs()), calibri,
                new Point(width / 2 + sizeTile, height - sizeTile + sizeTile / 2)));
    }

    public void openRules(Fenetre window, int width, int height) {
        window.effacer();
        // Rules
        window.ajouter(new Texture("./img/rules.png", new Point(0, 0), width, height));
    }

    /**
     * Update the board of the game
     * 
     * @param window
     * @param board
     */
    public void update(Fenetre window, Board board) {
        System.out.println("Update");
        // Display discovered tiles
        for (Tile c : board.getDiscoveredTiles()) {
            window.ajouter(c.displayGraphic(Constants.sizeTile));
        }
        // Clean list of discovered tiles
        board.clearDiscoveredTiles();
        window.ajouter(cursorTexture);
        window.rafraichir();
    }

    public void endOfTheGameMine(Fenetre window, int sizeTile, int width, int height) {
        window.ajouter(new Texture("./img/Minesweeper_lose.png",
                new Point(width / 2 - 4 * sizeTile, height - 3 * sizeTile), 8 * sizeTile, 2 * sizeTile));
    }

    public void endOfTheGameWin(Fenetre window, int sizeTile, int width, int height) {
        window.ajouter(new Texture("./img/Minesweeper_win.png",
                new Point(width / 2 - 4 * sizeTile, height - 3 * sizeTile), 8 * sizeTile, 2 * sizeTile));
    }

    public void menuLevel(Fenetre window, int sizeTile, int width, int height) {
        // window.ajouter(new Rectangle(Couleur.BLEU, new Point(width - 3 * sizeTile,
        // 0), 3 * sizeTile, height, true));
        // window.ajouter(new Texture("./img/Level_easy.png",
        // new Point(width - 3 * sizeTile + sizeTile, height - 2 * sizeTile), sizeTile,
        // sizeTile));
        // window.ajouter(new Texture("./img/Level_medium.png",
        // new Point(width - 3 * sizeTile + sizeTile, height - 5 * sizeTile), sizeTile,
        // sizeTile));
        // window.ajouter(new Texture("./img/Level_hard.png",
        // new Point(width - 3 * sizeTile + sizeTile, height - 8 * sizeTile), sizeTile,
        // sizeTile));

        window.ajouter(new Rectangle(Couleur.BLEU, new Point(0, 0), width, height, true));
    }

    public void menu(Fenetre window, int sizeTile, int width, int height) {
        this.menu.display(window, sizeTile, width, height);
        window.ajouter(cursorMenuTexture);
    }

    public Minesweeper menuOnClick(int x, int y, Minesweeper m) {
        Minesweeper ms = m;
        // Easy Button
        if (x > m.level.getWidthWindow() - 2 * m.level.getSizeTile()
                && x < m.level.getWidthWindow() - m.level.getSizeTile() &&
                y > m.level.getHeightWindow() - 2 * m.level.getSizeTile() &&
                y < m.level.getHeightWindow() - m.level.getSizeTile()) {
            m.window.fermer();
            ms = new Easy().onClick();
        }
        // Medium Button
        if (x > m.level.getWidthWindow() - 2 * m.level.getSizeTile()
                && x < m.level.getWidthWindow() - m.level.getSizeTile() &&
                y > m.level.getHeightWindow() - 5 * m.level.getSizeTile() &&
                y < m.level.getHeightWindow() - 4 * m.level.getSizeTile()) {
            m.window.fermer();
            ms = new Medium().onClick();
        }
        // Hard Button
        if (x > m.level.getWidthWindow() - 2 * m.level.getSizeTile()
                && x < m.level.getWidthWindow() - m.level.getSizeTile() &&
                y > m.level.getHeightWindow() - 8 * m.level.getSizeTile() &&
                y < m.level.getHeightWindow() - 7 * m.level.getSizeTile()) {
            m.window.fermer();
            ms = new Hard().onClick();
        }
        return ms;
    }

    public void changeButton(Button b) {
        // window.ajouter(b.selection(sizeTile, width, height));
        if (b instanceof Dig) {
            this.buttonSelect.translater(-20 * Constants.sizeTile, 0);
        } else if (b instanceof Flag) {
            this.buttonSelect.translater(20 * Constants.sizeTile, 0);
        }
    }

    public void moveCursor(int x, int y) {
        this.cursorTexture.translater(x, y);
    }

    public void moveUpMenuCursor() {
        this.menu.moveUpMenuCursor(this);
    }

    public void moveDownMenuCursor() {
        this.menu.moveDownMenuCursor(this);
    }
}
