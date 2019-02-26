import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Philip Tsvetanov
 */
public class PacMan extends JFrame
{

    JTextArea textField;
    Block[][] blocks;
    Timer timer;
    Block pacman = new Block("pacman-right");
    int pacmanX = 1;
    int pacmanY = 1;
    final int TIMER_DELAY = 1000;
    boolean allowMove = true;

    public PacMan()
    {
        Container container = getContentPane(); // reference to content pane of JFrame
        setTitle("PacMan"); // set title of frame
        setSize(450, 450); // set initial size of frame (x,y) in pixels

        textField = new JTextArea();
        textField.setEditable(false);
        textField.setFont(new Font("Courier New", Font.PLAIN, 12));
        container.add(textField);
        blocks = new Block[10][19];

        for (int x = 0; x < blocks.length; x++)
        {
            {
                for (int y = 0; y < blocks[x].length; y++)
                {
                    blocks[x][y] = new Block("dot");
                }
            }
        }

        for (int x = 0; x < blocks[0].length; x++)
        {
            blocks[0][x] = new Block("border-horiz");
            blocks[blocks.length - 1][x] = new Block("border-horiz");
        }

        for (int y = 0; y < blocks.length; y++)
        {
            blocks[y][0] = new Block("border-vert");
            blocks[y][blocks[0].length - 1] = new Block("border-vert");
        }

        blocks[2][2] = new Block("wall");
        blocks[2][3] = new Block("wall");
        blocks[2][5] = new Block("wall");
        blocks[2][6] = new Block("wall");
        blocks[2][7] = new Block("wall");
        blocks[1][9] = new Block("wall");
        blocks[2][9] = new Block("wall");
        blocks[2][12] = new Block("wall");
        blocks[2][11] = new Block("wall");
        blocks[2][13] = new Block("wall");
        blocks[2][15] = new Block("wall");
        blocks[2][16] = new Block("wall");
        blocks[4][15] = new Block("wall");
        blocks[4][16] = new Block("wall");
        blocks[4][2] = new Block("wall");
        blocks[4][3] = new Block("wall");
        blocks[4][5] = new Block("wall");
        blocks[4][8] = new Block("wall");
        blocks[4][9] = new Block("wall");
        blocks[4][10] = new Block("wall");
        blocks[4][13] = new Block("wall");
        blocks[5][13] = new Block("wall");
        blocks[6][13] = new Block("wall");
        blocks[5][12] = new Block("wall");
        blocks[5][5] = new Block("wall");
        blocks[5][6] = new Block("wall");
        blocks[6][5] = new Block("wall");
        blocks[6][1] = new Block("wall");
        blocks[6][2] = new Block("wall");
        blocks[6][3] = new Block("wall");
        blocks[8][1] = new Block("wall");
        blocks[8][2] = new Block("wall");
        blocks[8][3] = new Block("wall");
        blocks[6][17] = new Block("wall");
        blocks[6][15] = new Block("wall");
        blocks[6][16] = new Block("wall");
        blocks[8][16] = new Block("wall");
        blocks[8][15] = new Block("wall");
        blocks[8][17] = new Block("wall");
        
        textField.setText(drawScreen());

        timer = new Timer(TIMER_DELAY, (ActionEvent e) ->
        {
            if(allowMove){
                
            }
            textField.setText(drawScreen());
            allowMove = true;
        });

        timer.start();

        textField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (allowMove)
                {
                    //System.out.println(pacmanX + ", " + pacmanY);
                    int KeyCode = e.getKeyCode();
                    allowMove = false;

                    switch (KeyCode)
                    {
                        case KeyEvent.VK_LEFT:
                            if (pacmanY > 1)
                            {
                                if (blocks[pacmanX][pacmanY - 1].isPassable)
                                {
                                    pacmanMove(Directions.LEFT);
                                    pacman = new Block("pacman-left");
                                    blocks[pacmanX][pacmanY+1] = new Block("empty");
                                }
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (pacmanX < blocks[0].length - 1)
                            {
                                if (blocks[pacmanX][pacmanY + 1].isPassable)
                                {
                                    pacmanMove(Directions.RIGHT);
                                    pacman = new Block("pacman-right");
                                    blocks[pacmanX][pacmanY-1] = new Block("empty");
                                }
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (pacmanY > 1)
                            {
                                if (blocks[pacmanX - 1][pacmanY].isPassable)
                                {
                                    pacmanMove(Directions.UP);
                                    pacman = new Block("pacman-up");
                                    blocks[pacmanX+1][pacmanY] = new Block("empty");
                                }
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (pacmanY < blocks.length - 1)
                            {
                                if (blocks[pacmanX + 1][pacmanY].isPassable)
                                {
                                    pacmanMove(Directions.DOWN);
                                    pacman = new Block("pacman-down");
                                    blocks[pacmanX-1][pacmanY] = new Block("empty");
                                }
                            }
                            break;
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });

    }

    public String drawScreen()
    {
        blocks[pacmanX][pacmanY] = pacman;
        String screen = "";
        for (int y = 0; y < blocks.length; y++)
        {
            for (int bx = 0; bx < 3; bx++)
            {
                for (int x = 0; x < blocks[y].length; x++)
                {
                    screen += blocks[y][x].content.substring(0 + (bx * 3), 3 + (bx * 3)) + "";
                }
                screen += "\n";
            }
        }
        return screen;
    }

    public void pacmanMove(Directions dir)
    {
        switch (dir)
        {
            case LEFT:
                if (pacmanY > 0)
                {
                    pacmanY -= 1;
                }
                break;
            case RIGHT:
                if (pacmanY < blocks[0].length - 1)
                {
                    pacmanY += 1;
                }
                break;
            case DOWN:
                if (pacmanX < blocks.length - 1)
                {
                    pacmanX += 1;
                }
                break;
            case UP:
                if (pacmanX > 0)
                {
                    pacmanX -= 1;
                }
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        PacMan game = new PacMan();
        game.toFront();
        game.setState(Frame.NORMAL);
        game.setVisible(true);
        game.requestFocus();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
