// import MG2D.*;
// import MG2D.geometrie.*;
import MG2D.geometrie.Point;

public class App {
    
    public static void main(String[] args) {
        Minesweeper m = new Minesweeper();
        
            m.window.rafraichir();
    
            while (true) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (m.mouse.getClicGauche()) {
                    Point positionMouse = new Point(m.mouse.getPosition());
                    int x = positionMouse.getX();
                    int y = positionMouse.getY();
                    if (m.menu) {
                        m = m.mg.menuOnClick(x, y, m);
                    }
                    else {
                        // Quit Game
                        if (x>0 && x<m.level.getSizeTile() && y>m.level.getHeightWindow()-m.level.getSizeTile() && y<m.level.getHeightWindow()) {
                            System.exit(0);
                        }
                        // Restart Game
                        if (x>m.level.getWidthWindow()-m.level.getSizeTile() && x<m.level.getWidthWindow() && y>m.level.getHeightWindow()-m.level.getSizeTile() && y<m.level.getHeightWindow()) {
                            m.mg.menuLevel(m.window, m.theme, m.level.getSizeTile(), m.level.getWidthWindow(), m.level.getHeightWindow());
                            m.menu = true;
                        }
                        else {
                            // The game is not over yet ==> continue
                            if (!m.end) {
                                if (x > 2*m.level.getSizeTile() && x < 3*m.level.getSizeTile() && y > m.level.getHeightWindow()-2*m.level.getSizeTile() && y < m.level.getHeightWindow()-m.level.getSizeTile()) {
                                    m.button = new Dig(true);
                                } else if (x > m.level.getWidthWindow()-3*m.level.getSizeTile() && x < m.level.getWidthWindow()-2*m.level.getSizeTile() && y > m.level.getHeightWindow()-2*m.level.getSizeTile() && y < m.level.getHeightWindow()-m.level.getSizeTile()) {
                                    m.button = new Flag(true);
                                } else if (x > 0 && x < m.level.getSizeTile() * m.level.getWidth() && y > 0 && y < m.level.getSizeTile()*m.level.getHeight()) {
                                    m.board.action(x, y, m.button, m.level.getSizeTile());
                                }
                                m.mg = new MainGraphic(m.window, m.board, m.button, m.level.getSizeTile(), m.level.getWidthWindow(), m.level.getHeightWindow(), m.theme);
                                // End of the game if Mine
                                m.end = m.board.endGameMine();
                                if (m.end) {
                                    m.mg.endOfTheGameMine(m.window, m.theme, m.level.getSizeTile(), m.level.getWidthWindow(), m.level.getHeightWindow());
                                }
                                else if (!m.end) {
                                    m.end = m.board.endGameWin();
                                    if (m.end) {
                                        m.mg.endOfTheGameWin(m.window, m.theme, m.level.getSizeTile(), m.level.getWidthWindow(), m.level.getHeightWindow());
                                    }
                                }
                                
                            }
                            // The game is over ==> restart or quit
                            else {
                                if (x > (m.level.getWidthWindow()/2 - 2*m.level.getSizeTile()) && x < (m.level.getWidthWindow()/2 - 2*m.level.getSizeTile()+4*m.level.getSizeTile()) && y > m.level.getHeightWindow()-2*m.level.getSizeTile() && y < m.level.getHeightWindow()-m.level.getSizeTile()) {
                                    m.board = new Board(m.level.getWidth(), m.level.getHeight(), m.level.getNbBombs());
                                    m.board.neighbourhood();
                                    m.button = new Dig(true);
                                    m.mg = new MainGraphic(m.window, m.board, m.button, m.level.getSizeTile(), m.level.getWidthWindow(), m.level.getHeightWindow(), m.theme);
                                    m.end = false;
                                }
                            }
                        }
                    }
                    m.window.rafraichir();
                }
            }
        }
    }