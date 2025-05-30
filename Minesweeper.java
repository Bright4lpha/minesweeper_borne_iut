import MG2D.Fenetre;
import MG2D.Souris;
import MG2D.audio.Musique;

public class Minesweeper {

    public Level level;
    public Fenetre window;
    public Board board;
    public Button button;
    public Souris mouse;
    public MainGraphic mg;
    public boolean end;
    public boolean menu;
    public Cursor cursor;
    public static KeyboardArcade keyboard;


    public Minesweeper() {
        Minesweeper.keyboard = new KeyboardArcade();
        this.level = new Basic();
        this.window = new Fenetre("Minesweeper", level.getWidthWindow(), level.getHeightWindow());
        this.window.addKeyListener(keyboard);
        this.board = new Board(level.getWidth(), level.getHeight(), level.getNbBombs());
        this.button = new Dig(true);
        this.mouse = window.getSouris();
        this.cursor = new Cursor(level.getSizeTile());
        this.mg = new MainGraphic(window, board, button, level.getSizeTile(), level.getWidthWindow(),
                level.getHeightWindow());
        this.end = false;
        this.menu = false;

    }

    public Minesweeper(Level level) {
        Minesweeper.keyboard = new KeyboardArcade();
        this.level = level;
        this.window = new Fenetre("Minesweeper", level.getWidthWindow(), level.getHeightWindow());
        this.window.addKeyListener(keyboard);
        this.board = new Board(level.getWidth(), level.getHeight(), level.getNbBombs());
        this.button = new Dig(true);
        this.mouse = window.getSouris();
        this.cursor = new Cursor(level.getSizeTile());
        this.mg = new MainGraphic(window, board, button, level.getSizeTile(), level.getWidthWindow(),
                level.getHeightWindow());
        this.end = false;
        this.menu = false;
    }

    public void newGame() {
        // Minesweeper.keyboard = new KeyboardArcade();
        this.level = new Basic();
        this.window = new Fenetre("Minesweeper", level.getWidthWindow(), level.getHeightWindow());
        this.window.addKeyListener(keyboard);
        this.board = new Board(level.getWidth(), level.getHeight(), level.getNbBombs());
        this.button = new Dig(true);
        this.mouse = window.getSouris();
        this.cursor = new Cursor(level.getSizeTile());
        this.mg = new MainGraphic(window, board, button, level.getSizeTile(), level.getWidthWindow(),
                level.getHeightWindow());
        this.end = false;
        this.menu = false;
    }
}