package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author riepj9547
 */
public class FaceDrawing extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 500;
    static final int HEIGHT = 500;

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
    Color skin = new Color(232, 212, 143);
    Color skin2 = new Color(234, 201, 140);
    Color lip = new Color(237, 176, 156);
    Color lip2 = new Color(219, 146, 122);
    Color hair = new Color(96, 60, 28);
    Color hair2 = new Color(124, 78, 37);


    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public FaceDrawing(){
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
        
        gameTimer = new Timer(desiredTime,this);
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
        //draw a head in the midle of the screen
        g.setColor(skin);
        g.fillRect(110, 100, 150, 90);
        g.fillRect(120, 190, 130, 20);
        g.fillRect(130, 210, 110, 60);
        g.fillRect(140, 270, 90, 10);
        g.fillRect(150, 280, 70, 10);
        g.fillRect(160, 290, 50, 10);
        
        g.setColor(skin2);
        g.fillRect(170, 260, 20, 10);
        g.setColor(lip);
        g.fillRect(160, 250, 40, 10);
        g.fillRect(150, 240, 10, 10);
        g.fillRect(200, 240, 10, 10);
        g.setColor(lip2);
        g.fillRect(160, 240, 40, 10);
        
        g.setColor(lip);
        g.fillRect(170, 220, 10, 10);
        g.fillRect(170, 210, 10, 10);
        g.fillRect(190, 210, 10, 10);
        g.fillRect(160, 200, 40, 10);
        g.fillRect(160, 190, 30, 10);
        g.fillRect(160, 180, 30, 10);
        g.fillRect(160, 170, 30, 10);
        
        g.setColor(lip2);
        g.fillRect(160, 210, 10, 10);
        g.fillRect(180, 210, 10, 10);
        
        g.setColor(skin2);
	g.fillRect(140, 170, 20, 10);	
        g.fillRect(200, 170, 20, 10);
        
        g.setColor(lip);
        g.fillRect(220, 170, 10, 10);
        g.fillRect(130, 170, 10, 10);
        
        g.setColor(Color.BLACK);
        g.fillRect(130, 160, 30, 10);
        g.fillRect(200, 160, 30, 10);
        
        g.setColor(lip);
        g.fillRect(120, 160, 10, 10);
        g.fillRect(190, 160, 10, 10);
        g.fillRect(230, 160, 10, 10);
        g.fillRect(130, 150, 30, 10);
        g.fillRect(130, 140, 10, 10);
        g.fillRect(190, 150, 50, 10);
        g.fillRect(210, 140, 30, 10);
        
        g.setColor(hair2);
        g.fillRect(130, 130, 20, 10);
        g.fillRect(140, 140, 20, 10);
        g.fillRect(160, 150, 20, 10);
        g.fillRect(190, 140, 20, 10);
        g.fillRect(200, 130, 40, 10);
        g.fillRect(220, 120, 20, 10);
		
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        FaceDrawing game = new FaceDrawing();
    }
}

