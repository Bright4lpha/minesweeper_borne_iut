import MG2D.Fenetre;
import MG2D.Souris;
public class Minesweeper {

    public Level level;
    public Fenetre window;
    public Board board;
    public Button button;
    public Souris mouse;
    public Theme theme;
    public MainGraphic mg;
    public boolean end;
    public boolean menu;

    public Minesweeper() {
        this.level = new Easy();
        this.window = new Fenetre("Minesweeper", level.getWidthWindow(), level.getHeightWindow());
        this.board = new Board(level.getWidth(), level.getHeight(), level.getNbBombs());
        this.button = new Dig(true);
        this.mouse = window.getSouris();
        this.theme = new Classic();
        this.mg = new MainGraphic(window, board, button, level.getSizeTile(), level.getWidthWindow(), level.getHeightWindow(), theme);
        this.end = false;
        this.menu = false;
    }

    public Minesweeper(Level level) {
        this.level = level;
        this.window = new Fenetre("Minesweeper", level.getWidthWindow(), level.getHeightWindow());
        this.board = new Board(level.getWidth(), level.getHeight(), level.getNbBombs());
        this.button = new Dig(true);
        this.mouse = window.getSouris();
        this.theme = new Classic();
        this.mg = new MainGraphic(window, board, button, level.getSizeTile(), level.getWidthWindow(), level.getHeightWindow(), theme);
        this.end = false;
        this.menu = false;
    }
}