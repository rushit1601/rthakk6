/**
 * Created by silversurfer on 4/28/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Tetris extends Canvas implements KeyListener, Runnable
{
    public static final int WIDTH = 400, HEIGHT = 600, MENUSPACE = 32;

    //KeyListener methods
    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    //Runnable methods
    public void run()
    {
        boolean running = true;
        while(running)
        {
            update();
            BufferStrategy buf = getBufferStrategy();
            if(buf == null)
            {
                createBufferStrategy(3);
                continue;
            }
            Graphics2D g = (Graphics2D)buf.getDrawGraphics();
            render(g);
            buf.show();
        }
    }

    public void start()
    {
        Thread t = new Thread(this);
        t.start();
    }

    public void update()
    {

    }

    public void render(Graphics2D g)
    {
        //make background black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Tetris", WIDTH/2 - 30, HEIGHT/8);
    }

    public static void main(String[] args)
    {

        //initialize JFrame
        JFrame frame = new JFrame("Tetris");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        //initialize menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, WIDTH, MENUSPACE);
        //create menu components
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        //add to menu components
        //file options
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("New Game!");
            }
        });
        JMenuItem highScore = new JMenuItem("High Score");

        highScore.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("High Score!");
                //get highscore
                int highscore = 0;

                //make frame
                JFrame highScoreFrame = new JFrame("High Score");
                highScoreFrame.setSize(WIDTH/2, HEIGHT/2);
                highScoreFrame.setLayout(null);
                highScoreFrame.setLocationRelativeTo(null);
                highScoreFrame.setResizable(false);

                //add score
                JLabel score = new JLabel("Highscore: " + highscore);
                score.setBounds(WIDTH/16, 0, WIDTH/4 - 15, HEIGHT/8);

                //add components
                JButton okayButton = new JButton("Okay");
                okayButton.setBounds(WIDTH/7, HEIGHT/3, WIDTH/5, HEIGHT/12);
                okayButton.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        highScoreFrame.dispose();
                    }
                });

                highScoreFrame.add(okayButton);
                highScoreFrame.add(score);
                highScoreFrame.setVisible(true);
            }
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Thanks for Playing!");
                System.exit(0);

            }
        });

        //add file options to file
        file.add(newGame);
        file.add(highScore);
        file.add(exit);
        //add components to menu bar
        menuBar.add(file);
        menuBar.add(help);


        //initalize Tetris and add it for the JFrame
        Tetris tetris = new Tetris();
        //MENUSPACE lower to make space for a menu
        tetris.setBounds(0, MENUSPACE, WIDTH, HEIGHT - MENUSPACE);

        //add components to menu bar
        frame.add(tetris);
        frame.add(menuBar);
        frame.setVisible(true);
        //start SINGLE Tetris thread
        tetris.start();
    }
}
