import MG2D.Fenetre;
import MG2D.Souris;

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

    public void move(KeyboardArcade keyboard) {
        // if (keyboard.isButtonA()) {
        // System.out.println("A");
        // }
        // if (keyboard.isButtonB()) {
        // System.out.println("B");
        // }
        // if (keyboard.isButtonC()) {
        // System.out.println("C");
        // }
        // if (keyboard.isButtonX()) {
        // System.out.println("X");
        // }
        // if (keyboard.isButtonY()) {
        // System.out.println("Y");
        // }
        // if (keyboard.isButtonZ()) {
        // System.out.println("Z");
        // }
        // if (keyboard.isUp()) {
        // System.out.println("UP");
        // }
        // if (keyboard.isDown()) {
        // System.out.println("DOWN");
        // }
        // if (keyboard.isLeft()) {
        // System.out.println("LEFT");
        // }
        // if (keyboard.isRight()) {
        // System.out.println("RIGHT");
        // }
        if (keyboard.isButtonATrigger()) {
            System.out.println("A Trigger");
        }
        if (keyboard.isButtonBTrigger()) {
            System.out.println("B Trigger");
        }
        if (keyboard.isButtonCTrigger()) {
            System.out.println("C Trigger");
        }
        if (keyboard.isButtonXTrigger()) {
            System.out.println("X Trigger");
        }
        if (keyboard.isButtonYTrigger()) {
            System.out.println("Y Trigger");
        }
        if (keyboard.isButtonZTrigger()) {
            System.out.println("Z Trigger");
        }
        if (keyboard.isUpTrigger()) {
            System.out.println("UP Trigger");
        }
        if (keyboard.isDownTrigger()) {
            System.out.println("DOWN Trigger");
        }
        if (keyboard.isLeftTrigger()) {
            System.out.println("LEFT Trigger");
        }
        if (keyboard.isRightTrigger()) {
            System.out.println("RIGHT Trigger");
        }
    }
}