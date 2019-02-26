import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
/*
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
        blocks = new Block[10][20];

        for (int x = 0; x < blocks.length; x++)
        {
            {
                for (int y = 0; y < blocks[0].length; y++)
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

        textField.setText(drawScreen());

        timer = new Timer(TIMER_DELAY, (ActionEvent e) ->
        {
            if (allowMove)
            {
                pContinue(pacmanX, pacmanY);
            }
            textField.setText(drawScreen());
            allowMove = true;
        });        

        textField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (!timer.isRunning()){
                    timer.start();
                }
                
                if (allowMove)
                {
                    System.out.println(pacmanX + ", " + pacmanY);
                    int KeyCode = e.getKeyCode();
                    allowMove = false;

                    switch (KeyCode)
                    {
                        case KeyEvent.VK_LEFT:
                            goLeft(pacmanX, pacmanY);
                            break;
                        case KeyEvent.VK_RIGHT:
                            goRight(pacmanX, pacmanY);
                            break;
                        case KeyEvent.VK_UP:
                            goUp(pacmanX, pacmanY);
                            break;
                        case KeyEvent.VK_DOWN:
                            goDown(pacmanX, pacmanY);
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

    public void goLeft(int x, int y)
    {
        if (x > 1)
        {
            if (blocks[x][y - 1].isPassable)
            {
                String temp = blocks[x][y].type;
                if(temp.substring(0,6).equals("pacman")){
                    blocks[x][y-1] = new Block("pacman-left");
                    pacmanX = x;
                    pacmanY = y-1;
                    blocks[x][y] = new Block("empty");
                } 
            }
        }
    }

    public void goUp(int x, int y)
    {
        if (y > 1)
        {
            if (blocks[x - 1][y].isPassable)
            {
                String temp = blocks[x][y].type;
                if(temp.substring(0,6).equals("pacman")){
                    blocks[x-1][y] = new Block("pacman-up");
                    pacmanX = x-1;
                    pacmanY = y;
                    blocks[x][y] = new Block("empty");
                } 
            }
        }
    }

    public void goRight(int x, int y)
    {
        if (x < blocks[0].length - 1)
        {
            if (blocks[x][y + 1].isPassable)
            {
                String temp = blocks[x][y].type;
                if(temp.substring(0,6).equals("pacman")){
                    blocks[x][y+1] = new Block("pacman-right");
                    pacmanX = x;
                    pacmanY = y+1;
                    blocks[x][y] = new Block("empty");
                } 
            }
        }
    }

    public void goDown(int x, int y)
    {
        if (y < blocks.length - 1)
        {
            if (blocks[x + 1][y].isPassable)
            {
                String temp = blocks[x][y].type;
                if(temp.substring(0,6).equals("pacman")){
                    blocks[x+1][y] = new Block("pacman-down");
                    System.out.println(blocks[x+1][y].type);
                    pacmanX = x+1;
                    pacmanY = y;
                    blocks[x][y] = new Block("empty");
                }  
            }
        }
    }
    
    public void pContinue(int x, int y){
        if (blocks[x][y].type.equals("pacman-left")){
            goLeft(x,y);
        }
        else if (blocks[x][y].type.equals("pacman-right")){
            goRight(x,y);
        }
        else if (blocks[x][y].type.equals("pacman-up")){
            goUp(x,y);
        }
        else if (blocks[x][y].type.equals("pacman-down")){
            goDown(x,y);
        }
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



    public static void main(String[] args)
    {
        PacMan game = new PacMan();
        game.toFront();
        game.setState(Frame.NORMAL);
        game.setVisible(true);
        game.requestFocus();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
*/