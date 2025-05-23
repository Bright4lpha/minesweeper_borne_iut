
// import MG2D.*;
// import MG2D.geometrie.*;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

import MG2D.geometrie.Point;

public class App {

    private static KeyboardArcade keyboard;

    public static void main(String[] args) {
        Minesweeper m = new Minesweeper();
        keyboard = new KeyboardArcade();
        m.window.addKeyListener(keyboard);
        m.window.getP().addKeyListener(keyboard);

        m.window.rafraichir();

        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // exit
            if (keyboard.isButtonXTrigger()) {
                System.exit(0);
            }
            // TODO : Menu

            // Game
            if (!m.end) {
                // change to dig button
                if (keyboard.isButtonATrigger()) {
                    m.button = new Dig(true);
                    m.mg.update(m.window, m.board, m.button, m.level.getSizeTile(),
                            m.level.getWidthWindow(), m.level.getHeightWindow(), m.cursor);
                    m.window.rafraichir();
                }
                // change to flag button
                if (keyboard.isButtonBTrigger()) {
                    m.button = new Flag(true);
                    m.mg.update(m.window, m.board, m.button, m.level.getSizeTile(),
                            m.level.getWidthWindow(), m.level.getHeightWindow(), m.cursor);
                    m.window.rafraichir();
                }
                // move
                if (keyboard.isUpTrigger()) {
                    if (m.cursor.getY() < Constants.sizeTile * (Constants.height - 1)) {
                        m.cursor.moveUp();
                        m.mg.moveCursor(0, Constants.sizeTile);
                    }
                    m.window.rafraichir();
                }
                if (keyboard.isDownTrigger()) {
                    if (m.cursor.getY() > 0) {
                        m.cursor.moveDown();
                        m.mg.moveCursor(0, -Constants.sizeTile);
                    }
                    m.window.rafraichir();
                }
                if (keyboard.isLeftTrigger()) {
                    if (m.cursor.getX() > 0) {
                        m.cursor.moveLeft();
                        m.mg.moveCursor(-Constants.sizeTile, 0);
                    }
                    m.window.rafraichir();
                }
                if (keyboard.isRightTrigger()) {
                    if (m.cursor.getX() < Constants.sizeTile * (Constants.width - 1)) {
                        m.cursor.moveRight();
                        m.mg.moveCursor(Constants.sizeTile, 0);
                    }
                    m.window.rafraichir();
                }
                // Dig or flag
                if (keyboard.isButtonCTrigger()) {
                    m.board.action(m.cursor.getX(), m.cursor.getY(), m.button, m.level.getSizeTile());
                    m.mg.update(m.window, m.board, m.button, m.level.getSizeTile(),
                            m.level.getWidthWindow(), m.level.getHeightWindow(), m.cursor);
                    m.end = m.board.endGameMine();
                    if (m.end) {
                        m.mg.endOfTheGameMine(m.window, m.level.getSizeTile(),
                                m.level.getWidthWindow(),
                                m.level.getHeightWindow());
                    } else if (!m.end) {
                        m.end = m.board.endGameWin();
                        if (m.end) {
                            m.mg.endOfTheGameWin(m.window, m.level.getSizeTile(),
                                    m.level.getWidthWindow(),
                                    m.level.getHeightWindow());
                        }
                    }
                }
            } else {
                // End of the game
                // TODO score / replay
                if (keyboard.isButtonCTrigger()) {
                    m.board = new Board(m.level.getWidth(), m.level.getHeight(),
                            m.level.getNbBombs());
                    m.board.neighbourhood();
                    m.button = new Dig(true);
                    m.cursor = new Cursor(Constants.sizeTile);
                    m.mg = new MainGraphic(m.window, m.board, m.button, m.level.getSizeTile(),
                            m.level.getWidthWindow(), m.level.getHeightWindow(), m.cursor);
                    m.end = false;
                    m.window.rafraichir();
                }
            }
        }
    }
}