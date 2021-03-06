package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.util.Scanner;
import javax.swing.Timer;

/**
 *
 * @author riepj9547
 */
public class DrawingThing extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 2800;
    static final int HEIGHT = 2800;
    //Title of the window
    String title = "My Game";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    int[] sizeX = new int[1000];
    int[] sizeY = new int[1000];   
    int currentSizeX = 10;
    int currentSizeY = 10;
    int mX = 0;
    int mY = 0;
    int[] x = new int[1000];
    int[] y = new int[1000];
    int[] colourChoosen = new int[1000];
    int points = 1;
    boolean stretchY = false;
    boolean stretchX = false;
    int camX = 0;
    int camY = 0;
    boolean moveUp = false;
    boolean moveDown = false;
    boolean moveLeft = false;
    boolean moveRight = false;
    int numBlocks = 1;
    int numBlocksLoad = 0;
    boolean endDrawing = false;
    Color colourSelect = new Color(0,0,0);
    int colourNum = 1;
    Rectangle[] Blocks = new Rectangle[1000];

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public DrawingThing() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        preSetup();
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        
        g.setColor(colourSelect);
        //HUD
        g.drawString("Colour Wheel is the number keys!!!", 20, 20);
        //track creator
        for (int i = 0; i < numBlocksLoad; i++) {
            if (Blocks[i] != null) {
                if(colourChoosen[i]==1){
                colourSelect = new Color(0,0,0);
              g.setColor(colourSelect);  
            }else if(colourChoosen[i]==2){
                colourSelect = new Color(255,0,0);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==3){
                colourSelect = new Color(0,0,255);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==4){
                colourSelect = new Color(0,255,0);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==5){
                colourSelect = new Color(255,0,255);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==6){
                colourSelect = new Color(0,255,135);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==7){
                colourSelect = new Color(255,136,0);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==8){
                colourSelect = new Color(0,161,255);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==9){
                colourSelect = new Color(137,137,137);
              g.setColor(colourSelect);
            }
                g.fillRect(Blocks[i].x - camX, Blocks[i].y - camY, Blocks[i].width, Blocks[i].height);
            }

        }
        g.setColor(Color.BLUE);
        g.fillRect(328 - camX, 272 - camY, 12, 15);
        for (int i = 0; i < points; i++) {
            if(colourChoosen[i]==1){
                colourSelect = new Color(0,0,0);
              g.setColor(colourSelect);  
            }else if(colourChoosen[i]==2){
                colourSelect = new Color(255,0,0);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==3){
                colourSelect = new Color(0,0,255);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==4){
                colourSelect = new Color(0,255,0);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==5){
                colourSelect = new Color(255,0,255);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==6){
                colourSelect = new Color(0,255,135);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==7){
                colourSelect = new Color(255,136,0);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==8){
                colourSelect = new Color(0,161,255);
              g.setColor(colourSelect);
            }else if(colourChoosen[i]==9){
                colourSelect = new Color(137,137,137);
              g.setColor(colourSelect);
            }                      
            g.fillRect(x[i] - (sizeX[i] / 2) - camX, y[i] - (sizeY[i] / 2) - camY, sizeX[i], sizeY[i]);

        }
        if(colourNum==1){
                colourSelect = new Color(0,0,0);
              g.setColor(colourSelect);  
            }else if(colourNum==2){
                colourSelect = new Color(255,0,0);
              g.setColor(colourSelect);
            }else if(colourNum==3){
                colourSelect = new Color(0,0,255);
              g.setColor(colourSelect);
            }else if(colourNum==4){
                colourSelect = new Color(0,255,0);
              g.setColor(colourSelect);
            }else if(colourNum==5){
                colourSelect = new Color(255,0,255);
              g.setColor(colourSelect);
            }else if(colourNum==6){
                colourSelect = new Color(0,255,135);
              g.setColor(colourSelect);
            }else if(colourNum==7){
                colourSelect = new Color(255,136,0);
              g.setColor(colourSelect);
            }else if(colourNum==8){
                colourSelect = new Color(0,161,255);
              g.setColor(colourSelect);
            }else if(colourNum==9){
                colourSelect = new Color(137,137,137);
              g.setColor(colourSelect);
            }         
        g.fillRect(mX - (currentSizeX / 2), mY - (currentSizeY / 2), currentSizeX, currentSizeY);
        if (endDrawing == true) {
            g.drawString("DONE", 50, 50);
        }


        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        for (int i = 0; i < sizeX.length; i++) {
            sizeX[i] = currentSizeX;
        }
        for (int i = 0; i < sizeY.length; i++) {
            sizeY[i] = currentSizeY;
        }
        Scanner in = null;
        try {
            in = new Scanner(new File("Test"));
        } catch (Exception e) {
            // e.printStackTrace();
        }
        numBlocksLoad = in.nextInt();
        points = numBlocksLoad;
        numBlocks = numBlocksLoad;
        in.nextLine();

        for (int i = 0; i < numBlocksLoad; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            int h = in.nextInt();
            int c = in.nextInt();            
            Blocks[i] = new Rectangle(x, y, w, h);
            colourChoosen[i] = c;

        }
        in.close();
        try {
            in = new Scanner(new File("Test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int buf1 = in.nextInt();
        for (int i = 0; i < numBlocksLoad; i++) {

            System.out.print(in.nextInt());
            System.out.print(" ");
            System.out.print(in.nextInt());
            System.out.print(" ");
            System.out.print(in.nextInt());
            System.out.print(" ");
            System.out.print(in.nextInt());
            System.out.print(" ");
            System.out.print(in.nextInt());                       
            System.out.println("");

        }

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        if (moveUp == true) {
            camY = camY - 2;
        }
        if (moveDown == true) {
            camY = camY + 2;
        }
        if (moveLeft == true) {
            camX = camX - 2;
        }
        if (moveRight == true) {
            camX = camX + 2;
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            x[points] = mX + camX;
            y[points] = mY + camY;
            colourChoosen[points] = colourNum;
            if(colourChoosen[points]==1){
                colourSelect = new Color(0,0,0);               
            }else if(colourChoosen[points]==2){
                colourSelect = new Color(255,0,0);              
            }else if(colourChoosen[points]==3){
                colourSelect = new Color(0,0,255);              
            }else if(colourChoosen[points]==4){
                colourSelect = new Color(0,255,0);              
            }else if(colourChoosen[points]==5){
                colourSelect = new Color(255,0,255);              
            }else if(colourChoosen[points]==6){
                colourSelect = new Color(0,255,135);             
            }else if(colourChoosen[points]==7){
                colourSelect = new Color(255,136,0);             
            }else if(colourChoosen[points]==8){
                colourSelect = new Color(0,161,255);             
            }else if(colourChoosen[points]==9){
                colourSelect = new Color(137,137,137);             
            }
            points++;
            numBlocks++;

            System.out.println((mX - currentSizeX / 2 + camX) + " " + (mY - currentSizeY / 2 + camY) + " " + currentSizeX + " " + currentSizeY + " "+ colourNum);
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() > 0 && stretchX == true) {
                currentSizeX = currentSizeX + 2;
                sizeX[points] = currentSizeX;
                for (int i = points; i < sizeX.length; i++) {
                    sizeX[i] = currentSizeX;
                }
            } else if (e.getWheelRotation() > 0 && stretchY == true) {
                currentSizeY = currentSizeY + 2;
                sizeY[points] = currentSizeY;
                for (int i = points; i < sizeY.length; i++) {
                    sizeY[i] = currentSizeY;
                }
            } else if (e.getWheelRotation() > 0 && stretchX == false && stretchY == false) {
                currentSizeX = currentSizeX + 2;
                sizeX[points] = currentSizeX;
                for (int i = points; i < sizeX.length; i++) {
                    sizeX[i] = currentSizeX;
                }
                currentSizeY = currentSizeY + 2;
                sizeY[points] = currentSizeY;
                for (int i = points; i < sizeY.length; i++) {
                    sizeY[i] = currentSizeY;
                }
            }
            if (e.getWheelRotation() < 0 && stretchX == true) {
                currentSizeX = currentSizeX - 2;
                sizeX[points] = currentSizeX;
                for (int i = points; i < sizeX.length; i++) {
                    sizeX[i] = currentSizeX;
                }
            } else if (e.getWheelRotation() < 0 && stretchY == true) {
                currentSizeY = currentSizeY - 2;
                sizeY[points] = currentSizeY;
                for (int i = points; i < sizeY.length; i++) {
                    sizeY[i] = currentSizeY;
                }
            } else if (e.getWheelRotation() < 0 && stretchX == false && stretchY == false) {
                currentSizeX = currentSizeX - 2;
                sizeX[points] = currentSizeX;
                for (int i = points; i < sizeX.length; i++) {
                    sizeX[i] = currentSizeX;
                }
                currentSizeY = currentSizeY - 2;
                sizeY[points] = currentSizeY;
                for (int i = points; i < sizeY.length; i++) {
                    sizeY[i] = currentSizeY;
                }
            }
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
            mX = e.getX();
            mY = e.getY();
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                moveUp = true;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                moveDown = true;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                moveLeft = true;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                moveRight = true;
            }
            if (keyCode == KeyEvent.VK_SHIFT) {
                stretchY = true;
            }
            if (keyCode == KeyEvent.VK_CONTROL) {
                stretchX = true;
            }
            if (keyCode == KeyEvent.VK_ENTER) {
                endDrawing = true;
                System.out.println(numBlocks);
            }
            //colour stuff
            if (keyCode == KeyEvent.VK_1) {
                colourSelect = new Color(0,0,0);
                colourNum = 1;
            }
            if (keyCode == KeyEvent.VK_2) {
                colourSelect = new Color(255,0,0);
                colourNum = 2;
            }
            if (keyCode == KeyEvent.VK_3) {
                colourSelect = new Color(0,0,255);
                colourNum = 3;
            }
            if (keyCode == KeyEvent.VK_4) {
                colourSelect = new Color(0,255,0);
                colourNum = 4;
            }
            if (keyCode == KeyEvent.VK_5) {
                colourSelect = new Color(255,0,255);
                colourNum = 5;
            }
            if (keyCode == KeyEvent.VK_6) {
                colourSelect = new Color(0,255,135);
                colourNum = 6;
            }
            if (keyCode == KeyEvent.VK_7) {
                colourSelect = new Color(255,136,0);
                colourNum = 7;
            }
            if (keyCode == KeyEvent.VK_8) {
                colourSelect = new Color(0,161,255);
                colourNum = 8;
            }
            if (keyCode == KeyEvent.VK_9) {
                colourSelect = new Color(137,137,137);
                colourNum = 9;
            }


        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                moveUp = false;
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                moveDown = false;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                moveLeft = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                moveRight = false;
            }
            if (keyCode == KeyEvent.VK_SHIFT) {
                stretchY = false;
            }
            if (keyCode == KeyEvent.VK_CONTROL) {
                stretchX = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        DrawingThing game = new DrawingThing();
    }
}
